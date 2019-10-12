package com.example.notificationsapp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button SimpleNot, BigTextNot, BigPicNot, InboxNot, MessagingNot, NotificationActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleNot = (Button)findViewById(R.id.simpleNot);
        BigTextNot = (Button)findViewById(R.id.bigStyleNot);
        BigPicNot = (Button)findViewById(R.id.bigPicStyleNot);
        InboxNot = (Button)findViewById(R.id.inboxStyleNot);
        MessagingNot = (Button)findViewById(R.id.messagingStyleNot);
        NotificationActions = (Button)findViewById(R.id.notificationAct);

//        SimpleNot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                simple_Notification();
//            }
//        });
//
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.simpleNot:
                simple_Notification();
                break;

            case R.id.bigStyleNot:
                big_textstyle_Notification();
                break;

            case R.id.bigPicStyleNot:
                big_pic_Notification();
                break;

            case R.id.inboxStyleNot:
                inbox_Notification();
                break;

            case R.id.messagingStyleNot:
                messaging_style_Notification();
                break;

            case R.id.notificationAct:
                Notification_Action();
                break;
        }
    }

    private void Notification_Action() {
        int notificationId = 5;

        NotificationCompat.Builder builder =  new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Acion Buttons")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_mood_black_24dp))
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Click to view to visit Google"))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("hhtps://www.google.com"));
        PendingIntent pendingIntent =  PendingIntent.getActivity(this, 0, intent,0);

        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent);


        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        //Call notification manager to build and deliver notification to OS.

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        //Android 8 and above requires setting channelId property by using NotificationChannel

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            String channelId = "YOUR_CHANNEL_ID";
            NotificationChannel  channel = new NotificationChannel(channelId, "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        notificationManager.notify(notificationId, builder.build());






    }

    private void messaging_style_Notification() {
        int notificationId = 4;

        NotificationCompat.Builder builder =  new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Inbox Notification")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_mood_black_24dp))
                .setStyle(new NotificationCompat.MessagingStyle("Mike: ").setConversationTitle("Q&A Group")
                        .addMessage("This type of notification was introduced in android N. Right?", 0, "Victor: ")

                        .addMessage("Yes", 0, "lizzy: ")
                        .addMessage("The constructor is passed with the name of the current user. Right? ", 0, "Fred: ")
                        .addMessage("True", 0, ": "))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        //Call notification manager to build and deliver notification to OS.

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        //Android 8 and above requires setting channelId property by using NotificationChannel

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            String channelId = "YOUR_CHANNEL_ID";
            NotificationChannel  channel = new NotificationChannel(channelId, "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        notificationManager.notify(notificationId, builder.build());


    }

    private void inbox_Notification() {
        int notificationId = 3;

        NotificationCompat.Builder builder =  new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Inbox Notification")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_mood_black_24dp))
                .setStyle(new NotificationCompat.InboxStyle().addLine("Hello to you").addLine("Are you there?").setBigContentTitle("2 New messages for you").setSummaryText("Inbox"))
                .setAutoCancel(true);


        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        //Call notification manager to build and deliver notification to OS.

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        //Android 8 and above requires setting channelId property by using NotificationChannel

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            String channelId = "YOUR_CHANNEL_ID";
            NotificationChannel  channel = new NotificationChannel(channelId, "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        notificationManager.notify(notificationId, builder.build());
    }

    private void big_pic_Notification() {
        int notificationId = 2;

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.flowz);

        NotificationCompat.Builder builder =  new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Big Picture")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_mood_black_24dp))
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        //Call notification manager to build and deliver notification to OS.

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        //Android 8 and above requires setting channelId property by using NotificationChannel

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            String channelId = "YOUR_CHANNEL_ID";
            NotificationChannel  channel = new NotificationChannel(channelId, "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        notificationManager.notify(notificationId, builder.build());

    }

    private void big_textstyle_Notification() {
        int notificationId = 1;

        NotificationCompat.Builder builder =  new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Big Text")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_mood_black_24dp))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(getResources().getString(R.string.big_text)))
                .setAutoCancel(true);


        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        //Call notification manager to build and deliver notification to OS.

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        //Android 8 and above requires setting channelId property by using NotificationChannel

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            String channelId = "YOUR_CHANNEL_ID";
            NotificationChannel  channel = new NotificationChannel(channelId, "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        notificationManager.notify(notificationId, builder.build());

    }

    private void simple_Notification() {
        // declare an id for your notification, it's used when setting action buttons and their intents.

        int notificationId = 0;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_mood_black_24dp))
                .setContentTitle("Testing my notification App")
                .setContentText("notification testing App built")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        //set Tone for notification ring

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        //Call notification manager to build and deliver notification to OS.

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        //Android 8 and above requires setting channelId property by using NotificationChannel

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
             String channelId = "YOUR_CHANNEL_ID";
            NotificationChannel  channel = new NotificationChannel(channelId, "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        notificationManager.notify(notificationId, builder.build());

    }
}
