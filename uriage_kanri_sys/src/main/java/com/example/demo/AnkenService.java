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
	/**
	   * 案件情報 全検索
	   * @return 検索結果
	   */
	public Page<AnkenEntity> searchAnkenAll(Pageable pageable) {
		  Page<AnkenEntity> page = ankenReposirtory.findActiveAll(pageable);
	    return page;
	  }
}
