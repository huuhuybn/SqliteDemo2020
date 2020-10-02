package vn.poly.edu.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MySql mySql = new MySql(MainActivity.this);


        Button btnThem = findViewById(R.id.btnThem);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.id = "124";
                sinhVien.name = "HUY NHUYU";
                sinhVien.phone = "0913360468";

                SinhVienSQL sinhVienSQL = new SinhVienSQL(mySql);

                long ketqua = sinhVienSQL.themSinhVien(sinhVien);

                List<SinhVien> sinhVienList = sinhVienSQL.getAllSinhVien();
                if (ketqua > 0) {
                    Toast.makeText(MainActivity.this, "THEM THANH CONG!!! : " +
                                    sinhVienList.size(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "THEM KHONG THANH CONG!!!." +
                                    "Kiem tra LOG CAT xem loi ngay!!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}