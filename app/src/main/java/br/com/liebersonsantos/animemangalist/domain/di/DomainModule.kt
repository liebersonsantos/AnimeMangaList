package br.com.liebersonsantos.animemangalist.domain.di

import br.com.liebersonsantos.animemangalist.domain.usecase.getanimebyidusecase.GetAnimeByIdUseCase
import br.com.liebersonsantos.animemangalist.domain.usecase.getanimebyidusecase.GetAnimeByIdUseCaseImpl
import br.com.liebersonsantos.animemangalist.domain.usecase.getanimebyseasonusecase.GetAnimeBySeasonUseCase
import br.com.liebersonsantos.animemangalist.domain.usecase.getanimebyseasonusecase.GetAnimeBySeasonUseCaseImpl
import br.com.liebersonsantos.animemangalist.domain.usecase.getmangabyidusecase.GetMangaByIdUseCase
import br.com.liebersonsantos.animemangalist.domain.usecase.getmangabyidusecase.GetMangaByIdUseCaseImpl
import br.com.liebersonsantos.animemangalist.domain.usecase.gettopusecase.GetTopUseCase
import br.com.liebersonsantos.animemangalist.domain.usecase.gettopusecase.GetTopUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindGetTop(useCase: GetTopUseCaseImpl): GetTopUseCase

    @Binds
    fun bindGetAnimeByIdUseCase(useCase: GetAnimeByIdUseCaseImpl): GetAnimeByIdUseCase

    @Binds
    fun bindGetAnimeBySeason(useCase: GetAnimeBySeasonUseCaseImpl): GetAnimeBySeasonUseCase

    @Binds
    fun bindGetMangaById(useCase: GetMangaByIdUseCaseImpl): GetMangaByIdUseCase

}