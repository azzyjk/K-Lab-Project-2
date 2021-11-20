package com.example.communcationingarden.data.source.garden

import com.example.communcationingarden.data.Position
import com.example.communcationingarden.network.GardenListResponse

interface GardenDataSource {
    interface Local {
    
    }
    
    interface Remote {
        
        suspend fun requestGardenList(
            userPosition: Position
        ): Result<GardenListResponse>
    }
}
