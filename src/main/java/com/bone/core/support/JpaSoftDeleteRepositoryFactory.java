package com.bone.core.support;

import com.bone.core.SoftDelete;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

public class JpaSoftDeleteRepositoryFactory extends JpaRepositoryFactory {
    /**
     * Creates a new {@link JpaRepositoryFactory}.
     *
     * @param entityManager must not be {@literal null}
     */
    public JpaSoftDeleteRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        if(metadata.getRepositoryInterface().isAnnotationPresent(SoftDelete.class)){
            return JpaSoftDeleteRepository.class;
        }
        return super.getRepositoryBaseClass(metadata);
    }
}
