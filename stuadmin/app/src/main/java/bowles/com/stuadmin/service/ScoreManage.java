package bowles.com.stuadmin.service;

import android.content.Context;

import java.util.List;

import bowles.com.stuadmin.dao.CourseDao;
import bowles.com.stuadmin.dao.ScoreDao;
import bowles.com.stuadmin.dao.StudentDao;
import bowles.com.stuadmin.model.Course;
import bowles.com.stuadmin.model.Score;
import bowles.com.stuadmin.model.Student;
import bowles.com.stuadmin.model.stu_info;

public class ScoreManage {
    private static ScoreManage instance;
    private Context context;
    private static StudentDao dao;
    public static ScoreManage getInstance(Context context) {
        if (instance == null) {
            instance = new ScoreManage(context);
        }
        return instance;
    }
    private ScoreManage(Context context) {
        this.context = context;
        dao = new StudentDao(context);
    }
    public void insertStudent(Student student) {
        dao.insert(student);
    }
    public void insertCourese(Course cs) {
        CourseDao cd=new CourseDao(context);
        cd.insert(cs);
    }
    public void insertScore(Score sc) {
        ScoreDao cd=new ScoreDao(context);
        cd.insert(sc);
    }

//    public List<stu_info> queryAll() {
//       // return dao.queryAll();
//        ScoreDao cd=new ScoreDao(context);
//
////        return  cd.findall(SQLiteDatabase db);
//    }
    public  List<stu_info> findname(String  name){
        ScoreDao cd=new ScoreDao(context);
        return  cd.findbyname(name);
    }
}
