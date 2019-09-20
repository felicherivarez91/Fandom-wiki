package com.example.wiki_fandom;

import android.app.Activity;
import android.app.Application;

import com.example.wiki_fandom.di.component.ApplicationComponent;
import com.example.wiki_fandom.di.component.DaggerApplicationComponent;
import com.example.wiki_fandom.di.module.ContextModule;

/*
 * Все права на интеллектуальную собственность принадлежат Ткачуку Дмитрию Викторовичу
 * Email: thunderbird251991@gmail.com
 * Моб.номер +375(44)465-83-83
 * @author Dmitry Tkachuk
 */
public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().
                                                     contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);
    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
