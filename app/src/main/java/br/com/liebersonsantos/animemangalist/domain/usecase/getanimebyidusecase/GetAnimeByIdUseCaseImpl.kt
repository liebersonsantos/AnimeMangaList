package br.com.liebersonsantos.animemangalist.domain.usecase.getanimebyidusecase

import br.com.liebersonsantos.animemangalist.data.api.Api
import br.com.liebersonsantos.animemangalist.data.model.Anime
import javax.inject.Inject

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
class GetAnimeByIdUseCaseImpl @Inject constructor(private val api: Api): GetAnimeByIdUseCase {
    override suspend fun invoke(animeId: Int): Anime = api.getAnimeById(animeId)
}