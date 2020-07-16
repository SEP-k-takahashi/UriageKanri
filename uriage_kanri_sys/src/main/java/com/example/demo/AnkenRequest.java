package com.example.demo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
public class AnkenRequest  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//ID
	@Column(name="id")
	private long id;
	//顧客名
	@Column(name="kokyaku")
    private String kokyaku;
	//受注日
	@Column(name="juchu_day")
    private Date juchu_day;
	//S番号
	@Column(name="s_no")
    private String s_no;
	//件名
	@Column(name="kenmei")
    private String kenmei;
	//数量
	@Column(name="suryo")
    private long suryo;
	//指定日
	@Column(name="shitei_day")
    private Date shitei_day;
	//納入日
	@Column(name="nounyu_day")
    private Date nounyu_day;
	//請求日
	@Column(name="seikyu_day")
    private Date seikyu_day;
	//見積金額
	@Column(name="mitsumori_kin")
	private long mitsumori_kin;
	//受注金額
	@Column(name="juchu_kin")
	private long juchu_kin;
	//ステータス
	@Column(name="status")
	private long status;
	//削除フラグ
	@Column(name="delete_flg")
	private long delete_flg;

}
