package com.dicoding.myreactiveform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.myreactiveform.network.ApiConfig
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

class MainViewModel : ViewModel() {
    private val accessToken = BuildConfig.API_KEY
    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    val searchResult = queryChannel.asFlow()
        .debounce(300)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .mapLatest {
            ApiConfig.provideApiService().getCountry(it, accessToken)
                .features
        }
        .asLiveData()
}