package com.example.communcationingarden.data.source.garden

import com.example.communcationingarden.data.Position
import com.example.communcationingarden.data.source.garden.remote.GardenRemoteDataSource
import com.example.communcationingarden.network.GardenListResponse

class GardenRepositoryImpl(
    private val remoteDataSource: GardenRemoteDataSource
): GardenRepository {
    
    override suspend fun requestGardenList(
        userPosition: Position
    ): Result<GardenListResponse> {
        return remoteDataSource.requestGardenList(
            userPosition
        )
    }
}
