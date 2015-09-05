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

public class DatabaseDrawableHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "userManager",
            TABLE_USER = "userInformation",
            KEY_ID = "id",
            KEY_DRAWABLE = "drawable";

    private static SQLiteDatabase db;

    public DatabaseDrawableHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_DRAWABLE + " BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public void saveDrawable(byte[] drawable) {
        db = getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put(KEY_DRAWABLE, drawable);

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public byte[] getDrawable() {
        db = getReadableDatabase();

        //Look all database and see the one you specify, in case by id
        Cursor cursor = db.query(TABLE_USER, new String[] { KEY_DRAWABLE }, KEY_ID + "=?", new String[] { "0" }, null, null, null, null);

        byte[] drawable = null;

        if(cursor != null) {
            cursor.moveToFirst();
            drawable = cursor.getBlob(1);
        }

        db.close();
        cursor.close();
        return drawable;
    }

    public Boolean isDrawableSave() {
        // Select all from Contacts
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER, null);
        //return the number of rows in the cursor
        int count = cursor.getCount();
        db.close();
        cursor.close();

        return count > 0;
    }


    public void deleteDrawable() {
        db =  getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + "=?", new String[]{"0"});
        db.close();
    }

}