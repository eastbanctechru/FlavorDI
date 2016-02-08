package etr.android.flavordi.data.services;

import etr.android.flavordi.data.services.entity.ApiRepositorySearchEntity;
import etr.android.flavordi.data.services.entity.RepositoryEntity;
import etr.android.flavordi.data.services.entity.RepositoryMapper;
import etr.android.flavordi.models.Repository;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class AppServiceImpl implements AppService {

    private final RetroGithubService service;

    public AppServiceImpl() {
        service = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetroGithubService.class);
    }

    @Override
    public List<Repository> searchRepositories(String query) {
        Call<ApiRepositorySearchEntity> call = service.searchRepositories(query);
        try {
            Response<ApiRepositorySearchEntity> response = call.execute();
            if (response.isSuccess()) {
                ApiRepositorySearchEntity body = response.body();
                List<Repository> results = new ArrayList<>();
                RepositoryMapper mapper = new RepositoryMapper();
                for (RepositoryEntity entity : body.items) {
                    results.add(mapper.map(entity));
                }
                return results;
            } else {
                throw new ApiException(response.message());
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
