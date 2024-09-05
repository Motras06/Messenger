package messenger.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.time.LocalDateTime;

import messenger.data.Chat;
import messenger.data.Message;
import messenger.data.User;
import messenger.ui.adapters.MessagesAdapter;
import messenger.ui.registration.databinding.FragmentChatBinding;


public class ChatFragment extends Fragment {

    FragmentChatBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(getLayoutInflater());

        User user = new User();
        user.setPersonalName("me");

        Message first = new Message();
        first.setMessageText("check");
        first.setSenderPersonalName("idk");
        first.setSendTime(LocalDateTime.parse("2003-12-12T12:32:22"));

        Message second = new Message();
        second.setMessageText("hello my friend!!!");
        second.setSenderPersonalName("idk");
        second.setSendTime(LocalDateTime.parse("2003-12-12T12:32:34"));

        Message third = new Message();
        third.setMessageText("how are you? I want to meet you on this week! Are you free on sunday?");
        third.setSenderPersonalName("idk");
        third.setSendTime(LocalDateTime.parse("2003-12-12T12:33:27"));

        Message answer = new Message();
        answer.setMessageText("Hello! \n sorry, but I a little bit busy at this day...");
        answer.setSenderPersonalName("me");
        answer.setSendTime(LocalDateTime.parse("2003-12-12T12:35:21"));

        Message answer2 = new Message();
        answer2.setMessageText("What about monday?");
        answer2.setSenderPersonalName("me");
        answer2.setSendTime(LocalDateTime.parse("2003-12-12T12:35:28"));

        Message forth = new Message();
        forth.setMessageText("OK! see you!");
        forth.setSenderPersonalName("idk");
        forth.setSendTime(LocalDateTime.parse("2003-12-12T12:36:40"));


        Message[] messages = { first, second, third, answer, answer2, forth };
        MessagesAdapter messagesAdapter = new MessagesAdapter(getContext(), messages, user);
        binding.messagesList.setAdapter(messagesAdapter);

        return binding.getRoot();
    }
}