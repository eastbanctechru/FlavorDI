package etr.android.flavordi;

import android.app.Application;

import etr.android.flavordi.data.services.AppService;
import etr.android.flavordi.data.services.AppServiceImpl;
import etr.android.flavordi.data.storages.RepositoryStorage;
import etr.android.flavordi.data.storages.RepositoryStorageBuilder;

public class App extends Application {

    private AppService appService;
    private RepositoryStorage repositoryStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        appService = new AppServiceImpl();
        repositoryStorage = new RepositoryStorageBuilder()
                .setMaxSize(5)
                .build();
    }

    public AppService getAppService() {
        return appService;
    }

    public RepositoryStorage getRepositoryStorage() {
        return repositoryStorage;
    }
}
