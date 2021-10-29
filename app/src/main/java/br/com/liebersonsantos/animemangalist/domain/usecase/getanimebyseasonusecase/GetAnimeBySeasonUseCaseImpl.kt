package br.com.liebersonsantos.animemangalist.domain.usecase.getanimebyseasonusecase

import br.com.liebersonsantos.animemangalist.data.api.Api
import br.com.liebersonsantos.animemangalist.data.model.SeasonResponse
import javax.inject.Inject

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
class GetAnimeBySeasonUseCaseImpl @Inject constructor(private val api: Api): GetAnimeBySeasonUseCase {
    override suspend fun invoke(year: Int, season: String): SeasonResponse =
        api.getAnimesBySeason(year, season)
}