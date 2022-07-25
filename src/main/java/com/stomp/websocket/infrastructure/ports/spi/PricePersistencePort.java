package com.stomp.websocket.infrastructure.ports.spi;

import java.util.List;

import com.stomp.websocket.domain.data.PriceDto;

public interface PricePersistencePort {
	
	List<PriceDto> getPrice();
	
	PriceDto getPriceById(Long priceId);
	
	PriceDto addPrice(PriceDto priceDto);
	
	PriceDto updatePrice(PriceDto priceDto);
	
	void deletePrice(Long price);
	
}
