package com.example.wiki_fandom;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.wiki_fandom.di.component.ApplicationComponent;
import com.example.wiki_fandom.di.component.DaggerMainActivityComponent;
import com.example.wiki_fandom.di.component.MainActivityComponent;
import com.example.wiki_fandom.pojo.Wiki;
import com.example.wiki_fandom.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/*
 * Все права на интеллектуальную собственность принадлежат Ткачуку Дмитрию Викторовичу
 * Email: thunderbird251991@gmail.com
 * Моб.номер +375(44)465-83-83
 * @author Dmitry Tkachuk
 */
public class MainActivity extends AppCompatActivity {

    private static final int NO_INTERNTET_CONNECTION  = 0;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @Inject
    public TopWikis topWikis;
    SectionsPagerAdapter sectionsPagerAdapter;
    MainActivityComponent mainActivityComponent;

    /*
     * Here we inject our Dagger dependencies after we make a rxjava call
     * and when we receive response we set the data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isNetworkConnected()) {
            finish();
            System.exit(NO_INTERNTET_CONNECTION);
        }
        ButterKnife.bind(this);
        ApplicationComponent applicationComponent =
                                                 MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .build();
        mainActivityComponent.injectMainActivity(this);
        rxjavacall();
    }

    //Subscribe on call
    private void rxjavacall() {
        Observable<Wiki> cryptoObservable = topWikis.getWikis(1,30,1);
        cryptoObservable.
                subscribeOn(Schedulers.io()).
                subscribe(this::handleResults);
    }

    //Set up view pager
    private void handleResults(Wiki wikis) {
        runOnUiThread(() -> {
            sectionsPagerAdapter = new
                    SectionsPagerAdapter(MainActivity.this,
                                                         getSupportFragmentManager(), wikis);
            viewPager.setAdapter(sectionsPagerAdapter);
            tabs.setupWithViewPager(viewPager);
        });
    }

    //Checks whether an internet connection is on.
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}