package prodigalwang.androidframe.callback;

import prodigalwang.androidframe.bean.User;

/**
 * Author：ProdigalWang
 * Time: 2016/9/26
 */
public interface LoginCallBack {
    void success(User user);
    void fail(int status);
}
