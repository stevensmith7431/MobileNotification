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

public class InboxStyleNotification extends AppCompatActivity {

    Button getnotification;
    private final String channelid = "Company Inbox Notification";
    private final int Notification_id = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_style_notification);

        getnotification = findViewById(R.id.button4);

        getnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateNotificationChannel();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),channelid);
                builder.setSmallIcon(R.drawable.icon);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon));
                builder.setContentTitle("Android Development");
                builder.setStyle(new NotificationCompat.InboxStyle()
                .addLine("Ram:Hai bro")
                .addLine("Vimal:I am fine")
                .addLine("Angel:Hello Everybody")
                .setSummaryText("+3 message"));
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(Notification_id,builder.build());
            }
        });

    }

    private void CreateNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            String description = "Include all Inbox Text notification";
            CharSequence name = "Inbox Text Notification";

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
