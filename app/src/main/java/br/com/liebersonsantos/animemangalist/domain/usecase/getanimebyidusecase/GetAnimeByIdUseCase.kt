package br.com.liebersonsantos.animemangalist.domain.usecase.getanimebyidusecase

import br.com.liebersonsantos.animemangalist.data.model.Anime

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
interface GetAnimeByIdUseCase {
    suspend operator fun invoke(animeId: Int): Anime
}