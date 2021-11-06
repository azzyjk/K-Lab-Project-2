package com.example.communcationingarden.data.source.info

import com.example.communcationingarden.network.ActivityResponse

interface InfoRepository {
	
	suspend fun getAllActivityList(gardenName: String): Result<ActivityResponse>
}