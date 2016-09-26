package prodigalwang.androidframe.mvc.model;

import android.content.Context;

import prodigalwang.androidframe.callback.LoginCallBack;
import prodigalwang.androidframe.db.MyDataBaseHelper;

/**
 * Author：ProdigalWang
 * Time: 2016/9/26
 * 模型层实现,通常是对数据库的操作,完成具体的数据操作。
 */

public class LoginModelImpl implements ILoginModel {

    private MyDataBaseHelper myDataBaseHelper;

    private Context mContext;

    public LoginModelImpl(Context context) {
        mContext = context;
    }

    @Override
    public void login(String name, String pwd, LoginCallBack loginCallBack) {

        myDataBaseHelper = new MyDataBaseHelper(mContext, "Login.db", null, 1);

        int result = myDataBaseHelper.queryData(myDataBaseHelper.getReadableDatabase(), name, pwd);

        //发出处理结果，用户得到反馈
        if (result == 1) {
            loginCallBack.success();
        } else {
            loginCallBack.fail(result);
        }
    }
}
