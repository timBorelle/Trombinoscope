package timothee.trombinoscope.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Timothée BORELLE
 */

public class PersonDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "PersonDBHelper";
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "personDB.db";

    private static PersonDBHelper sInstance;


    public static synchronized PersonDBHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new PersonDBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public PersonDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i(TAG, "PersonDBHelper");
    }
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate");
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PersonContract.PersonEntry.TABLE_NAME + " (" +
                    PersonContract.PersonEntry._ID + " INTEGER PRIMARY KEY," +
                    PersonContract.PersonEntry.COLUMN_NAME_FIRSTNAME + " TEXT," +
                    PersonContract.PersonEntry.COLUMN_NAME_LASTNAME + " TEXT," +
                    PersonContract.PersonEntry.COLUMN_NAME_AVATAR + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PersonContract.PersonEntry.TABLE_NAME;
}
