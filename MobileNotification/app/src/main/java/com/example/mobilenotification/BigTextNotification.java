package com.example.mobilenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BigTextNotification extends AppCompatActivity {

    Button getnotification;
    private final String channelid = "Company Name Big Text Notification";
    private final int Notification_id = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_text_notification);

        getnotification = findViewById(R.id.button2);

        getnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateNotificationChannel();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),channelid);
                builder.setSmallIcon(R.drawable.icon);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon));
                builder.setContentTitle("Android Development");
                builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Happy to learn android full tutorials by the way you can also visit small academy page"));
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(Notification_id,builder.build());
            }
        });

    }

    private void CreateNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            String description = "Include all Big Text notification";
            CharSequence name = "Big Text Notification";

            int important = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(channelid,name,important);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            if (notificationManager != null){

                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}
