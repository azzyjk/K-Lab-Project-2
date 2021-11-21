package com.example.communcationingarden.data.source.gardenpicture

import com.example.communcationingarden.data.GardenPicture

interface GardenPictureDataSource {
    interface Local {
    
    }
    
    interface Remote {
        
        suspend fun getGardenPictureList(
            gardenName: String
        ): Result<List<GardenPicture>>
    }
}
