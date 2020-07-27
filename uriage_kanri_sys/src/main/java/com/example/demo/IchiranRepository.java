package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IchiranRepository extends JpaRepository<IchiranEntity, Long>,JpaSpecificationExecutor<IchiranEntity> {
@Query(value = "SELECT u.id,k.kokyaku_mei as kokyaku ,u.juchu_day,u.s_no,u.kenmei,u.suryo,u.shitei_day,u.nounyu_day,u.seikyu_day,u.mitsumori_kin,u.juchu_kin,s.status_mei as status ,u.delete_flg " +
		" FROM t_uriage u ,m_kokyaku k ,m_status s " +
		" WHERE u.kokyaku = k.kokyaku_id " +
		" and u.kokyaku = s.kokyaku_id " +
		" and u.status = s.status_id" +
		" and u.delete_flg = 0 ", nativeQuery = true)
	Page<IchiranEntity> findActiveAll(Pageable pageable);
}
