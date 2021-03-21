package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.Tourism
import com.example.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow

class TourismInteractor(private val toursmRepository: ITourismRepository) : TourismUseCase {
    override fun getAllTourism(): Flow<Resource<List<Tourism>>> = toursmRepository.getAllTourism()

    override fun getFavoriteTourism(): Flow<List<Tourism>> = toursmRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = toursmRepository.setFavoriteTourism(tourism,state)
}