package com.stomp.websocket.infrastructure.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.stomp.websocket.domain.data.PriceDto;
import com.stomp.websocket.infrastructure.entity.Price;

@Mapper
public interface PriceMapper {
	
	PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
	
	PriceDto priceToPriceDto(Price price);
	
	Price priceDtoToPrice(PriceDto priceDto);
	
	List<PriceDto> priceListToPriceDto(List<Price> prices);
	
	List<Price> priceDtoListToPriceList(List<PriceDto> prices);
}
