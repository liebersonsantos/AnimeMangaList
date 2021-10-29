package br.com.liebersonsantos.animemangalist.ui.seasons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.liebersonsantos.animemangalist.R
import br.com.liebersonsantos.animemangalist.databinding.FragmentSeasonsBinding

class SeasonsFragment : Fragment() {
    private lateinit var binding: FragmentSeasonsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentSeasonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}