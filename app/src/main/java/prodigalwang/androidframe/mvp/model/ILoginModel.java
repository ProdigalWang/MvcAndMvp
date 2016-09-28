package prodigalwang.androidframe.mvp.model;

import prodigalwang.androidframe.callback.LoginCallBack;

/**
 * Created by WJ on 2016/9/28.
 */

public interface ILoginModel {

    void login(String name, String pwd, LoginCallBack loginCallBack);
}
