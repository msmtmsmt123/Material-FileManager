package stormouble.op.material_filemanager;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Stormouble on 16/1/21.
 */
public class APP extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }
}
