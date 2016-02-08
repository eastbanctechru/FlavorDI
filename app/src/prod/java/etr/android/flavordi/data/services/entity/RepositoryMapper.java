package etr.android.flavordi.data.services.entity;

import etr.android.flavordi.models.Repository;

public class RepositoryMapper {
    public Repository map(RepositoryEntity repositoryEntity){
        return new Repository(
                repositoryEntity.description,
                repositoryEntity.name,
                repositoryEntity.htmlUrl
            );
    }
}
