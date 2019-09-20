package com.example.wiki_fandom.ui.main;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class WikiImagesFragment extends Fragment {

    private static final String WIKI_ARG = "wikiInstance";
    private Wiki mwiki;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    public static WikiImagesFragment newInstance(Wiki wiki) {
        WikiImagesFragment fragment = new WikiImagesFragment();
        Bundle args = new Bundle();
        args.putSerializable(WIKI_ARG, wiki);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mwiki = (Wiki) getArguments().getSerializable(WIKI_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ButterKnife.bind(this,view);
        WikiRecycleViewImage wikiRecycleViewImage = new WikiRecycleViewImage(mwiki);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerView.setAdapter(wikiRecycleViewImage);
        return view;
    }

}
