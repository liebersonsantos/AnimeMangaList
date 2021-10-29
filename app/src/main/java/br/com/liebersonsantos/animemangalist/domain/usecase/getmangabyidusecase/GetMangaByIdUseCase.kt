package br.com.liebersonsantos.animemangalist.domain.usecase.getmangabyidusecase

import br.com.liebersonsantos.animemangalist.data.model.Manga

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
interface GetMangaByIdUseCase {
    suspend operator fun invoke(mangaId: Int): Manga
}