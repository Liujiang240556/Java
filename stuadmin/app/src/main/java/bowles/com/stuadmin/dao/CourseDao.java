package bowles.com.stuadmin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import bowles.com.stuadmin.model.Course;
import bowles.com.stuadmin.model.Student;
import bowles.com.stuadmin.util.SQLhelper;

public class CourseDao {
    private SQLhelper helper;
    public  CourseDao(Context context){
        helper = new SQLhelper(context);
    }
    public void insert( Course cs) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Course_name", cs.getCourse_name());
        values.put("Course_no", cs.getCourse_no());
        values.put("Credit",cs.getCredit());
        values.put("Pre_course_no",cs.getPre_course_no());

        db.insert("Course", null, values);
        db.close();
    }


}
