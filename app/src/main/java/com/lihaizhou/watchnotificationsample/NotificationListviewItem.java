package com.lihaizhou.watchnotificationsample;

import java.util.HashMap;

/**
 * Created by lihaizhou on 2017/9/26.
 */

public class NotificationListviewItem {

    //区分通知底部消息的类型，比如未接来电,语音消息,QQ消息...
    private int notificationType;

    private HashMap<String,Object> map;

    public NotificationListviewItem(int notificationType,HashMap<String,Object> map)
    {
        this.notificationType = notificationType;
        this.map = map;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }
}
