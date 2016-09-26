package prodigalwang.androidframe.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import prodigalwang.androidframe.R;
import prodigalwang.androidframe.db.MyDataBaseHelper;
import prodigalwang.androidframe.mvc.controller.LoginController;
import prodigalwang.androidframe.mvc.view.LoginView;

public class LoginActivity extends AppCompatActivity {

    private MyDataBaseHelper myDataBaseHelper;
    private SQLiteDatabase db;

    private LoginView loginView;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化一个本地用户用来模拟登陆。
        myDataBaseHelper = new MyDataBaseHelper(this, "Login.db", null, 1);
        db = myDataBaseHelper.getWritableDatabase();
        myDataBaseHelper.initData(db);

        //控件初始化和绑定
        loginView= (LoginView) findViewById(R.id.activity_login);
        loginView.initView();

        loginController=new LoginController(loginView,this);//视图层结合控制层
        loginView.setOnclikLister(loginController);
    }
}
