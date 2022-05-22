package com.example.acbahrayrapplication.filter

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.acbahrayrapplication.util.DownLoader.downloadJson

class FileDownloadWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val imageUriInput = inputData.getString("json_file") ?: return Result.failure()

        downloadJson(imageUriInput)
        return Result.success()
    }

}