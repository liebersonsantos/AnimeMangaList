package br.com.liebersonsantos.animemangalist.domain.usecase.gettopusecase

import br.com.liebersonsantos.animemangalist.data.model.TopResponse

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
interface GetTopUseCase {
    suspend operator fun invoke(type: String, page: Int): TopResponse
}