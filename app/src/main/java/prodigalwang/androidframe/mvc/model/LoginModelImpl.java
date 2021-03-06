package prodigalwang.androidframe.mvc.model;

import prodigalwang.androidframe.callback.LoginCallBack;
import prodigalwang.androidframe.db.MyDataBaseHelper;
import prodigalwang.androidframe.bean.User;
import prodigalwang.androidframe.utils.MyAppliction;

/**
 * Author：ProdigalWang
 * Time: 2016/9/26
 * 模型层实现,完成具体的数据操作。
 */

public class LoginModelImpl implements ILoginModel {

    private MyDataBaseHelper myDataBaseHelper;

    @Override
    public void login(String name, String pwd, LoginCallBack loginCallBack) {

        User user=new User();
        user.setName(name);
        user.setPwd(pwd);

        myDataBaseHelper = new MyDataBaseHelper(MyAppliction.getContext(), "Login.db", null, 1);

        int result = myDataBaseHelper.queryData(user);

        //发出处理结果，用户得到反馈
        if (result == 1) {

            loginCallBack.success(user);
        } else {
            loginCallBack.fail(result);
        }
    }
}
