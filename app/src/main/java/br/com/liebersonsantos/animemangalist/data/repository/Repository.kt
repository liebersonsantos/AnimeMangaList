package br.com.liebersonsantos.animemangalist.data.repository

import br.com.liebersonsantos.animemangalist.data.model.Anime
import br.com.liebersonsantos.animemangalist.data.model.Manga
import br.com.liebersonsantos.animemangalist.data.model.SeasonResponse
import br.com.liebersonsantos.animemangalist.data.model.TopResponse

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
interface Repository {
    suspend fun getTop(type: String, page: Int): TopResponse
    suspend fun getAnimeById(animeId: Int): Anime
    suspend fun getAnimesBySeason(year: Int, season: String): SeasonResponse
    suspend fun getMangaById(mangaId: Int): Manga
}