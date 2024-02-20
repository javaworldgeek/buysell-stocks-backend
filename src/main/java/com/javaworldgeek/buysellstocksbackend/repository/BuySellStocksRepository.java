package com.javaworldgeek.buysellstocksbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaworldgeek.buysellstocksbackend.entity.Product;

public interface BuySellStocksRepository extends
	MongoRepository<Product, String>{
	
	
}
