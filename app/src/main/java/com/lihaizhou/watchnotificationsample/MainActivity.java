package com.lihaizhou.watchnotificationsample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private SlidingUpPanelLayout mLayout;
    private RelativeLayout rootLayout;
    private float pointDownY;
    private int screenHeight;

    private ListView notificationLv;
    private NotificationListviewAdapter notificationListviewAdapter;
    private ArrayList<NotificationListviewItem> notificationArrayLists;

    private static final int NOTIFICATION_CALL_TYPE_INDEX = 0;
    private static final int NOTIFICATION_VOICE_TYPE_INDEX = 1;
    private static final int NOTIFICATION_OTHER_TYPE_INDEX = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void initView()
    {
        notificationLv = (ListView) findViewById(R.id.notification_lv);
        notificationListviewAdapter = new NotificationListviewAdapter(this,getNotification());
        notificationLv.setAdapter(notificationListviewAdapter);
        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        rootLayout = (RelativeLayout) findViewById(R.id.root_content);
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        screenHeight = wm.getDefaultDisplay().getHeight();
    }

    private void setListener()
    {
        notificationLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();
            }
        });

        //监测底部通知栏状态
        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

            }
        });

        rootLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        pointDownY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float moveY = event.getRawY() - pointDownY;
                        if(pointDownY > (screenHeight - screenHeight/2) && (-moveY)>(screenHeight/6)) {
                            mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }

        });

    }

    private ArrayList<NotificationListviewItem> getNotification()
    {
        notificationArrayLists = new ArrayList<NotificationListviewItem>();
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_CALL_TYPE_INDEX,getCallTypeHashMap("来电")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_VOICE_TYPE_INDEX,getVoiceTypeHashMap("语音")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_OTHER_TYPE_INDEX,getOtherTypeHashMap("其它")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_CALL_TYPE_INDEX,getCallTypeHashMap("来电")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_VOICE_TYPE_INDEX,getVoiceTypeHashMap("语音")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_OTHER_TYPE_INDEX,getOtherTypeHashMap("其它")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_CALL_TYPE_INDEX,getCallTypeHashMap("来电")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_VOICE_TYPE_INDEX,getVoiceTypeHashMap("语音")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_OTHER_TYPE_INDEX,getOtherTypeHashMap("其它")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_CALL_TYPE_INDEX,getCallTypeHashMap("来电")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_VOICE_TYPE_INDEX,getVoiceTypeHashMap("语音")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_OTHER_TYPE_INDEX,getOtherTypeHashMap("其它")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_CALL_TYPE_INDEX,getCallTypeHashMap("来电")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_VOICE_TYPE_INDEX,getVoiceTypeHashMap("语音")));
        notificationArrayLists.add(new NotificationListviewItem(NOTIFICATION_OTHER_TYPE_INDEX,getOtherTypeHashMap("其它")));
        return notificationArrayLists;
    }

    private HashMap<String,Object> getCallTypeHashMap(String callTypeTv)
    {
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("type",callTypeTv);
        return hashMap;
    }

    private HashMap<String,Object> getVoiceTypeHashMap(String voiceTypeTv)
    {
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("type",voiceTypeTv);
        return hashMap;
    }

    private HashMap<String,Object> getOtherTypeHashMap(String otherTypeTv)
    {
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("type",otherTypeTv);
        return hashMap;
    }
}
