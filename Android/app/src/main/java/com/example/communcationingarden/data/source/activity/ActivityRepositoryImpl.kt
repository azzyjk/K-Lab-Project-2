package com.example.communcationingarden.data.source.activity

import com.example.communcationingarden.data.ActivityInfo
import com.example.communcationingarden.data.RegistActivityInfo
import com.example.communcationingarden.network.ActivityResponse
import com.example.communcationingarden.network.ExitResponse
import com.example.communcationingarden.network.ParticipateResponse
import com.example.communcationingarden.network.RegistActivityResponse
import javax.inject.Inject

class ActivityRepositoryImpl @Inject constructor(
    private val activityRemoteDataSource: ActivityDataSource.Remote
): ActivityRepository {
    
    override suspend fun getAllActivityList(
        gardenName: String
    ): Result<ActivityResponse> {
        return activityRemoteDataSource.getAllActivityList(
            gardenName
        )
    }
    
    override suspend fun requestParticipateActivity(
        userId: String,
        activityInfo: ActivityInfo
    ): Result<ParticipateResponse> {
        return activityRemoteDataSource.requestParticipateActivity(
            userId,
            activityInfo
        )
    }
    
    override suspend fun getUserActivityList(
        userId: String,
        gardenName: String
    ): Result<ActivityResponse> {
        return activityRemoteDataSource.getUserActivityList(
            userId,
            gardenName
        )
    }
    
    override suspend fun requestExitActivity(
        userId: String,
        activityInfo: ActivityInfo
    ): Result<ExitResponse> {
        return activityRemoteDataSource.requestExitActivity(
            userId,
            activityInfo
        )
    }
    
    override suspend fun requestRegistActivity(
        userId: String,
        gardenName: String,
        registActivityInfo: RegistActivityInfo
    ): Result<RegistActivityResponse> {
        return activityRemoteDataSource.requestRegistActivity(
            userId,
            gardenName,
            registActivityInfo
        )
    }
}
