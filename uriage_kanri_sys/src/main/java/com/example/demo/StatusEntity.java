package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="m_status")
@Data
@IdClass(StatusPK.class)
public class StatusEntity {
	@Id
	//ID
	@Column(name="kokyaku_id")
	private long kokyaku_id;
	//顧客名
	@Id
	@Column(name="status_id")
    private String status_id;

	//顧客名
	@Column(name="status_mei")
    private String status_mei;
/*
    @OneToMany(mappedBy="stutus",cascade=CascadeType.ALL)
    @JoinColumns({
        @JoinColumn(name="kokyaku_id", referencedColumnName="kokyaku"),
        @JoinColumn(name="status_id", referencedColumnName="status")
    })
    private List<AnkenEntity> ankenEntity;

    public List<AnkenEntity> getAnkenEntity() {
        return ankenEntity;
    }

    public void setAnkenEntity(List<AnkenEntity> ankenEntity) {
        this.ankenEntity = ankenEntity;
    }
    */
}
