package com.stomp.websocket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stomp.websocket.domain.data.PriceDto;
import com.stomp.websocket.domain.puerto.api.PriceServicePort;
import com.stomp.websocket.domain.puerto.spi.PricePersistencePort;

@Service
public class PriceServiceImpl implements PriceServicePort {
	
	@Autowired
	private PricePersistencePort persistencePort;	

	public PriceServiceImpl(PricePersistencePort persistencePort) { 
		this.persistencePort = persistencePort;
	}

	@Override
	public List<PriceDto> getPrice() {
		return persistencePort.getPrice();
	}

	@Override
	public PriceDto getPriceById(Long price) {
		return persistencePort.getPriceById(price);
	}

	@Override
	public PriceDto addPrice(PriceDto price) {
		return persistencePort.addPrice(price);
	}

	@Override
	public PriceDto updatePrice(PriceDto price) {
		return persistencePort.updatePrice(price);
	}

	@Override
	public void deletePrice(Long price) {
		persistencePort.deletePrice(price);
	}

}
