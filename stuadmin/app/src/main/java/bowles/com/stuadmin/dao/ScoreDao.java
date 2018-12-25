package bowles.com.stuadmin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import bowles.com.stuadmin.model.Course;
import bowles.com.stuadmin.model.Score;
import bowles.com.stuadmin.model.stu_info;
import bowles.com.stuadmin.util.ImportDB;
import bowles.com.stuadmin.util.SQLhelper;

public class ScoreDao {
    private SQLhelper helper;
    public  ScoreDao(Context context){
        helper = new SQLhelper(context);
    }
    public void insert( Score score) {
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(ImportDB.DB_PATH + "/" + ImportDB.DB_NAME, null);
        ContentValues values = new ContentValues();
        values.put("Course_no", score.getCourse_no());
        values.put("Stu_grade", score.getStu_grade());
        values.put("Stu_no",score.getStu_no());
        db.insert("Score", null, values);
        db.close();
    }
    public List<stu_info> findbyname(String name){
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(ImportDB.DB_PATH + "/" + ImportDB.DB_NAME, null);
        String stuname;
        String  course_sore;
        String   course_name;
        List<stu_info> list = new ArrayList<stu_info>();

        //SELECT course.course_name,score.stu_grade,student.`name` FROM course,score,student WHERE student.`name`='ss'
        //SELECT score.stu_grade, course.course_name, student.name FROM score INNER JOIN course ON score.course_no = course.course_no INNER JOIN student ON score.stu_no = student.id ;
        //Cursor c2 = db.query("secret", null, "name=?", new String[]{name}, null, null, null);
        Cursor c =db.rawQuery("SELECT *  FROM NewView WHERE  name like '%"+name+"%'",null);
        while (c.moveToNext()) {
            stu_info  stu_info2 = new stu_info();
            course_name = c.getString(c.getColumnIndex("course_name"));
            stuname=c.getString(c.getColumnIndex("name"));
            course_sore=c.getString(c.getColumnIndex("stu_grade"));
            stu_info2.setCourse_name(course_name);
            stu_info2.setCourse_score(course_sore);
            stu_info2.setName(stuname);
            list.add(stu_info2);
        }
        c.close();
        db.close();
        return list;
    }

    public List<stu_info> findall(){
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(ImportDB.DB_PATH + "/" + ImportDB.DB_NAME, null);
        Cursor c = db.rawQuery("SELECT distinct course.course_name,student.name,score.stu_grade FROM course,score,student\n" +
                "WHERE score.course_no=course.course_no and score.stu_no=student.id",null);
        List<stu_info> list = new ArrayList<stu_info>();
        while (c.moveToNext()) {
            String stuname;
            String  course_sore;
            String   course_name;
            course_name = c.getString(c.getColumnIndex("course_name"));
            stuname=c.getString(c.getColumnIndex("name"));
            course_sore=c.getString(c.getColumnIndex("stu_grade"));
            stu_info  stu_info2 = new stu_info();
            stu_info2.setCourse_name(course_name);
            stu_info2.setCourse_score(course_sore);
            stu_info2.setName(stuname);
            list.add(stu_info2);
        }
        c.close();
        db.close();
        return list;
    }


}
