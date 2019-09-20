package com.example.wiki_fandom.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wiki_fandom.R;
import com.example.wiki_fandom.pojo.Wiki;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * Все права на интеллектуальную собственность принадлежат Ткачуку Дмитрию Викторовичу
 * Email: thunderbird251991@gmail.com
 * Моб.номер +375(44)465-83-83
 * @author Dmitry Tkachuk
 */
public class WikiRecycleViewList extends RecyclerView.Adapter<WikiRecycleViewList.ViewHolder> {

    private List<Wiki> mwiki;

    public WikiRecycleViewList(Wiki wiki){
        this.mwiki = wiki.getMitems();
    }

    @NonNull
    @Override
    public WikiRecycleViewList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                             inflate(R.layout.wikis_recycleview_layout, parent, false);
        WikiRecycleViewList.ViewHolder viewHolder = new  WikiRecycleViewList.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textname.setText(mwiki.get(position).getMname());
        holder.texthub.setText(mwiki.get(position).getMhub());
        holder.texttopic.setText(mwiki.get(position).getmtopic());
        holder.textartilescnt.setText(mwiki.get(position).getmstats().getMarticles());
    }

    @Override
    public int getItemCount() {
        return mwiki.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtname)
        TextView textname;

        @BindView(R.id.txthub)
        TextView texthub;

        @BindView(R.id.txttopic)
        TextView texttopic;

        @BindView(R.id.txtarticlescnt)
        TextView textartilescnt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
