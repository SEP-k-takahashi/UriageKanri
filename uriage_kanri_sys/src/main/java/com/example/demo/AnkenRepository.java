package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnkenRepository extends JpaRepository<AnkenEntity, Long>,JpaSpecificationExecutor<AnkenEntity> {
@Query(value = "SELECT * FROM t_uriage  WHERE delete_flg = 0", nativeQuery = true)
	Page<AnkenEntity> findActiveAll(Pageable pageable);
}
