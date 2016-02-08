package etr.android.flavordi.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forcelain.android.flavordi.R;
import etr.android.flavordi.models.Repository;

import java.util.List;

class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultViewHolder> {

    private List<Repository> data;

    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_results_item, parent, false);
        return new SearchResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchResultViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public void setData(List<Repository> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
