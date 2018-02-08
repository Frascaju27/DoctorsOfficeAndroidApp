package a2101020604.a2101020604;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by justinfrasca on 2017-11-18.
 */

public class DatabaseHelperClass extends SQLiteOpenHelper {
    private String password;
    public static final String DATABASE_NAME = "Hospital.db";
    public static final String TABLE_NAME = "EmployeeDoc";
    public static final String KEY_PASSWORD = "Password";
    public static final String TABLE_Patients = "PatientsTest";
    public static final String TABLE_Tests = "Tests";

    public DatabaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, Department TEXT, Username TEXT,"+ KEY_PASSWORD +" TEXT, FullName TEXT );");
        db.execSQL("create table " + TABLE_Patients + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, RoomNum TEXT, DoctorName TEXT );");
        db.execSQL("create table " + TABLE_Tests + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, PatientName TEXT, BPL INTEGER, BPH INTEGER, Tempature INTEGER );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Patients);

        onCreate(db);
    }

    public boolean insertData(String Username, String Password, String FullName, String Department) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username", Username);
        contentValues.put("Password", Password);
        contentValues.put("FullName", FullName);
        contentValues.put("Department", Department);
        long result = db.insert(TABLE_NAME,null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData2(String FirstName, String LastName, String RoomNum, String DoctorName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues PatientsDb = new ContentValues();
        PatientsDb.put("FirstName", FirstName);
        PatientsDb.put("LastName", LastName);
        PatientsDb.put("RoomNum", RoomNum);
        PatientsDb.put("DoctorName", DoctorName);
        long result = db.insert(TABLE_Patients, null, PatientsDb);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData3(String PatientName, String BPL, String BPH, String Tempature) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues TestDb = new ContentValues();
        TestDb.put("PatientName", PatientName);
        TestDb.put("BPL", BPL);
        TestDb.put("BPH", BPH);
        TestDb.put("Tempature",Tempature);
        long result = db.insert(TABLE_Tests, null, TestDb);
        if (result == -1)
            return false;
        else
            return true;
    }


    String getregister(String Username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,null,  "Username=?",new String[]{Username},null, null, null, null);

        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }
        return password;


    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor PatientRes = db.rawQuery("select * from "+ TABLE_Tests,null);
        return PatientRes;
    }
    public Cursor getAllData2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor PatientRes = db.rawQuery("select * from "+ TABLE_Patients,null);
        return PatientRes;
    }

    public Cursor getAllData3() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor PatientRes = db.rawQuery("select * from "+ TABLE_NAME,null);
        return PatientRes;
    }



}