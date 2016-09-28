package prodigalwang.androidframe.mvp.view;

import prodigalwang.androidframe.bean.User;

/**
 * Author：ProdigalWang
 * Time: 2016/9/27
 */
public interface ILoginView {

    String getName();
    String getPwd();

    void loginSucess(User user);//登陆成功。跳到下个页面等
    void loginFailTips(int status);//登陆失败,展示失败原因

//    void showLoading(); 等待展示
//    void hideLoading();
}
