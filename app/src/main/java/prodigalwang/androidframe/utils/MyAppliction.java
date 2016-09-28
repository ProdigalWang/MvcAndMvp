package prodigalwang.androidframe.utils;

import android.app.Application;
import android.content.Context;

/**
 * Author：ProdigalWang
 * Time: 2016/9/28
 */
public class MyAppliction extends Application {

    private  static Context context;
    @Override
    public void onCreate() {
        context=getApplicationContext();
    }
    public static Context getContext(){
        return  context;
    }

}
