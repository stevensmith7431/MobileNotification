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

public class MainActivity extends AppCompatActivity {

    Button getnotification;
    private final String channelid = "Company Name";
    private final int Notification_id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getnotification = findViewById(R.id.button);

        getnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateNotificationChannel();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),channelid);
                builder.setSmallIcon(R.drawable.icon);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon));
                builder.setContentTitle("Android Development");
                builder.setContentText("Happy to learn android full tutorials");
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(Notification_id,builder.build());
            }
        });

    }

    private void CreateNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            String description = "Include all simple notification";
            CharSequence name = "Simple Notification";

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
