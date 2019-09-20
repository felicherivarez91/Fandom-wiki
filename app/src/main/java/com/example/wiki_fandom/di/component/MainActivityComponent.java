package com.example.wiki_fandom.di.component;

import com.example.wiki_fandom.MainActivity;
import com.example.wiki_fandom.di.scope.ActivityScope;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    void injectMainActivity(MainActivity mainActivity);
}


