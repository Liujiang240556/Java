package bowles.com.stuadmin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bowles.com.stuadmin.adapter.stu_infoadapter;
import bowles.com.stuadmin.dao.ScoreDao;
import bowles.com.stuadmin.model.stu_info;
import bowles.com.stuadmin.service.ScoreManage;
import bowles.com.stuadmin.util.DBManager;
import bowles.com.stuadmin.util.ImportDB;
import bowles.com.stuadmin.util.SQLhelper;
import bowles.com.stuadmin.view.ZengJia;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener {
private ListView listView;
private Button search;
private  Button insert;
private  Button display;
private EditText key;
private Context context;
private stu_infoadapter  adpt;
    public ImportDB importDB;
    public SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        this.context=getBaseContext();
     //导入外部数据库
        importDB = new ImportDB(this);
        importDB.openDatabase();


//        DBManager dbManager=new DBManager(this);
//        db=dbManager.DBManager(getPackageName());
 //       db=SQLiteDatabase.openOrCreateDatabase(ImportDB.DB_PATH + "/" + ImportDB.DB_NAME, null);
        listView=findViewById(R.id.listView);
        search=findViewById(R.id.buttonsearch);
        insert=findViewById(R.id.buttoninsert);
        key=findViewById(R.id.editText);
        listView=findViewById(R.id.listView);
        display=findViewById(R.id.displayall);
        search.setOnClickListener(this);
        insert.setOnClickListener(this);
        display.setOnClickListener(this);

        listView.setOnItemLongClickListener(this);
        List<stu_info> list = new ArrayList<stu_info>();

        ScoreDao cd=new ScoreDao(context);
        list =cd.findall();

        if(null==list||list.isEmpty()){
            Toast.makeText(context,"数据库为空，请先插入数据",Toast.LENGTH_SHORT).show();
            adpt= new stu_infoadapter(context,list);
            listView.setAdapter(adpt);

        }else {
            adpt= new stu_infoadapter(context,list);
            listView.setAdapter(adpt);

        }
//        init();
    }



    @Override
    public void onClick(View v) {
        db=SQLiteDatabase.openOrCreateDatabase(ImportDB.DB_PATH + "/" + ImportDB.DB_NAME, null);
        List<stu_info> list = new ArrayList<stu_info>();
        ScoreDao cd=new ScoreDao(context);
        list =cd.findall();

        switch (v.getId()){
            case R.id.buttoninsert:
                Intent intent=new Intent(MainActivity.this,ZengJia.class);
                startActivity(intent);
                break;
            case  R.id.buttonsearch:
                String keyword=key.getText().toString().trim();
                if (keyword==null||"".equals(keyword)){
                    Toast.makeText(MainActivity.this,"请输入要查询的学生姓名！",Toast.LENGTH_SHORT).show();

                }else {

                    List<stu_info> list2 = new ArrayList<stu_info>();

                    ScoreDao cd1 = new ScoreDao(MainActivity.this);
                    list2= cd1.findbyname(keyword);

                    if (null == list || list.isEmpty()) {

                        Toast.makeText(MainActivity.this, "数据库中没有数据！", Toast.LENGTH_SHORT).show();

                        adpt = new stu_infoadapter(context, list2);
                        listView.setAdapter(adpt);

                        //bindsourse();

                    } else {


                        adpt = new stu_infoadapter(context, list2);
                        listView.setAdapter(adpt);

//
                    }
                }
                break;
            case  R.id.displayall:

                adpt= new stu_infoadapter(context,list);
                listView.setAdapter(adpt);
                break;
        }
    }

    @Override
    protected void onResume() {

        super.onResume();
        List<stu_info> list = new ArrayList<stu_info>();
        ScoreDao cd=new ScoreDao(context);
        list =cd.findall();
        adpt= new stu_infoadapter(context,list);
        listView.setAdapter(adpt);

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv_name = view.findViewById(R.id.name);
        TextView tv_course = view.findViewById(R.id.course);
        TextView tv_score = view.findViewById(R.id.score);
        final String name = tv_name.getText().toString();
        final String course=tv_course.getText().toString();
        final  String   score  =  tv_score.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("删除便签");
        builder.setMessage("确认删除吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SQLhelper helper;
                helper = new SQLhelper(context);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("delete  FROM score WHERE stu_grade='" + score+"'");
//                db.execSQL("delete  FROM course WHERE course_name='" + course+"'");

                Toast.makeText(MainActivity.this,"删除成功！",Toast.LENGTH_SHORT).show();
                listView.invalidate();

                List<stu_info> list = new ArrayList<stu_info>();
                ScoreDao cd=new ScoreDao(context);
                list =cd.findall();
                adpt= new stu_infoadapter(context,list);
                listView.setAdapter(adpt);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create();
        builder.show();
        return true;
    }
}
