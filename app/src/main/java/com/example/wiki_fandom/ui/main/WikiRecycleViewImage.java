package com.example.wiki_fandom.ui.main;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.wiki_fandom.R;
import com.example.wiki_fandom.pojo.Wiki;
import com.squareup.picasso.Picasso;
import java.util.List;

/*
 * Все права на интеллектуальную собственность принадлежат Ткачуку Дмитрию Викторовичу
 * Email: thunderbird251991@gmail.com
 * Моб.номер +375(44)465-83-83
 * @author Dmitry Tkachuk
 */
public class WikiRecycleViewImage extends RecyclerView.Adapter<WikiRecycleViewImage.ViewHolder> {

    private final List<Wiki> mwiki;

    public WikiRecycleViewImage(Wiki items) {
        this.mwiki = items.getMitems();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Picasso.get().load(mwiki.get(position).getMimage()).resize(700,150).fetch();
                Picasso.get().load(mwiki.get(position).getMimage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mwiki.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imgview);
        }
    }
}
