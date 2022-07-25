package com.stomp.websocket.application.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.stomp.websocket.domain.puerto.api.PriceServicePort;
import com.stomp.websocket.domain.puerto.spi.PricePersistencePort;
import com.stomp.websocket.domain.service.PriceServiceImpl;
import com.stomp.websocket.infrastructure.adapters.PriceAdapters;

@Configurable
public class PriceConfig {
	
	@Bean 
	public PricePersistencePort pricePErsisten() {
		return new PriceAdapters();
	}
	
	@Bean
	public PriceServicePort priceService() {
		return new PriceServiceImpl(pricePErsisten());
	}

}
