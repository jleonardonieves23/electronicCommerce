package electronicCommerceTest.controllers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.stomp.websocket.application.controller.PriceController;
import com.stomp.websocket.domain.data.PriceDto;
import com.stomp.websocket.domain.puerto.api.PriceServicePort;

public class PriceControllerTest {
	
	Long PRICEID = 1L;
	
	String DELETE = "Precio eliminado";
	
	PriceDto PRICEDTO = new PriceDto();

	@Mock
	PriceServicePort priceServicePort;

	@InjectMocks
	PriceController priceController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		PRICEDTO.setAmout(35.50);
		PRICEDTO.setBrandId(1L);
		PRICEDTO.setCurr("USD");
		PRICEDTO.setEndDate(castStringToDAte("2020-12-31 23:59:59"));
		PRICEDTO.setPriceList(0);
		PRICEDTO.setPriority(0);
		PRICEDTO.setProductId("35455");
		PRICEDTO.setStarteDate(castStringToDAte("2020-06-14 00:00:00"));
		
		Mockito.when(priceServicePort.getPriceById(PRICEID)).thenReturn(PRICEDTO);
		
		Mockito.when(priceServicePort.addPrice(PRICEDTO)).thenReturn(PRICEDTO);
		
		Mockito.when(priceServicePort.updatePrice(PRICEDTO)).thenReturn(PRICEDTO);
		
	}
	
	@Test
	public void getPriceByIdTEst() {
		ResponseEntity<PriceDto> responseCtrl = priceController.getPriceById(PRICEID);
		assertEquals(responseCtrl.getBody(), PRICEDTO); 
	}

	
	@Test
	public void DiletePriceByIdTEst() {
		ResponseEntity<String> delete = priceController.deletePrice(PRICEID);
		assertEquals(delete.getBody(), DELETE);
	}
	
	@Test
	public void savedPriceTEst() {
		ResponseEntity<PriceDto> delete = priceController.addPrice(PRICEDTO);
		assertEquals(delete.getBody(), PRICEDTO);
	}
	
	@Test
	public void updatePriceTEst() {
		ResponseEntity<PriceDto> delete = priceController.updatePrice(PRICEID, PRICEDTO);
		assertEquals(delete.getBody(), PRICEDTO);
	}
	
	private Date castStringToDAte(String dateInString) {		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			return  formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
