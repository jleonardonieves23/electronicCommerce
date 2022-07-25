package com.stomp.websocket.domain.puerto.spi;

import java.util.List;

import com.stomp.websocket.domain.data.PriceDto;

public interface PricePersistencePort {
	
	List<PriceDto> getPrice();
	
	PriceDto getPriceById(Long price);
	
	PriceDto addPrice(PriceDto price);
	
	PriceDto updatePrice(PriceDto price);
	
	void deletePrice(Long price);
}
