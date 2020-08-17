package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long>,JpaSpecificationExecutor<StatusEntity> {
	//@Query(value = "SELECT * FROM jyusyoroku AS j WHERE j.address LIKE %:SeachName% AND j.delete_flg = 0", nativeQuery = true) // SQL
	@Query(value = "SELECT * FROM m_status WHERE kokyaku_id = :Kokyaku ORDER BY status_id", nativeQuery = true) // SQL

	public List<StatusEntity> findStatus(@Param("Kokyaku") String Kokyaku);

	@Query(value = "SELECT * FROM m_status  ORDER BY status_id", nativeQuery = true) // SQL

	public List<StatusEntity> findStatusAll();

}

