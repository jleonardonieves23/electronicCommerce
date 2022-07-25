package com.stomp.websocket.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stomp.websocket.domain.data.PriceDto;
import com.stomp.websocket.domain.puerto.spi.PricePersistencePort;
import com.stomp.websocket.infrastructure.entity.Price;
import com.stomp.websocket.infrastructure.mappers.PriceMapper;
import com.stomp.websocket.infrastructure.repository.PriceRepository;

@Service
public class PriceAdapters implements PricePersistencePort {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public List<PriceDto> getPrice() {
		List<Price> priceList = priceRepository.findAll();
		
		return PriceMapper.INSTANCE.priceListToPriceDto(priceList);
	}

	@Override
	public PriceDto getPriceById(Long priceId) {
		Optional<Price> price = priceRepository.findById(priceId);
		
		if (price.isPresent()) {
			return PriceMapper.INSTANCE.priceToPriceDto(price.get());
		}
		
		
		return null;
	}

	@Override
	public PriceDto addPrice(PriceDto priceDto) {
		Price price = PriceMapper.INSTANCE.priceDtoToPrice(priceDto);

		Price priceSaved = priceRepository.save(price);

		return PriceMapper.INSTANCE.priceToPriceDto(priceSaved);
	}

	@Override
	public PriceDto updatePrice(PriceDto priceDto) {
		return addPrice(priceDto);
	}

	@Override
	public void deletePrice(Long price) {
		priceRepository.deleteById(price);
	}

}
