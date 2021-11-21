package com.example.communcationingarden.data.source.gardenpicture

import com.example.communcationingarden.data.GardenPicture

interface GardenPictureRepository {
    
    suspend fun getGardenPictureList(
        gardenName: String
    ): Result<List<GardenPicture>>
}
