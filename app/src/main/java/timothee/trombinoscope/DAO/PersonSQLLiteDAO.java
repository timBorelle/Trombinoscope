package timothee.trombinoscope.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import timothee.trombinoscope.dto.Person;
import timothee.trombinoscope.sqlite.PersonContract;
import timothee.trombinoscope.sqlite.PersonDBHelper;

/**
 * Created by Timothée BORELLE.
 */

public class PersonSQLLiteDAO implements IPersonData {
    private static final String TAG = "PersonSQLLiteDAO";

    PersonDBHelper mDbHelper;
    SQLiteDatabase db;
    SQLiteDatabase dbr;

    //Instanciate Helper with context
    //PersonDBHelper mDbHelper   =new PersonDBHelper(getApplicationContext());
    public PersonSQLLiteDAO(PersonDBHelper mDbHelper) {
        Log.i(TAG, "PersonSQLLiteDAO");
        this.mDbHelper = mDbHelper;
        db = mDbHelper.getWritableDatabase();
        dbr = mDbHelper.getReadableDatabase();
    }

    @Override
    public List<Person> getPersons() {
        Log.i(TAG, "getPersons");
        SQLiteDatabase dbr = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                PersonContract.PersonEntry._ID,
                PersonContract.PersonEntry.COLUMN_NAME_FIRSTNAME,
                PersonContract.PersonEntry.COLUMN_NAME_LASTNAME,
                String.valueOf(PersonContract.PersonEntry.COLUMN_NAME_AVATAR)
        };

        // Filter results WHERE "title" = 'My Title'
        //String selection = PersonContract.PersonEntry.COLUMN_NAME_FIRSTNAME + " = ?";
        //String[] selectionArgs = { "ABERKAN" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                PersonContract.PersonEntry.COLUMN_NAME_FIRSTNAME + " DESC";

        Cursor cursor = dbr.query(
                PersonContract.PersonEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,//selection,                                // The columns for the WHERE clause
                null,//selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        List<Person> persons = new ArrayList<Person>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(PersonContract.PersonEntry._ID));
            String  firstName   =cursor.getString(cursor.getColumnIndexOrThrow(PersonContract.PersonEntry.COLUMN_NAME_FIRSTNAME));
            String  lastName   =cursor.getString(cursor.getColumnIndexOrThrow(PersonContract.PersonEntry.COLUMN_NAME_LASTNAME));
            int  avatar   =cursor.getInt(cursor.getColumnIndexOrThrow(PersonContract.PersonEntry.COLUMN_NAME_AVATAR));
            Person person   =new Person(firstName, lastName, avatar);
            persons.add(person);
        }
        cursor.close();
        return persons;
    }

    @Override
    public void addPerson(Person person) {
        Log.i(TAG, "addPerson");
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(PersonContract.PersonEntry.COLUMN_NAME_FIRSTNAME, person.getPrenom());
        values.put(PersonContract.PersonEntry.COLUMN_NAME_LASTNAME, person.getNom());
        values.put(PersonContract.PersonEntry.COLUMN_NAME_AVATAR, person.getAvatarColor() + "");

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(PersonContract.PersonEntry.TABLE_NAME, null, values);
    }

    @Override
    public void removePerson(Person person) {
        Log.i(TAG, "removePerson");
        // Define 'where' part of query.
        String selection = PersonContract.PersonEntry.COLUMN_NAME_FIRSTNAME + " LIKE ? AND "+PersonContract.PersonEntry.COLUMN_NAME_LASTNAME+" LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { person.getPrenom(), person.getNom() };
        // Issue SQL statement.
        db.delete(PersonContract.PersonEntry.TABLE_NAME, selection, selectionArgs);
    }
}
