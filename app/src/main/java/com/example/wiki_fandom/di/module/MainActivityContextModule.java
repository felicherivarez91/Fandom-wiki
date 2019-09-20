package com.example.wiki_fandom.di.module;

import android.content.Context;
import com.example.wiki_fandom.MainActivity;
import com.example.wiki_fandom.di.qualifier.ActivityContext;
import com.example.wiki_fandom.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {

    private MainActivity mainActivity;
    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}

