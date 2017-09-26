package com.lihaizhou.watchnotificationsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lihaizhou on 2017/9/26.
 */

public class NotificationListviewAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;

    private ArrayList<NotificationListviewItem> notificationListDatas;

    private static final int NOTIFICATION_TYPE_NUM = 3;//这里定义一共三种消息类型
    private static final int NOTIFICATION_CALL_TYPE_INDEX = 0;
    private static final int NOTIFICATION_VOICE_TYPE_INDEX = 1;
    private static final int NOTIFICATION_OTHER_TYPE_INDEX = 2;

    public NotificationListviewAdapter(Context context,ArrayList<NotificationListviewItem> notificationListDatas)
    {
        this.notificationListDatas = notificationListDatas;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        return notificationListDatas.get(position).getNotificationType();
    }

    @Override
    public int getViewTypeCount() {
        return NOTIFICATION_TYPE_NUM;
    }

    @Override
    public int getCount() {
        return notificationListDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        NotificationListviewItem notificationListviewItem = notificationListDatas.get(position);
        int notificationType = getItemViewType(position);

        ViewHolderCallType viewHolderCallType;
        ViewHolderVoiceType viewHolderVoiceType;
        ViewHolderOtherType viewHolderOtherType;

        if(convertView == null){
            switch (notificationType) {
                case NOTIFICATION_CALL_TYPE_INDEX:
                    viewHolderCallType = new ViewHolderCallType();
                    convertView = layoutInflater.inflate(R.layout.call_type,null);
                    viewHolderCallType.callTypeTv = (TextView) convertView.findViewById(R.id.call_type_tv);
                    viewHolderCallType.callTypeTv.setText(notificationListviewItem.getMap().get("type").toString());
                    convertView.setTag(R.id.call_type_key,viewHolderCallType);
                    break;

                case NOTIFICATION_VOICE_TYPE_INDEX:
                    viewHolderVoiceType = new ViewHolderVoiceType();
                    convertView = layoutInflater.inflate(R.layout.voivce_type,null);
                    viewHolderVoiceType.voiceTypeTv = (TextView) convertView.findViewById(R.id.voice_type_tv);
                    viewHolderVoiceType.voiceTypeTv.setText(notificationListviewItem.getMap().get("type").toString());
                    convertView.setTag(R.id.voice_type_key,viewHolderVoiceType);
                    break;

                case NOTIFICATION_OTHER_TYPE_INDEX:
                    viewHolderOtherType = new ViewHolderOtherType();
                    convertView = layoutInflater.inflate(R.layout.other_type,null);
                    viewHolderOtherType.otherTypeTv = (TextView) convertView.findViewById(R.id.other_type_tv);
                    viewHolderOtherType.otherTypeTv.setText(notificationListviewItem.getMap().get("type").toString());
                    convertView.setTag(R.id.other_type_key,viewHolderOtherType);
                    break;

                default:
                    break;
            }
        } else {
            switch (notificationType){
                case NOTIFICATION_CALL_TYPE_INDEX:
                    viewHolderCallType = (ViewHolderCallType) convertView.getTag(R.id.call_type_key);
                    viewHolderCallType.callTypeTv.setText(notificationListviewItem.getMap().get("type").toString());
                    break;
                case NOTIFICATION_VOICE_TYPE_INDEX:
                    viewHolderVoiceType = (ViewHolderVoiceType) convertView.getTag(R.id.voice_type_key);
                    viewHolderVoiceType.voiceTypeTv.setText(notificationListviewItem.getMap().get("type").toString());
                    break;
                case NOTIFICATION_OTHER_TYPE_INDEX:
                    viewHolderOtherType = (ViewHolderOtherType) convertView.getTag(R.id.other_type_key);
                    viewHolderOtherType.otherTypeTv.setText(notificationListviewItem.getMap().get("type").toString());
                    break;
                default:
                    break;

            }
        }

        return convertView;
    }


    class ViewHolderCallType{
        TextView callTypeTv;
    }

    class ViewHolderVoiceType{
        TextView voiceTypeTv;
    }

    class ViewHolderOtherType{
        TextView otherTypeTv;
    }

}
