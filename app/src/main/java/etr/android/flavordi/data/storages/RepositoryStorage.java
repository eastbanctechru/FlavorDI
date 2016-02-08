package etr.android.flavordi.data.storages;

import etr.android.flavordi.models.Repository;

import java.util.List;

public interface RepositoryStorage {
    void saveRepositories(String query, List<Repository> repositoryList);
    List<Repository> getRepositories(String query);
}
