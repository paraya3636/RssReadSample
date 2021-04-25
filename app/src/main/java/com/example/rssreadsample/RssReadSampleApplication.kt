package com.example.rssreadsample

import android.app.Application
import com.example.rssreadsample.data.repository.ArticleRepositoryImpl
import com.example.rssreadsample.domain.model.ArticleType
import com.example.rssreadsample.domain.repository.ArticleRepository
import com.example.rssreadsample.presentation.ArticleListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RssReadSampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RssReadSampleApplication)
            modules(module)
        }
    }

    private val module = module {
        viewModel { (articleType: ArticleType) -> ArticleListViewModel(get(), get(), articleType) }
        single<ArticleRepository> { ArticleRepositoryImpl() }
    }
}