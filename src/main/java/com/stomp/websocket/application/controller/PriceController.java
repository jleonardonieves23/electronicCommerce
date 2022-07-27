package com.stomp.websocket.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stomp.websocket.domain.data.PriceDto;
import com.stomp.websocket.domain.puerto.api.PriceServicePort;

@CrossOrigin 
@RestController
@RequestMapping("/price")
public class PriceController { 
	
	@Autowired
	private PriceServicePort priceServicePort;

	@PostMapping("/add")
	public ResponseEntity<PriceDto> addPrice(@RequestBody PriceDto priceDto) {		
		return new ResponseEntity<>(priceServicePort.addPrice(priceDto), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<PriceDto>  updatePrice(@PathVariable Long id, @RequestBody PriceDto priceDto) {
		return new ResponseEntity<>(priceServicePort.updatePrice(priceDto), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PriceDto> getPriceById(@PathVariable Long id) {		
		return new ResponseEntity<>(priceServicePort.getPriceById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PriceDto>> getAllPrices() {
		return new ResponseEntity<>(priceServicePort.getPrice(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePrice(@PathVariable Long id) {
		priceServicePort.deletePrice(id);
		return new ResponseEntity<>("Precio eliminado", HttpStatus.OK);
	}

}
