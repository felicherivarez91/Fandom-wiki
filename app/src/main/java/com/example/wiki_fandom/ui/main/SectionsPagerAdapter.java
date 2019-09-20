package com.example.wiki_fandom.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.wiki_fandom.R;
import com.example.wiki_fandom.pojo.Wiki;

/*
 * Все права на интеллектуальную собственность принадлежат Ткачуку Дмитрию Викторовичу
 * Email: thunderbird251991@gmail.com
 * Моб.номер +375(44)465-83-83
 * @author Dmitry Tkachuk
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private Wiki mwiki;

    public SectionsPagerAdapter(Context context, FragmentManager fm, Wiki wiki) {
        super(fm);
        mContext = context;
        mwiki = wiki;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
       switch (position){
           case 0 : fragment = WikiListFragment.newInstance(getmWiki());
           break;
           case 1 : fragment = WikiImagesFragment.newInstance(getmWiki());
           break;
       }
        return  fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }

    public Wiki getmWiki(){
        return mwiki;
    }
}