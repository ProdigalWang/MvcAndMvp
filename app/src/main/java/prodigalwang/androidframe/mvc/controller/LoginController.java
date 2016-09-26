package prodigalwang.androidframe.mvc.controller;

import android.text.TextUtils;
import android.view.View;

import prodigalwang.androidframe.R;
import prodigalwang.androidframe.activity.LoginActivity;
import prodigalwang.androidframe.callback.LoginCallBack;
import prodigalwang.androidframe.mvc.model.ILoginModel;
import prodigalwang.androidframe.mvc.model.LoginModelImpl;
import prodigalwang.androidframe.mvc.view.LoginView;

/**
 * Author：ProdigalWang
 * Time: 2016/9/26
 * 逻辑控制层,接受用户的请求数据,自身不对数据进行处理，而是通过一定的判断后决定调用模型层的具体某个功能。
 */
public class LoginController implements View.OnClickListener {

    private LoginView loginView;
    private ILoginModel iLoginModel;

    public LoginController( LoginView loginView,LoginActivity loginActivity){
        this.loginView=loginView;

        iLoginModel=new LoginModelImpl(loginActivity);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                String username=loginView.getName();
                String pwd=loginView.getPwd();

                if (TextUtils.isEmpty(username)){
                    loginView.userNameEpty();
                    break;
                }
                if (TextUtils.isEmpty(pwd)){
                    loginView.passWordEpty();
                    break;
                }
                //调用模型层去处理具体的请求
                iLoginModel.login(username, pwd, new LoginCallBack() {
                    @Override
                    public void success() {
                        loginView.loginSuccess();
                    }

                    @Override
                    public void fail(int status) {
                        if (status==0){
                            //模型层完成数据处理后,通知视图层做出相应的改变。用户得到反馈。
                            loginView.passWordError();
                        }else if (status==-1){
                            loginView.userNameError();
                        }else {
                            loginView.loginFailure();
                        }
                    }

                });
                break;
        }
    }
}
