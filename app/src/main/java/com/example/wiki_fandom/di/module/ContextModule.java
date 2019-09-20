package com.example.wiki_fandom.di.module;

import android.content.Context;
import com.example.wiki_fandom.di.qualifier.ApplicationContext;
import com.example.wiki_fandom.di.scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
