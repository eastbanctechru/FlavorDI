package etr.android.flavordi.data.storages;

import etr.android.flavordi.models.Repository;

import java.util.List;

public class MockRepositoryStorage implements RepositoryStorage {

    @Override
    public void saveRepositories(String q, List<Repository> repositoryList) {}

    @Override
    public List<Repository> getRepositories(String q) {
        return null;
    }
}
