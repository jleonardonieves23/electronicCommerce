package com.stomp.websocket.infrastructure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private Long brandId;

	@Column(name = "starte_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date starteDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "price_list")
	private int priceList;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "priority")
	private int priority;

	@Column(name = "price")
	private double price;

	@Column(name = "curr")
	private String curr;

}
