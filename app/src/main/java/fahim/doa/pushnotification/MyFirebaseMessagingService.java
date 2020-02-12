package fahim.doa.pushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getData().size() >0)
        {

        }
        if(remoteMessage.getNotification() != null)
        {
            shownotification(remoteMessage.getNotification().getBody());
        }

    }

    private void shownotification(String body) {

        Intent i = new Intent(this,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent intent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);
        Uri nofisount = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationbuilder = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase").setContentText(body)
                .setAutoCancel(true)
                .setSound(nofisount)
                .setContentIntent(intent);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationbuilder.build());

    }
}
