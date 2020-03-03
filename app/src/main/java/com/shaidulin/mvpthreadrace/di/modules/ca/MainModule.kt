package com.shaidulin.mvpthreadrace.di.modules.ca

import com.shaidulin.mvpthreadrace.ui.main.repositories.dataservices.MainStore
import com.shaidulin.mvpthreadrace.ui.main.interactors.MainInteractor
import com.shaidulin.mvpthreadrace.ui.main.providers.IMainRepositories
import com.shaidulin.mvpthreadrace.ui.main.repositories.MainRepositories
import com.shaidulin.mvpthreadrace.ui.main.repositories.dataservices.MainService
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providesStoreMain():MainStore{
        return MainStore()
    }
    @Provides
    fun providesServiceMain():MainService{
        return MainService()
    }

    @Provides
    fun provideRepository(store: MainStore, service: MainService): IMainRepositories {
        return MainRepositories(service, store)
    }


    @Provides
    fun provideInteractor(repository: IMainRepositories): MainInteractor {
        return MainInteractor(repository)
    }
}