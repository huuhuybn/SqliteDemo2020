package vn.poly.edu.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SinhVienSQL {

    private MySql mySql;

    public SinhVienSQL(MySql mySql) {
        this.mySql = mySql;
    }

    public long themSinhVien(SinhVien sinhVien) {
        // 1 - xin quyen
        SQLiteDatabase sqLiteDatabase = mySql.getWritableDatabase();
        // 2 - ghép cặp giá trị với tên cột tương ứng
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", sinhVien.id);
        contentValues.put("name", sinhVien.name);
        contentValues.put("phone", sinhVien.phone);
        // 3 - thực thi insert sinh viên và kiểm tra kết quả
        // tên bảng phải khớp với bên MySql.java
        long ketqua = sqLiteDatabase.insert("sinhvien",
                null, contentValues);
        return ketqua;
    }


    public List<SinhVien> getAllSinhVien() {
        // xin quyen doc/ghi
        SQLiteDatabase sqLiteDatabase = mySql.getReadableDatabase();
        // khai bao cau lenh select
        String select = "SELECT * FROM sinhvien";
        // thuc thi cau lenh va doc du lieu
        Cursor cursor = sqLiteDatabase.rawQuery(select, null);

        List<SinhVien> sinhVienList = new ArrayList<>();

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            while (cursor.isAfterLast() == false) {

                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String phone = cursor.getString(2);

                SinhVien sinhVien = new SinhVien();
                sinhVien.id = id;
                sinhVien.name = name;
                sinhVien.phone = phone;
                sinhVienList.add(sinhVien);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sinhVienList;

    }

}
