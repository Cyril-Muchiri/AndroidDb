package com.example.androiddb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    final String customers = "customers";
    public static final String Customer_NAME = "Name";
    public static final String AGE = "Age";
    public static final String STATUS = "status";

    public DbHelper(@Nullable Context context) {
        super(context, "Customers.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String id = "id";

        String createStatement= "CREATE TABLE " + customers + "(" + id + " Integer primary key autoincrement," + Customer_NAME + " TEXT," + AGE + " int," + STATUS + " Bool);";
sqLiteDatabase.execSQL(createStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addItem(Model model){

    SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Customer_NAME,model.name);
        cv.put(AGE,model.age);
        cv.put(STATUS,model.isActive);

        long insert = db.insert(customers, null, cv);
        if (insert==-1) {
            return false;
        }else {
            return true;
        }

    }
    public List<Model>getEveryone(){
        List<Model> returnList=new ArrayList<>();

        String query="SELECT * FROM "+customers;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                int customerId= cursor.getInt(0);
                String customerName=cursor.getString(1);
                int customerAge=cursor.getInt(2);
                Boolean status=cursor.getInt(3)==1 ? true:false;

                Model newCustomer=new Model(customerId,customerName,customerAge,status);
                returnList.add(newCustomer);

            }while (cursor.moveToFirst());
        }
cursor.close();
        db.close();


        return returnList;
    }

}
