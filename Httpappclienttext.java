package test.bwie.com.yuekao_dianji;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * date: 2017/5/27
 * author:陈茹
 * 类的用途:
 */
public class Httpappclienttext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration image=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,800).build();
        ImageLoader.getInstance().init(image);
    }
}

