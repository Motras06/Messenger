package messenger.data;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Message {
    User sender;
    String senderPersonalName;
    String messageText;
    LocalDateTime sendTime;
}
