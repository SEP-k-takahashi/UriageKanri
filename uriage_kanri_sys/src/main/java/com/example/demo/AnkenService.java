package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class AnkenService {
	@Autowired
	AnkenRepository ankenReposirtory;
	@Autowired
	IchiranRepository ichiranReposirtory;
	/**
	   * 案件情報 全検索
	   * @return 検索結果
	   */
	/*
	public Page<AnkenEntity> searchAnkenAll(Pageable pageable) {
		  Page<AnkenEntity> page = ankenReposirtory.findActiveAll(pageable);
	    return page;
	  }
	  */
	public Page<IchiranEntity> searchAnkenAll(Pageable pageable) {
		  Page<IchiranEntity> page = ichiranReposirtory.findActiveAll(pageable);
	    return page;
	  }
	/**
	   * 登録情報 登録
	   * @return 検索結果
	   */
	public void create(AnkenRequest ankenrequest) {
		AnkenEntity ankenentity = new AnkenEntity();
		ankenentity.setKokyaku(ankenrequest.getKokyaku());
		ankenentity.setJuchu_day(ankenrequest.getJuchu_day());
		ankenentity.setS_no(ankenrequest.getS_no());
		ankenentity.setKenmei(ankenrequest.getKenmei());
		ankenentity.setSuryo(ankenrequest.getSuryo());
		ankenentity.setShitei_day(ankenrequest.getShitei_day());
		ankenentity.setNounyu_day(ankenrequest.getNounyu_day());
		ankenentity.setSeikyu_day(ankenrequest.getSeikyu_day());
		ankenentity.setMitsumori_kin(ankenrequest.getMitsumori_kin());
		ankenentity.setJuchu_kin(ankenrequest.getJuchu_kin());
		ankenentity.setStatus(ankenrequest.getStatus());
		ankenentity.setDelete_flg(0);

		ankenReposirtory.save(ankenentity);

	  }
}
