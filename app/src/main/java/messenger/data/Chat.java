package messenger.data;

import lombok.Data;

@Data
public class Chat {
    int id;
    String chatName;
    String lastMessage;
    int unreadMessageCount;
    ChatType chatType;


    public enum ChatType
    {
        Group,
        PersonalChat;

        public static ChatType onIndex(int i) {
            return values()[i];
        }
    }
}
