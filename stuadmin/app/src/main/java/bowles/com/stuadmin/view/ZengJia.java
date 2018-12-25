package bowles.com.stuadmin.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bowles.com.stuadmin.R;
import bowles.com.stuadmin.dao.CourseDao;
import bowles.com.stuadmin.dao.ScoreDao;
import bowles.com.stuadmin.dao.StudentDao;
import bowles.com.stuadmin.model.Course;
import bowles.com.stuadmin.model.Score;
import bowles.com.stuadmin.model.Student;
import bowles.com.stuadmin.service.ScoreManage;

public class ZengJia extends AppCompatActivity {
     private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;
    private EditText editText11;
    private EditText editText12;
    private Button button;
    private Button button2;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getApplicationContext();
        setContentView(R.layout.activity_zeng_jia);
        Log.i("sssssssssss-------","kaiahi");
//        initview();
        //学号
        editText1=this.findViewById(R.id.editText4);

        //姓名
        editText2=findViewById(R.id.editText2);
        //年龄
        editText3=findViewById(R.id.editText5);
        //性别
        editText4=findViewById(R.id.editText3);
        //院系号
        editText5=findViewById(R.id.editText7);

        //课程号
        editText6=findViewById(R.id.editText10);
        //课程名
        editText7=findViewById(R.id.editText8);
        //先修课号
        editText8=findViewById(R.id.editText11);
        //学分
        editText9=findViewById(R.id.editText9);


        //学号
        editText10=findViewById(R.id.editText13);
        //课程号
        editText11=findViewById(R.id.editText12);
        //得分
        editText12=findViewById(R.id.editText14);

        button=this.findViewById(R.id.button5);
        button2=this.findViewById(R.id.back);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZengJia.this.finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  str1=editText1.getText().toString().trim();
                String  str2=editText2.getText().toString().trim();
                String  str3=editText3.getText().toString().trim();
                String  str4=editText4.getText().toString().trim();
                String  str5=editText5.getText().toString().trim();




                String  str6=editText6.getText().toString().trim();
                String  str7=editText7.getText().toString().trim();
                String  str8=editText8.getText().toString().trim();
                String  str9=editText9.getText().toString().trim();


                String  str10=editText10.getText().toString().trim();
                String  str11=editText11.getText().toString().trim();
                String  str12=editText12.getText().toString().trim();



                if("".equals(str1)||"".equals(str2)||"".equals(str3)||"".equals(str4)||"".equals(str5)||"".equals(str6)||"".equals(str7)||"".equals(str8)||"".equals(str9)||"".equals(str10)||"".equals(str11)||"".equals(str12)){
                     Toast.makeText(ZengJia.this,"请不要有空的内容",Toast.LENGTH_SHORT).show();

                }else{

                    if(str1.equals(str10)&&str6.equals(str11)){

                        Course cs=new Course();
                        cs.setCourse_name(str7);

                        cs.setCourse_no(str6);
                        cs.setCredit(str9);
                        cs.setPre_course_no(str8);

                        Student sd=new Student();
                        sd.setAge(str3);
                        sd.setiD(str1);
                        sd.setName(str2);
                        sd.setInstitution_NO(str5);
                        sd.setSex(str4);

                        Score sc=new Score();
                        sc.setCourse_no(str11);
                        sc.setStu_grade(str12);
                        sc.setStu_no(str10);
                        System.out.print("sssssssssss-------"+str7);
                        CourseDao s1=new CourseDao(ZengJia.this);
                        s1.insert(cs);
                        ScoreDao s2=new ScoreDao(ZengJia.this);
                        s2.insert(sc);
                        StudentDao s3 =new StudentDao(ZengJia.this);
                        s3.insert(sd);
                        Toast.makeText(ZengJia.this,"插入数据库成功！",Toast.LENGTH_SHORT).show();
                        ZengJia.this.finish();
                    }else{


                        Toast.makeText(ZengJia.this,"成绩表的学号与学生表的学号不一样，成绩表的课程号与课程表的课程号的不一样，注意检查",Toast.LENGTH_SHORT).show();
                    }

                }



            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }





}
