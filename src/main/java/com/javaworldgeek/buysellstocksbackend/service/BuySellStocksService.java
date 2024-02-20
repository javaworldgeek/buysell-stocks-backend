package com.javaworldgeek.buysellstocksbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaworldgeek.buysellstocksbackend.entity.Product;
import com.javaworldgeek.buysellstocksbackend.repository.BuySellStocksRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BuySellStocksService {
	
	private final BuySellStocksRepository 
		buySellStocksRepo;
	
	public List<Product> findAllProductsServ(){
		return buySellStocksRepo.findAll();
	}
	
	public Product addProductServ(Product product) {
		return buySellStocksRepo.insert(product);
	}
	
	public void deleteAllProductsServ() {
		buySellStocksRepo.deleteAll();
	}
	
}
