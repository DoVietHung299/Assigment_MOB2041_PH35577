package com.example.mob2041_duanmauandroid.LOPDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mob2041_duanmauandroid.LOPPRODUCT.ThanhVien;
import com.example.mob2041_duanmauandroid.SQLopenhelper.CreateData;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienDao {
    SQLiteDatabase sqLitetv;
    CreateData createData;

    public ThanhVienDao(Context context) {
        createData = new CreateData(context);
        sqLitetv = createData.getWritableDatabase();
    }

    public long ADDTV(ThanhVien thanhVien) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ThanhVien.COL_NAME_HOTEN, thanhVien.getHoTenTV());
        contentValues.put(ThanhVien.COL_NAME_NAMSINH, thanhVien.getNamsinhTV());
        contentValues.put(ThanhVien.COL_CCCD, thanhVien.getCccd());

        return sqLitetv.insert(ThanhVien.TB_NAME, null, contentValues);
    }

    public int UPDATETV(ThanhVien thanhVien) {
        ContentValues values = new ContentValues();
        values.put(ThanhVien.COL_NAME_HOTEN, thanhVien.getHoTenTV());
        values.put(ThanhVien.COL_NAME_NAMSINH, thanhVien.getNamsinhTV());
        values.put(ThanhVien.COL_CCCD, thanhVien.getCccd());
        return sqLitetv.update(ThanhVien.TB_NAME, values, "maTV=?", new String[]{String.valueOf(thanhVien.getIDTV())});
    }

    public int DELETETV(ThanhVien thanhVien) {
        return sqLitetv.delete(ThanhVien.TB_NAME, "maTV=?", new String[]{String.valueOf(thanhVien.getIDTV())});
    }

    public List<ThanhVien> GETTV() {
        String dl = "SELECT * FROM ThanhVien";
        List<ThanhVien> list = getdata(dl);
        return list;
    }

    public ThanhVien getId(String id) {
        String dl = "SELECT * FROM ThanhVien WHERE maTV=?";
        List<ThanhVien> list = getdata(dl, id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    private List<ThanhVien> getdata(String dl, String... args) {
        List<ThanhVien> list = new ArrayList<>();
        Cursor cursor = sqLitetv.rawQuery(dl, args);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                ThanhVien thanhVien = new ThanhVien();
                thanhVien.setIDTV(cursor.getInt(cursor.getColumnIndex(ThanhVien.COL_NAME_ID)));
                thanhVien.setHoTenTV(cursor.getString(cursor.getColumnIndex(ThanhVien.COL_NAME_HOTEN)));
                thanhVien.setNamsinhTV(cursor.getString(cursor.getColumnIndex(ThanhVien.COL_NAME_NAMSINH))); // Đảm bảo set đúng giá trị
                thanhVien.setCccd(cursor.getString(cursor.getColumnIndex(ThanhVien.COL_CCCD)));
                list.add(thanhVien);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }
}
