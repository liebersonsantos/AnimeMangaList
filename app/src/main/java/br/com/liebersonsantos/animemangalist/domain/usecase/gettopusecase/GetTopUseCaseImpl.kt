package br.com.liebersonsantos.animemangalist.domain.usecase.gettopusecase

import br.com.liebersonsantos.animemangalist.data.api.Api
import br.com.liebersonsantos.animemangalist.data.model.TopResponse
import javax.inject.Inject

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
class GetTopUseCaseImpl @Inject constructor(private val api: Api): GetTopUseCase {
    override suspend fun invoke(type: String, page: Int): TopResponse =
        api.getTop(type, page)
}