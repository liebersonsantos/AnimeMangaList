package br.com.liebersonsantos.animemangalist.domain.usecase.getmangabyidusecase

import br.com.liebersonsantos.animemangalist.data.api.Api
import br.com.liebersonsantos.animemangalist.data.model.Manga
import javax.inject.Inject

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
class GetMangaByIdUseCaseImpl @Inject constructor(private val api: Api): GetMangaByIdUseCase {
    override suspend fun invoke(mangaId: Int): Manga = api.getMangaById(mangaId)
}