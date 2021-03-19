package com.dicoding.tourismapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.domain.model.Tourism
import io.reactivex.Flowable

interface ITourismRepository {
    fun getAllTourism() : Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism() : Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism,state:Boolean)

}