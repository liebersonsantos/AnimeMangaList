package br.com.liebersonsantos.animemangalist.domain.usecase.getanimebyseasonusecase

import br.com.liebersonsantos.animemangalist.data.model.SeasonResponse

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
interface GetAnimeBySeasonUseCase {
    suspend operator fun invoke(year: Int, season: String): SeasonResponse
}