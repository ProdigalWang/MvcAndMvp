package prodigalwang.androidframe.mvc.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import prodigalwang.androidframe.R;

/**
 * Author：ProdigalWang
 * Time: 2016/9/26
 * 视图层,直接展示给用户。通过视图层将数据请求传送到控制层(Controller)
 * 作为视图层来说,它只是作为接受用户数据和展示数据的方式
 */
public class LoginView extends LinearLayout {

    private Context mContext;
    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginBtn;

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void initView() {
        mUsername = (EditText) findViewById(R.id.et_name);
        mPassword = (EditText) findViewById(R.id.et_pwd);
        mLoginBtn = (Button) findViewById(R.id.bt_login);
    }

    public String getName() {
        return mUsername.getText().toString();
    }

    public String getPwd() {
        return mPassword.getText().toString();
    }

    public void setOnclikLister(OnClickListener onclikLister) {
        mLoginBtn.setOnClickListener(onclikLister);
    }

    public void userNameEpty() {
        Toast.makeText(mContext, "用户名不能为空", Toast.LENGTH_SHORT).show();
    }

    public void passWordEpty() {
        Toast.makeText(mContext, "密码不能为空", Toast.LENGTH_SHORT).show();
    }

    public void userNameError() {
        Toast.makeText(mContext, "用户名错误", Toast.LENGTH_SHORT).show();
    }

    public void passWordError() {
        Toast.makeText(mContext, "密码错误", Toast.LENGTH_SHORT).show();
    }

    public void loginSuccess() {
        Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
    }

    public void loginFailure() {
        Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT).show();
    }
}

