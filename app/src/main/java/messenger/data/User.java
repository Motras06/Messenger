package messenger.data;

import android.graphics.drawable.Drawable;

import lombok.Data;

@Data
public class User {
    String userName;
    String publicName;
    Drawable profilePicture;
}
