package etr.android.flavordi.data.storages;

public class RepositoryStorageBuilder {
    private int maxSize;

    public RepositoryStorageBuilder setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    public RepositoryStorage build() {
        return new InMemoryRepositoryStorage(maxSize);
    }
}
