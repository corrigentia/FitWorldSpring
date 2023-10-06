package org.corrigentia.fitrest.adal.repo;

import java.util.List;

import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MartialArtRepository extends JpaRepository<MartialArtEntity, Long>, JpaSpecificationExecutor<MartialArtEntity> {
    Page<MartialArtEntity> findByEnabledTrue(Pageable pageable);

    List<MartialArtEntity> findByNameContainsIgnoreCase(String name);

    List<MartialArtEntity> findByNameContains(String name);

    List<MartialArtEntity> findByNameStartsWithIgnoreCase(String name);

    List<MartialArtEntity> findByNameStartsWith(String name);

    List<MartialArtEntity> findByNameEndsWithIgnoreCase(String name);

    List<MartialArtEntity> findByNameEndsWith(String name);

    List<MartialArtEntity> getByNameIgnoreCase(String name);

    List<MartialArtEntity> getByName(String name);
}
