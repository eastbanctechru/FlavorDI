package etr.android.flavordi.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.forcelain.android.flavordi.R;
import etr.android.flavordi.models.Repository;

import butterknife.Bind;
import butterknife.ButterKnife;

class SearchResultViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.repoName) TextView nameView;
    @Bind(R.id.repoDesc) TextView descriptionView;
    @Bind(R.id.repoUrl) TextView urlView;

    public SearchResultViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Repository repository) {
        nameView.setText(repository.getName());
        descriptionView.setText(repository.getDescription());
        urlView.setText(repository.getHtmlUrl());
    }
}
