package com.stomp.websocket.domain.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto { 

    @JsonProperty("brandId") 
	private Long brandId; 

    @JsonProperty("starteDate") 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date starteDate; 

    @JsonProperty("endDate") 
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate; 

    @JsonProperty("priceList") 
	private int priceList; 

    @JsonProperty("productId") 
	private String productId; 
    
    @JsonProperty("priority") 
	private int priority; 

    @JsonProperty("price") 
	private double price; 

    @JsonProperty("curr") 
	private String curr;	

}
