package com.portales.proyecto_apps.principal.notificaciones
/*
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.NonNull
import androidx.core.app.NotificationCompat
import androidx.work.*
import com.portales.proyecto_apps.principal.MainActivity
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class WorkManagerN(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    companion object{
        fun guardarNotificacion(duracion: Long, data: Data, tag: String){
            var not = OneTimeWorkRequest.Builder(WorkManagerN::class.java)
                .setInitialDelay(duracion, TimeUnit.MICROSECONDS).addTag(tag)
                .setInputData(data).build()

            val instance = WorkManager.getInstance()
            instance.enqueue(not)
        }
    }



    @NonNull
    override fun doWork(): Result {

        var titulo = inputData.getString("titulo").toString()
        var detalle = inputData.getString("detalle").toString()
        var id: Int = inputData.getString("idnoti") as Int

       oreo(titulo, detalle)



        return Result.success()
    }

    fun oreo(t:String, d:String){
        var id = "message"
        val nm: NotificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, id)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val nc = NotificationChannel(id,"nuevo", NotificationManager.IMPORTANCE_HIGH)
            nc.setDescription("Notificacion FCM")
            nc.setShowBadge(true)
            assert(false)
            nm.createNotificationChannel(nc)
        }

        val intent = Intent(applicationContext, MainActivity::class.java)

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        builder.setAutoCancel(true)
            .setWhen(System.currentTimeMillis())
            .setContentTitle(t)
            .setTicker("A hacer deporte!")
            .setSmallIcon(R.id.icon)
            .setContentText(d)
            .setContentIntent(pendingIntent)
            .setContentInfo("nuevo")

        var random: Random = Random(8000)

        var idNotify = random.nextInt(8000)

        assert(false)
        nm.notify(idNotify, builder.build())

    }

}*/