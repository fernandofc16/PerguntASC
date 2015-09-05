package fexus.com.br.perguntasc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import fexus.com.br.perguntasc.extras.UserInformation;

/**
 * Created by Fernando F C.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "userManager",
            TABLE_USER = "userInformation",
            KEY_ID = "id",
            KEY_ID_FACEBOOK = "idFacebook",
            KEY_NAME = "name",
            KEY_BACKGROUND_IMAGE = "backgroundImage";

    private static SQLiteDatabase db;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_ID_FACEBOOK + "TEXT," + KEY_NAME + " TEXT," + KEY_BACKGROUND_IMAGE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public void addUserInformation(UserInformation userInformation) {
        db = getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put(KEY_ID_FACEBOOK, userInformation.getIdFacebook());
        values.put(KEY_NAME, userInformation.getName());
        values.put(KEY_BACKGROUND_IMAGE, userInformation.getBackgroundImage());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public UserInformation getUserInformation(int id) {
        db = getReadableDatabase();

        //Look all database and see the one you specify, in case by id
        Cursor cursor = db.query(TABLE_USER, new String[] { KEY_ID, KEY_ID_FACEBOOK, KEY_NAME, KEY_BACKGROUND_IMAGE }, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        UserInformation userInformation = new UserInformation(cursor.getString(1), cursor.getString(2), cursor.getString(3));

        db.close();
        cursor.close();
        return userInformation;
    }

    public String getKeyBackgroundImage(int id) {
        db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[] { KEY_BACKGROUND_IMAGE }, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        String userBackgroundImage = cursor.getString(3);

        db.close();
        cursor.close();
        return userBackgroundImage;
    }

    public void deleteContact(UserInformation userInformation) {
        db =  getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID_FACEBOOK + "=?", new String[] { userInformation.getIdFacebook() });
        db.close();
    }

    public int getContactsCount() {
        // Select all from Contacts
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER, null);
        //return the number of rows in the cursor
        int count = cursor.getCount();
        db.close();
        cursor.close();

        return count;
    }

    public void updateDatabase(List<UserInformation> usersInformation) {
        db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
        for(UserInformation userInformation : usersInformation) {
            addUserInformation(userInformation);
        }
    }

}

