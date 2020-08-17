package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class StatusPK implements Serializable {
	  @Column(name = "kokyaku_id")
	  private String kokyaku_id;

	  @Column(name = "status_id")
	  private String status_id;

	  @Column(name = "status_mei")
	  private String status_mei;
}