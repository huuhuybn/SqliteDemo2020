package vn.poly.edu.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper {

    // khoi tao,
    // tên của file csdl, khai báo phiên bản của csdl
    public MySql(Context context) {
        super(context, "data.sql", null, 1);
    }

    // phuong thuc dung de khoi tạo bảng,

    String tao_bang = "create table sinhvien " +
            "(id varchar primary key, name nvarchar, phone varchar)";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tao_bang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
