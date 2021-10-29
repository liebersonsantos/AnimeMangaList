package br.com.liebersonsantos.animemangalist.data.repository

import br.com.liebersonsantos.animemangalist.data.api.Api
import br.com.liebersonsantos.animemangalist.data.model.Anime
import br.com.liebersonsantos.animemangalist.data.model.Manga
import br.com.liebersonsantos.animemangalist.data.model.SeasonResponse
import br.com.liebersonsantos.animemangalist.data.model.TopResponse
import javax.inject.Inject

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
class RepositoryImpl @Inject constructor(private val api: Api): Repository {
    override suspend fun getTop(type: String, page: Int): TopResponse =
        api.getTop(type, page)

    override suspend fun getAnimeById(animeId: Int): Anime =
        api.getAnimeById(animeId)

    override suspend fun getAnimesBySeason(year: Int, season: String): SeasonResponse =
        api.getAnimesBySeason(year, season)

    override suspend fun getMangaById(mangaId: Int): Manga =
        api.getMangaById(mangaId)
}