package prodigalwang.androidframe.mvc.model;

import prodigalwang.androidframe.callback.LoginCallBack;

/**
 * 模型层———登录接口
 */

public interface ILoginModel {

    void login(String name, String pwd, LoginCallBack loginCallBack);
}
