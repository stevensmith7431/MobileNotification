package com.example.mobilenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BigPictureNotification extends AppCompatActivity {

    Button getnotification;
    private final String channelid = "Company Name Big Picture Notification";
    private final int Notification_id = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_picture_notification);

        getnotification = findViewById(R.id.button3);

        getnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateNotificationChannel();

                Bitmap picture = BitmapFactory.decodeResource(getResources(),R.drawable.icon);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),channelid);
                builder.setSmallIcon(R.drawable.icon);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon));
                builder.setContentTitle("Android Development");
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture));
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(Notification_id,builder.build());
            }
        });
    }

    private void CreateNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            String description = "Include all Big Picture notification";
            CharSequence name = "Big Picture Notification";

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
