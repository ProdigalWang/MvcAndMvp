package prodigalwang.androidframe.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import prodigalwang.androidframe.R;
import prodigalwang.androidframe.bean.User;
import prodigalwang.androidframe.mvp.presenter.LoginPresenter;
import prodigalwang.androidframe.mvp.view.ILoginView;

public class MvpLoginActivity extends AppCompatActivity implements ILoginView{

    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginBtn;

    private LoginPresenter loginPresenter=new LoginPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_login);

        initView();
    }

    private void initView(){

        mUsername= (EditText) findViewById(R.id.et_name_mvp);
        mPassword=(EditText) findViewById(R.id.et_pwd_mvp);
        mLoginBtn= (Button) findViewById(R.id.bt_login_mvp);
        mLoginBtn.setOnClickListener(loginOclick);
    }

    private View.OnClickListener loginOclick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (TextUtils.isEmpty(getName())){
                Toast.makeText(getApplicationContext(),"用户名不能为空",Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(getPwd())) {
                Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            loginPresenter.login();//调用Presenter层
        }
    };
    @Override
    public String getName() {
        return mUsername.getText().toString();
    }

    @Override
    public String getPwd() {
        return mPassword.getText().toString();
    }

    @Override
    public void loginSucess(User user) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailTips(int status) {
        if (status==0){
            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
        }else if (status==-1){
            Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }


}
