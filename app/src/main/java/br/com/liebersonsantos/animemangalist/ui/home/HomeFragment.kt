package br.com.liebersonsantos.animemangalist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.liebersonsantos.animemangalist.data.core.Resource
import br.com.liebersonsantos.animemangalist.data.model.Top
import br.com.liebersonsantos.animemangalist.databinding.FragmentHomeBinding
import br.com.liebersonsantos.animemangalist.ui.adapter.TopAdapter
import br.com.liebersonsantos.animemangalist.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var topAdapter: TopAdapter
    private var topList = mutableListOf<Top>()
    private var pastVisiblesItems = 0
    private var totalItemCount = 0
    private var loading = false
    private var pageLoad = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setRv()



        getTop(pageLoad)
        observeVMEvents()



    }

    private fun observeVMEvents() {
        viewModel.topResponse.observe(viewLifecycleOwner) {
            if (this.lifecycle.currentState != Lifecycle.State.RESUMED) return@observe
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        topList.addAll(data)
                        setFlipper(topList)
                        binding.button.performClick()
                        topAdapter.submitList(topList)
                        loading = false

                        Timber.tag("HOME").i(data.toString())
                    }
                }
                is Resource.Error -> {

                }
            }
        }
    }

    private fun setFlipper(list: MutableList<Top>) {
        binding.flipper.setList(list)
        binding.flipper.setLayout()
    }

    private fun getTop(pageLoad: Int) {
        viewModel.getTop("anime", pageLoad)
    }

    private fun setRv(){
        binding.rvTop.run {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 3, RecyclerView.VERTICAL, false)
            adapter = topAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(
                    recyclerView: RecyclerView, dx: Int, dy: Int
                ) {
                    if (dy > 0) {
                        totalItemCount = layoutManager!!.itemCount
                        pastVisiblesItems = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

                        if (!loading) {
                            if (pastVisiblesItems >= totalItemCount-1) {

                                loading = true
                                pageLoad ++
                                this@HomeFragment.getTop(pageLoad)
                            }
                        }
                    }
                }
            })
        }
    }

    private fun setAdapter(){
        topAdapter = TopAdapter {
            Toast.makeText(requireContext(), "item clicado", Toast.LENGTH_SHORT).show()
        }
    }
}