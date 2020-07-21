package com.example.demo;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Entity
@Table(name="t_uriage")
@Data
public class AnkenEntity {
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
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="shitei_day")
    private Date shitei_day;
	//納入日
	@Column(name="nounyu_day")
    private Date nounyu_day;
	//請求日
	@Column(name="seikyu_day")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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

    @ManyToOne
    @JoinColumn(name="kokyaku",insertable = false, updatable = false)
    private KokyakuEntity kokyakuEntity;

    public KokyakuEntity getkokyakuEntiry() {
        return kokyakuEntity;
    }

    public void setkokyakuEntiry(KokyakuEntity kokyakuEntity) {
        this.kokyakuEntity = kokyakuEntity;
    }
/*
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="kokyaku", referencedColumnName="kokyaku_id"),
        @JoinColumn(name="status", referencedColumnName="status_id")
    })
    private StatusEntity stutusEntity;
    public StatusEntity getstatusEntity() {
        return stutusEntity;
    }

    public void setstatusEntiy(StatusEntity stutusEntity) {
        this.stutusEntity = stutusEntity;
    }
*/
}
