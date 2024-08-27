package messenger.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import messenger.data.Chat;
import messenger.ui.registration.R;

public class ChatsAdapter extends ArrayAdapter<Chat> {

    Chat[] chats;
    Context context;


    public ChatsAdapter(@NonNull Context context, @NonNull Chat[] objects) {
        super(context, R.layout.chat_item, objects);
        this.chats = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.chat_item, parent, false);

        ImageView chatIcon = (ImageView) view.findViewById(R.id.groupIcon);
        if(chats[position].getChatType() == Chat.ChatType.PersonalChat){
            chatIcon.setImageResource(R.drawable.personal_chat_icon);
        }
        else {
            chatIcon.setImageResource(R.drawable.group_chat_icon);
        }

        TextView chatName = (TextView) view.findViewById(R.id.groupName);
        chatName.setText(chats[position].getChatName());

        TextView lastMessage = (TextView) view.findViewById(R.id.lastMessage);
        lastMessage.setText(chats[position].getLastMessage());

        TextView unreadMessage = (TextView) view.findViewById(R.id.unreadMessage);
        unreadMessage.setText(String.valueOf(chats[position].getUnreadMessageCount()));

        return view;
    }

}
