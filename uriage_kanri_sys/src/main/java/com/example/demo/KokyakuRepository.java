package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface KokyakuRepository extends JpaRepository<KokyakuEntity, Long>,JpaSpecificationExecutor<KokyakuEntity> {
}
