package messenger.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.zip.Inflater;

import messenger.data.Message;
import messenger.data.User;
import messenger.ui.registration.R;
import messenger.ui.registration.databinding.OtherMessageItemBinding;
import messenger.ui.registration.databinding.UserMessageItemBinding;

public class MessagesAdapter extends ArrayAdapter<Message> {

    Message[] messages;
    Context context;
    User user;

    public MessagesAdapter(@NonNull Context context, @NonNull Message[] messages, User user) {
        super(context, R.layout.other_message_item, messages);
        this.messages = messages;
        this.context = context;
        this.user = user;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View view;
        Message message = getItem(position);

        if(message.getSenderPersonalName().equals(user.getPersonalName())){
            UserMessageItemBinding binding = UserMessageItemBinding.inflate(
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                    parent,
                    false);
            view = binding.getRoot();

            binding.messageText.setText(message.getMessageText());
            binding.sendTime.setText(
                            message.getSendTime().getHour() +
                            ":" +
                            message.getSendTime().getMinute());
        }else{
            OtherMessageItemBinding binding = OtherMessageItemBinding.inflate(
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                    parent,
                    false);
            view = binding.getRoot();

            binding.messageText.setText(message.getMessageText());
            binding.sendTime.setText(
                            message.getSendTime().getHour() +
                            ":" +
                            message.getSendTime().getMinute());
        }

        return view;
    }

}
