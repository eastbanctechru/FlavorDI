package etr.android.flavordi.data.storages;

public class RepositoryStorageBuilder {

    public RepositoryStorageBuilder setMaxSize(int maxSize) {
        return this;
    }

    public RepositoryStorage build() {
        return new MockRepositoryStorage();
    }
}
