package cn.transcodegroup.libcommonproject;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import cn.transcodegroup.lib.module.ModuleContext;
import cn.transcodegroup.lib.module.Router;
import cn.transcodegroup.lib.module.service.LanguageService;

class SampleModuleContext extends ModuleContext {
    public SampleModuleContext(Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Router.getInstance().registerPath("/activity/main", MainActivity.class);
        Router.getInstance().registerService(LanguageService.class, new LanguageService() {
            @Override
            public Context wrapBaseContextForActivity(Context base) {
                Log.d(App.TAG, "wrapBaseContextForActivity: " + base);
                return base;
            }
        });
    }
}
