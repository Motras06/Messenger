package messenger.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import messenger.data.Chat;
import messenger.ui.adapters.ChatsAdapter;
import messenger.ui.registration.R;
import messenger.ui.registration.databinding.FragmentChatsMenuBinding;


public class ChatsMenuFragment extends Fragment {

    FragmentChatsMenuBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatsMenuBinding.inflate(getLayoutInflater());

        Chat chat1 = new Chat();
        chat1.setChatType(Chat.ChatType.PersonalChat);
        chat1.setId(0);
        chat1.setChatName("name1");
        chat1.setLastMessage("lastMess");
        chat1.setUnreadMessageCount(47);

        Chat chat2 = new Chat();
        chat2.setChatType(Chat.ChatType.PersonalChat);
        chat2.setId(1);
        chat2.setChatName("chat2");
        chat2.setLastMessage("something");
        chat2.setUnreadMessageCount(0);

        Chat chat3 = new Chat();
        chat3.setChatType(Chat.ChatType.Group);
        chat3.setId(2);
        chat3.setChatName("groupChat1");
        chat3.setLastMessage("this is group");
        chat3.setUnreadMessageCount(99);


        Chat[] chats = { chat1,chat2,chat3 };
        ChatsAdapter chatsAdapter = new ChatsAdapter(getContext(), chats);
        binding.chatsList.setAdapter(chatsAdapter);

        binding.chatsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, new ChatFragment());
                fragmentTransaction.commit();
            }
        });

        return binding.getRoot();
    }
}