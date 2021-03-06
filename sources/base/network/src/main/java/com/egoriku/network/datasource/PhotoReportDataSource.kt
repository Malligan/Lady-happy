package com.egoriku.network.datasource

import com.egoriku.core.di.utils.IFirebaseFirestore
import com.egoriku.network.data.entities.photoreport.PhotoReportEntity
import com.egoriku.network.firestore.corouines.awaitGetResult
import com.google.firebase.firestore.Query
import javax.inject.Inject

class PhotoReportDataSource
@Inject constructor(private val firebaseFirestore: IFirebaseFirestore) {

    companion object {
        const val COLLECTION_KEY_NEWS = "news"
        const val QUERY_DATE = "date"
    }

    suspend fun downloadPhotoReport() = getPhotoReportQuery().awaitGetResult<PhotoReportEntity>()

    private fun getPhotoReportQuery(): Query = firebaseFirestore
            .getFirebase()
            .collection(COLLECTION_KEY_NEWS)
            .orderBy(QUERY_DATE, Query.Direction.DESCENDING)
}