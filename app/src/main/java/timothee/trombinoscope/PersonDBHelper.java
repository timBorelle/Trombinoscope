package timothee.trombinoscope;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonDBHelper extends SQLiteOpenHelper{

    private static PersonDBHelper mInstance = null;

    private static final String DB_NAME = "database.db";
    private static final int DB_VERSION = 1;

    private Context mContext;

    public static PersonDBHelper getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new PersonDBHelper(context.getApplicationContext());
        }
        return mInstance;
    }

    public PersonDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
