package de.kai_morich.simple_bluetooth_terminal;
import de.kai_morich.simple_bluetooth_terminal.TerminalFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;


public class xDripReceiver extends BroadcastReceiver {
    protected static final String ACTION_WATCH_COMMUNICATION_SENDER = "com.eveningoutpost.dexdrip.watch.wearintegration.BROADCAST_SERVICE_SENDER";
    protected static final String ACTION_WATCH_COMMUNICATION_RECEIVER = "com.eveningoutpost.dexdrip.watch.wearintegration.BROADCAST_SERVICE_RECEIVER";
    private final Handler handler = new Handler();
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_WATCH_COMMUNICATION_SENDER)) {
            String packageKey = intent.getStringExtra("PACKAGE");
            String function = intent.getStringExtra("FUNCTION");
            String reply = intent.getStringExtra("REPLY_CODE");
            String reply_msg = intent.getStringExtra("REPLY_MSG");
            Log.d(TAG, String.format("received broadcast: function: %s, packageKey: %s, reply code %s, msg %s", function, packageKey, reply, reply_msg));
            if (function.endsWith("update_bg")){
                Bundle bg = intent.getExtras();
                Double bgVal = bg.getDouble("bg.valueMgdl");
                Double bgVar = bg.getDouble("bg.deltaValueMgdl");
                Log.d(TAG, "Received BG from xDrip: " +bgVal+" variation: "+bgVar);
                //FIXME send("135;Flat");
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });

            }
            //long timeStamp = intent.getLongExtra("timeStamp", System.currentTimeMillis());
            //int steps = intent.getIntExtra("value", 0);

        }
    }
    protected String TAG = this.getClass().getSimpleName();

}