package com.example.demo;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="m_kokyaku")
@Data

public class KokyakuEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//ID
	@Column(name="kokyaku_id")
	private long kokyaku_id;
	//顧客名
	@Column(name="kokyaku_mei")
    private String kokyaku_mei;

    @OneToMany(mappedBy="kokyaku", cascade=CascadeType.ALL)
    private List<AnkenEntity> ankenEntity;

    public List<AnkenEntity> getAnkenEntity() {
        return ankenEntity;
    }

    public void setAnkenEntity(List<AnkenEntity> ankenEntity) {
        this.ankenEntity = ankenEntity;
    }
}
