package uni.fmi.bechelors.myapplicationy

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat



class MainActivity : AppCompatActivity() {

    private lateinit var logb: Button
    private lateinit var cancelB: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun showNotification(title: String, message: String) {
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                val channel = NotificationChannel("YOUR_CHANNEL_ID",
                    "GetFIT",
                    NotificationManager.IMPORTANCE_DEFAULT)
                channel.description = "YOUR_NOTIFICATION_CHANNEL_DESCRIPTION"
                mNotificationManager.createNotificationChannel(channel)
            }
            val mBuilder = NotificationCompat.Builder(applicationContext, "YOUR_CHANNEL_ID")
                .setSmallIcon(R.drawable.notificationflex) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(message)// message for notification
                .setAutoCancel(true) // clear notification after click
            val intent = Intent(applicationContext, MainActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            mBuilder.setContentIntent(pi)
            mNotificationManager.notify(0, mBuilder.build())
        }
        logb = findViewById(R.id.loginButton)
        cancelB = findViewById(R.id.registerButton)

        logb.setOnClickListener {

            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        cancelB.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)


        }

        showNotification("GetFit", "Come to train and be stronger than yesterday!")


    }
}