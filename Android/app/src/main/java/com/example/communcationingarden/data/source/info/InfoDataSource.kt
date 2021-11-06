package com.example.communcationingarden.data.source.info

import com.example.communcationingarden.network.ActivityResponse

interface InfoDataSource {
	interface Local {
	}
	
	interface Remote {
		
		suspend fun getAllActivityList(gardenName: String): Result<ActivityResponse>
	}
}