package etr.android.flavordi.view;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import etr.android.flavordi.App;
import com.forcelain.android.flavordi.R;
import etr.android.flavordi.data.services.ApiException;
import etr.android.flavordi.data.services.AppService;
import etr.android.flavordi.data.storages.RepositoryStorage;
import etr.android.flavordi.models.Repository;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.actionSearchView) Button actionSearchView;
    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    @Bind(R.id.searchQueryView) EditText searchQueryView;
    @Bind(R.id.progressView) View progressView;
    private SearchResultsAdapter adapter;
    private AppService appService;
    private SearchTask searchTask;
    private RepositoryStorage repositoryStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        appService = ((App) getApplication()).getAppService();
        repositoryStorage = ((App) getApplication()).getRepositoryStorage();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SearchResultsAdapter();
        recyclerView.setAdapter(adapter);
        searchQueryView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                querySearch(searchQueryView.getText().toString());
                return true;
            }
        });
    }

    @OnClick(R.id.actionSearchView)
    void onActionSearchClicked() {
        querySearch(searchQueryView.getText().toString());
    }

    private void querySearch(String query) {
        if (TextUtils.isEmpty(query)) {
            return;
        }
        if (searchTask != null) {
            return;
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchQueryView.getWindowToken(), 0);

        searchTask = new SearchTask();
        searchTask.execute(query);
        showProgress(true);
    }

    private void showData(List<Repository> repositories) {
        searchTask = null;
        adapter.setData(repositories);
    }

    private void showProgress(boolean inProgress) {
        progressView.setVisibility(inProgress ? View.VISIBLE : View.GONE);
        actionSearchView.setEnabled(!inProgress);
    }

    private void showError(@Nullable ApiException exception) {
        searchTask = null;
        new AlertDialog.Builder(this)
                .setMessage(exception != null ? exception.getMessage() : getString(R.string.unknown_error))
                .setTitle(R.string.error_title)
                .show();
    }

    private class SearchTask extends AsyncTask<String, Void, SearchTaskResult> {

        @Override
        protected SearchTaskResult doInBackground(String... params) {
            String q = params[0];
            SearchTaskResult result = new SearchTaskResult();
            try {
                result.repositories = appService.searchRepositories(q);
                repositoryStorage.saveRepositories(q, result.repositories);
            } catch (ApiException e) {
                result.exception = e;
                //try to show some cached results
                result.repositories = repositoryStorage.getRepositories(q);
            }

            return result;
        }

        @Override
        protected void onPostExecute(SearchTaskResult result) {
            if (result.exception != null) {
                showError(result.exception);
            }
            showData(result.repositories);
            showProgress(false);
        }
    }

    private class SearchTaskResult {
        List<Repository> repositories;
        ApiException exception;
    }
}
