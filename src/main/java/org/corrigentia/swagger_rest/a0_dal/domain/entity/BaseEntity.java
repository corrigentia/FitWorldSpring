package org.corrigentia.swagger_rest.a0_dal.domain.entity;

import lombok.Getter;

/**
 * @author Person
 * @since 2023/08/11
 */
public abstract class BaseEntity<T, R> {
    @Getter
    private final T id;

    private final R repo;

    public BaseEntity(T id, R repo) {
        this.id = id;
        this.repo = repo;
    }

    protected R getRepo() {
        return repo;
    }
}
