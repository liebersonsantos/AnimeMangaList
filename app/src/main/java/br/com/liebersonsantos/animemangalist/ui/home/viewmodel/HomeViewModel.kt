package br.com.liebersonsantos.animemangalist.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.liebersonsantos.animemangalist.data.core.Resource
import br.com.liebersonsantos.animemangalist.data.model.Top
import br.com.liebersonsantos.animemangalist.domain.usecase.gettopusecase.GetTopUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    @Named("io") private val ioDispatcher: CoroutineDispatcher,
    private val getTopUseCase: GetTopUseCase
) : ViewModel() {

    private val _topResponse = MutableLiveData<Resource<MutableList<Top>>>()
    val topResponse: LiveData<Resource<MutableList<Top>>>
    get() = _topResponse

    fun getTop(type: String, page: Int) = viewModelScope.launch {
        try {
            val response = withContext(ioDispatcher) {
                getTopUseCase(type, page)
            }

            _topResponse.value = Resource.Success(response.top)

        } catch (e: Exception){
            _topResponse.value = Resource.Error(e)
        }
    }

}