package helloworld.demo.com.stockapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "stock";
    public static final String TABLE_NAME = "stock_details";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "ITEMNO";
    public static final String COL_3 = "ITEM";
    public static final String COL_4 = "VARIANT";
    public static final String COL_5 = "INVENTORY";
    public static final String COL_6 = "PRICE1";
    public static final String COL_7 = "PRICE2";
    private static final int DATABASE_VERSION = 1;

    //TABLE CREATION
    private static final String CREATE_QUERY = " CREATE TABLE " + TABLE_NAME + " ( " +
            COL_1 + " INTEGER PRIMARY KEY ," +
            COL_2 + " TEXT ," +
            COL_3 + " TEXT ," +
            COL_4 + " TEXT ," +
            COL_5 + " TEXT ," +
            COL_6 + " TEXT ," +
            COL_7 + " TEXT )";

    //CREATING SELECT_QUERY METHOD
    private String SELECT_QUERY = " SELECT " +
            COL_1 + " , " +
            COL_2 + " , " +
            COL_3 + " , " +
            COL_4 + " , " +
            COL_5 + " , " +
            COL_6 + " , " +
            COL_7 +
            " FROM " + TABLE_NAME + " WHERE " + COL_2 + " = ? ";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //CREATING DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    //UPGRADING DATABASE
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //INSERT RECORD
    public boolean insertData(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        //CONTENTVALUES OBJECT CREATION FOR CONTENTVALUES CLASS
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, contact.getItemNo());
        contentValues.put(COL_3, contact.getItem());
        contentValues.put(COL_4, contact.getVariant());
        contentValues.put(COL_5, contact.getInventory());
        contentValues.put(COL_6, contact.getPrice1());
        contentValues.put(COL_7, contact.getPrice2());
        long result = db.insert(TABLE_NAME, null, contentValues);
        //CONDITONS TO PERFORM BOOLEAN OPERATION
        if (result == -1)
            return false;
        else
            return true;
    }


    //UPDATE RECORD
    public boolean updateData(Contact contact) {
        //TO PERFORM WRITE OPERATION IN DATABASE
        SQLiteDatabase db = this.getWritableDatabase();
        //CONTENTVALUES OBJECT CREATION FOR CONTENTVALUES CLASS
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, contact.getItem());
        contentValues.put(COL_4, contact.getVariant());
        contentValues.put(COL_5, contact.getInventory());
        contentValues.put(COL_6, contact.getPrice1());
        contentValues.put(COL_7, contact.getPrice2());
        //UPDATING DATA WITH REFERENCE TO COLOUMN2(ITEMNO)
        db.update(TABLE_NAME, contentValues, COL_2 + " = ?", new String[]{contact.getItemNo()});
        //RETURN STATEMENT FOR BOOLEAN OPERATION
        return true;
    }


    //DELETE RECORD
    public Integer deleteData(String ItemNo) {
        //TO PERFORM WRITE OPERATION IN DATABASE
        SQLiteDatabase db = this.getWritableDatabase();
        //DELETING DATA WITH REFERENCE TO COLOUMN2(ItemNO)
        return db.delete(TABLE_NAME, COL_2 + " = ?", new String[]{ItemNo});
    }

    //CHECKING ROLLNO
    public String checkItemNo(String ItemNo) {
        //TO PERFORM WRITE OPERATION IN DATABASE
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        //FOR EXCEPTION HANDLING
        try {
            //CALLING SELECT_QUERY METHOD
            cursor = db.rawQuery(SELECT_QUERY, new String[]{ItemNo});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                return cursor.getString(cursor.getColumnIndex(COL_2));
            }
        }
        //CATCHES ALL TYPES OF EXCEPTION(NULL,IO,ARRAYOVERINDEX)
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //SELECTING PARTICULAR RECORD USING ItemNo
    public Contact getContact(String ItemNo) {

        SQLiteDatabase db = this.getWritableDatabase();
        Contact contact = new Contact(ItemNo);
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(SELECT_QUERY, new String[]{ItemNo});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                contact.setID(cursor.getString(cursor.getColumnIndex(COL_1)));
                contact.setItemNo(cursor.getString(cursor.getColumnIndex(COL_2)));
                contact.setItem(cursor.getString(cursor.getColumnIndex(COL_3)));
                contact.setVariant(cursor.getString(cursor.getColumnIndex(COL_4)));
                contact.setInventory(cursor.getString(cursor.getColumnIndex(COL_5)));
                contact.setPrice1(cursor.getString(cursor.getColumnIndex(COL_6)));
                contact.setPrice2(cursor.getString(cursor.getColumnIndex(COL_7)));
            }
            return contact;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //GETTING CONTACT LISTS
    public ArrayList<Contact> getContacts() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Contact> contactlist = new ArrayList<Contact>();

        //   Cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME, null);
        Cursor c1 = null;
        c1 = db.rawQuery(" SELECT * FROM stock_details ", null);
        c1.moveToFirst();
        do {
                Contact contact = new Contact();
                contact.setID(c1.getString(c1.getColumnIndex(COL_1)));


                contact.setItemNo(c1.getString(c1.getColumnIndex(COL_2)));


                contact.setItem(c1.getString(c1.getColumnIndex(COL_3)));


                contact.setVariant(c1.getString(c1.getColumnIndex(COL_4)));


                contact.setInventory(c1.getString(c1.getColumnIndex(COL_5)));


                contact.setPrice1(c1.getString(c1.getColumnIndex(COL_6)));


                contact.setPrice2(c1.getString(c1.getColumnIndex(COL_7)));


               contactlist.add(contact);



        } while (c1.moveToNext());

        return contactlist;
    }
}






