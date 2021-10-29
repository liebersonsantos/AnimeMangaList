package br.com.liebersonsantos.animemangalist.data.api

import br.com.liebersonsantos.animemangalist.data.model.Anime
import br.com.liebersonsantos.animemangalist.data.model.Manga
import br.com.liebersonsantos.animemangalist.data.model.SeasonResponse
import br.com.liebersonsantos.animemangalist.data.model.TopResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
interface Api {

    @GET("top/{type}/{page}")
    suspend fun getTop(
        @Path("type") type: String,
        @Path("page") page: Int): TopResponse

    @GET("anime/{animeId}")
    suspend fun getAnimeById(
        @Path("animeId") animeId: Int): Anime

    @GET("season/{year}/{season}")
    suspend fun getAnimesBySeason(
        @Path("year") year: Int,
        @Path("season") season: String): SeasonResponse

    @GET("manga/{mangaId}")
    suspend fun getMangaById(
        @Path("mangaId") mangaId: Int): Manga
}