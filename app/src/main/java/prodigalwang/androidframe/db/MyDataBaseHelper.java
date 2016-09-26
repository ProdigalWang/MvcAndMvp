package prodigalwang.androidframe.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author：ProdigalWang
 * Time: 2016/9/26
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {

    private Context mContext;

    private static final String CREATE_LOGIN = "create table LoginInfo(" +
            "id integer primary key autoincrement," +
            "name text," +
            "password text)";

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LOGIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void initData(SQLiteDatabase db) {

        String sql = "insert into LoginInfo(name,password) values('test','test')";
        db.execSQL(sql);
//        ContentValues values= new ContentValues();
//        values.put("name","test");
//        values.put("password","test");
//        db.insert("LoginInfo",null,values);

    }

    public int queryData(SQLiteDatabase db, String name, String pwd) {

        String sql = "select * from LoginInfo where name=?";
        Cursor cursor = db.rawQuery(sql, new String[]{name});

        if (cursor.moveToFirst()) {
            if (cursor.getString(cursor.getColumnIndex("password")).equals(pwd)) {
                cursor.close();
                return 1;//正确
            } else {
                return 0;//密码错误
            }
        }
        return -1;//用户名错误(没有当前用户)

    }
}
