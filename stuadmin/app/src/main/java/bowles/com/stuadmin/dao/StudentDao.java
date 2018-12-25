package bowles.com.stuadmin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import bowles.com.stuadmin.model.Student;
import bowles.com.stuadmin.util.SQLhelper;

import static android.content.ContentValues.TAG;

public class StudentDao {
    private SQLhelper helper;
    public  StudentDao(Context context){
        helper = new SQLhelper(context);
    }
    public void insert( Student st) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        Log.i("开始插入学生", "insert: ");
        values.put("name", st.getName());
        values.put("id", st.getiD());
        values.put("sex",st.getSex());
        values.put("institution_NO",st.getInstitution_NO());
        values.put("age",st.getAge());
        db.insert("Student", null, values);
        Log.i("结束插入", "insert: ");
        db.close();
    }

}
