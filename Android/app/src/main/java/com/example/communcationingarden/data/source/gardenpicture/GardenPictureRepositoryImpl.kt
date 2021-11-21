package com.example.communcationingarden.data.source.gardenpicture

import com.example.communcationingarden.data.GardenPicture
import javax.inject.Inject

class GardenPictureRepositoryImpl @Inject constructor(
    private val gardenPictureRemoteDataSource: GardenPictureDataSource.Remote
): GardenPictureRepository {
    
    override suspend fun getGardenPictureList(
        gardenName: String
    ): Result<List<GardenPicture>> {
        return gardenPictureRemoteDataSource.getGardenPictureList(gardenName)
    }
}
