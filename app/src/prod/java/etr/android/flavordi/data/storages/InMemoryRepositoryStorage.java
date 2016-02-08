package etr.android.flavordi.data.storages;

import android.support.v4.util.LruCache;

import etr.android.flavordi.models.Repository;

import java.util.List;

public class InMemoryRepositoryStorage implements RepositoryStorage {

    private LruCache<String, List<Repository>> cache;

    public InMemoryRepositoryStorage(int maxSize) {
        cache = new LruCache<>(maxSize);
    }

    @Override
    public void saveRepositories(String key, List<Repository> repositoryList) {
        cache.put(key, repositoryList);
    }

    @Override
    public List<Repository> getRepositories(String key) {
        return cache.get(key);
    }
}
