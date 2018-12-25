package bowles.com.stuadmin.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DBManager {

    public static final String DB_NAME = "studb.db"; //保存的数据库文件名
    private Context mcontext;
    public  DBManager(Context mcontext){
        this.mcontext=mcontext;
    }

    public SQLiteDatabase DBManager(String  packagename) {
          String DB_PATH = "/data/data/bowles.com.stuadmin/databases/";  //在手机里存放数据库的位置
        if (!(new File(DB_PATH+DB_NAME).exists())){
            File f=new File(DB_PATH);
            if (!f.exists()){
                f.mkdir();
            }
        }

        try {
            FileOutputStream out=new FileOutputStream(DB_PATH+DB_NAME);
            InputStream is=mcontext.getAssets().open(DB_NAME);
            byte[] buffer = new byte[400000];
            int count = 0;
            while ((count = is.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            out.close();
            is.close();
        }catch (IOException e){
               e.printStackTrace();
        }
        return  SQLiteDatabase.openOrCreateDatabase(DB_PATH+DB_NAME,
                null);
    }

}
