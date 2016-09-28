package prodigalwang.androidframe.mvp.presenter;

import android.widget.Toast;

import prodigalwang.androidframe.bean.User;
import prodigalwang.androidframe.callback.LoginCallBack;

import prodigalwang.androidframe.mvp.model.ILoginModel;
import prodigalwang.androidframe.mvp.model.LoginModelImpl;
import prodigalwang.androidframe.mvp.view.ILoginView;

/**
 * Author：ProdigalWang
 * Time: 2016/9/28
 * 主持人层
 */
public class LoginPresenter  {

    private ILoginView iLoginView;//视图层
    private ILoginModel iLoginModel;//模型层

    public LoginPresenter(ILoginView iLoginView){
        this.iLoginView=iLoginView;

        this.iLoginModel=new LoginModelImpl();
    }

    public void login(){

        iLoginModel.login(iLoginView.getName(), iLoginView.getPwd(), new LoginCallBack() {
            @Override
            public void success(User user) {

                iLoginView.loginSucess(user);
            }

            @Override
            public void fail(int status) {
               iLoginView.loginFailTips(status);
            }
        });
    }
}
