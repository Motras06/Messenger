package messenger.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "messengerDatabase";

    private static final String TABLE_NAME = "chats";
    private static final String KEY_ID = "id";
    private static final String KEY_CHAT_NAME = "chatName";
    private static final String KEY_LAST_MESSAGE = "lastMessage";
    private static final String KEY_UNREAD_MESSAGE_COUNT = "unreadMessageCount";


    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_CHAT_NAME + " TEXT, " + KEY_LAST_MESSAGE + " TEXT, " + KEY_UNREAD_MESSAGE_COUNT + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addChat(Chat chat){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_CHAT_NAME, chat.getChatName());
        contentValues.put(KEY_LAST_MESSAGE, chat.getLastMessage());
        contentValues.put(KEY_UNREAD_MESSAGE_COUNT, String.valueOf(chat.getUnreadMessageCount()));

        db.insert(TABLE_NAME,null, contentValues);
        db.close();
    }

    List<Chat> getChats(){
        SQLiteDatabase database = this.getReadableDatabase();
        List<Chat> chats = new ArrayList<>();

        String getAllRequest = "Select * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(getAllRequest, null);

        if(cursor.moveToFirst()){
            do {
                Chat chat = new Chat();

                chat.setId(Integer.parseInt(cursor.getString(0)));
                chat.setChatName(cursor.getString(1));
                chat.setLastMessage(cursor.getString(2));
                chat.setUnreadMessageCount(Integer.parseInt(cursor.getString(3)));

                chats.add(chat);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return chats;
    }

    void delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + "=?",new String[]{String.valueOf(id)});
    }
}
