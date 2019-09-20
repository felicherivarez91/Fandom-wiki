package com.example.wiki_fandom.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wiki_fandom.R;
import com.example.wiki_fandom.pojo.Wiki;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * Все права на интеллектуальную собственность принадлежат Ткачуку Дмитрию Викторовичу
 * Email: thunderbird251991@gmail.com
 * Моб.номер +375(44)465-83-83
 * @author Dmitry Tkachuk
 */
public class WikiListFragment extends Fragment {

    @BindView(R.id.recycleview)
    RecyclerView recyclerView;

    private WikiRecycleViewList wikiRecycleViewlist;
    private static final String WIKI_KEY = "wikiInstanse";
    private Wiki wiki;

    //Put the a wiki instanse in bundle and retrieve it in fragment
    public static WikiListFragment newInstance(Wiki wiki) {
        WikiListFragment fragment = new WikiListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(WIKI_KEY, wiki);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            wiki = (Wiki) getArguments().getSerializable(WIKI_KEY);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,root);
        wikiRecycleViewlist = new WikiRecycleViewList(wiki);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(wikiRecycleViewlist);
        return root;
    }
}