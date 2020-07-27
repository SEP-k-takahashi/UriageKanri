package com.example.demo;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class IchiranEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//ID
	private long id;
	//顧客名
    private String kokyaku;
	//受注日
    private Date juchu_day;
	//S番号
    private String s_no;
	//件名
    private String kenmei;
	//数量
    private long suryo;
	//指定日
    private Date shitei_day;
	//納入日
    private Date nounyu_day;
	//請求日
    private Date seikyu_day;
	//見積金額
	private long mitsumori_kin;
	//受注金額
	private long juchu_kin;
	//ステータス
	private String status;
	//削除フラグ
	private long delete_flg;
}
