package messenger.data;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Message {
    User sender;
    String senderName;
    String message;
    LocalDateTime localDateTime;
}
