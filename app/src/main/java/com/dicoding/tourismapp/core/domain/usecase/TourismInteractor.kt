package com.dicoding.tourismapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.domain.model.Tourism
import com.dicoding.tourismapp.core.domain.repository.ITourismRepository
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

class TourismInteractor(private val toursmRepository: ITourismRepository) : TourismUseCase {
    override fun getAllTourism(): Flow<Resource<List<Tourism>>> = toursmRepository.getAllTourism()

    override fun getFavoriteTourism(): Flow<List<Tourism>> = toursmRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = toursmRepository.setFavoriteTourism(tourism,state)
}