package bowles.com.stuadmin.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SQLhelper extends SQLiteOpenHelper {
    private Context mContext;
    public SQLhelper(Context context) {
        super(context, "studb.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `Student` (`id` VARCHAR(50) ,`name` VARCHAR(50) ,`sex` VARCHAR(50) ,`age` VARCHAR(50),`institution_NO` VARCHAR(50) )");
        db.execSQL("CREATE TABLE `Course` (`course_no` VARCHAR(50) ,`course_name` VARCHAR(50) ,`pre_course_no` VARCHAR(50) ,`credit` VARCHAR(50) )");
        db.execSQL("CREATE TABLE `Score` (`stu_no` VARCHAR(50) ,`course_no` VARCHAR(50) ,`stu_grade` VARCHAR(50))");

       db.execSQL("CREATE \n" +
               "VIEW `NewView`AS \n" +
               "SELECT\n" +
               "student.`name`,\n" +
               "course.course_name,\n" +
               "score.stu_grade\n" +
               "FROM\n" +
               "student\n" +
               "INNER JOIN score ON student.id = score.stu_no\n" +
               "INNER JOIN course ON score.course_no = course.course_no ;");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
