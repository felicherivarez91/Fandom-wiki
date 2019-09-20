package com.example.wiki_fandom.di.component;

import android.content.Context;
import com.example.wiki_fandom.MyApplication;
import com.example.wiki_fandom.TopWikis;
import com.example.wiki_fandom.di.module.ContextModule;
import com.example.wiki_fandom.di.module.RetrofitUserRequest;
import com.example.wiki_fandom.di.qualifier.ApplicationContext;
import com.example.wiki_fandom.di.scope.ApplicationScope;
import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitUserRequest.class})
public interface ApplicationComponent {

    TopWikis getTopWikis();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
