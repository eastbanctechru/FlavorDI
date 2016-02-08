package etr.android.flavordi.data.services;

import etr.android.flavordi.data.services.entity.ApiRepositorySearchEntity;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RetroGithubService {
    @GET("search/repositories")
    Call<ApiRepositorySearchEntity> searchRepositories(@Query("q") String query);
}
