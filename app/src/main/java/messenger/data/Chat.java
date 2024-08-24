package messenger.data;

import lombok.Data;

@Data
public class Chat {
    int id;
    String chatName;
    String lastMessage;
    int unreadMessageCount;
}
