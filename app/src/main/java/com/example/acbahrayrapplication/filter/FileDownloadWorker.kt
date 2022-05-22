package com.example.acbahrayrapplication.filter

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class FileDownloadWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val imageUriInput = inputData.getString("json_file") ?: return Result.failure()

        downloadJson(imageUriInput)
        return Result.success()
    }

    @Throws(IOException::class)
    fun downloadJson(strUrl: String?): String {
        var data = ""
        var iStream: InputStream? = null
        var urlConnection: HttpURLConnection? = null
        try { /*w  w  w  .  j  a  v a 2 s  .c om*/
            val url = URL(strUrl)

            // Creating an http connection to communicate with url
            urlConnection = url.openConnection() as HttpsURLConnection

            // Connecting to url
            urlConnection.connect()

            // Reading data from url
            iStream = urlConnection.getInputStream()
            val br = BufferedReader(
                InputStreamReader(
                    iStream
                )
            )
            val sb = StringBuffer()
            var line: String? = ""
            while (br.readLine().also { line = it } != null) {
                sb.append(line)
            }
            data = sb.toString()
            br.close()
        } catch (e: Exception) {
            Log.e("TAG", "problem downloading JSON from Google", e);
        } finally {
            iStream?.close()
            urlConnection?.disconnect()
        }
        Log.e("Json file", data)
        return data
    }
}