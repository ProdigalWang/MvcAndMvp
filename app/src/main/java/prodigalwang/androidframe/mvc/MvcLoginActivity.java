package prodigalwang.androidframe.mvc;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import prodigalwang.androidframe.R;
import prodigalwang.androidframe.db.MyDataBaseHelper;
import prodigalwang.androidframe.mvc.controller.LoginController;
import prodigalwang.androidframe.mvc.view.LoginView;

/**
        * 此时Activity就变为了承载视图层的容器。
        */
public class MvcLoginActivity extends AppCompatActivity {

    private MyDataBaseHelper myDataBaseHelper;
    private SQLiteDatabase db;

    private LoginView loginView;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc_login);

        //初始化一个本地用户用来模拟登陆。
        myDataBaseHelper = new MyDataBaseHelper(this, "Login.db", null, 1);
        db = myDataBaseHelper.getWritableDatabase();
        //myDataBaseHelper.initData(db);

        MVC();
    }

    private void MVC(){
        //控件初始化和绑定
        loginView= (LoginView) findViewById(R.id.activity_login_mvc);
        loginView.initView();

        loginController=new LoginController(loginView);//视图层结合控制层
        loginView.setOnclikLister(loginController);
    }
}
