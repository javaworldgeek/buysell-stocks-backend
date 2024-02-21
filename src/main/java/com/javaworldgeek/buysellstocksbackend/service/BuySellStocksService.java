package com.javaworldgeek.buysellstocksbackend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.javaworldgeek.buysellstocksbackend.entity.Product;
import com.javaworldgeek.buysellstocksbackend.entity.StockStatus;
import com.javaworldgeek.buysellstocksbackend.entity.TransactionType;
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
	
	public void doBuySellServ() {
		
		List<Product> products = findAllProductsServ();
		
		List<Product> buyProducts = 
				products.stream()
				.filter(p -> p.getTransType().equals(TransactionType.BUY))
				.filter(p -> !p.getStockSts().equals(StockStatus.CLOSED))
				.collect(Collectors.toList());
		
		List<Product> sellProducts = 
				products.stream()
				.filter(p -> p.getTransType().equals(TransactionType.SELL))
				.filter(p -> !p.getStockSts().equals(StockStatus.CLOSED))
				.collect(Collectors.toList());
		
		for(Product buy : buyProducts) {
			int buyQuan  = buy.getQuantity();
			
			for(Product sell : sellProducts) {
				
				if(buy.getPrice().equals(sell.getPrice())) {
					
					if(!buy.getStockSts().equals(StockStatus.CLOSED) && 
					   !sell.getStockSts().equals(StockStatus.CLOSED)) {
						
						int sellQuan = sell.getQuantity();
						
						if(buyQuan < sellQuan) {
							
							sellQuan -= buyQuan;
							buy.setStockSts(StockStatus.CLOSED);
							sell.setQuantity(sellQuan);
							sell.setStockSts(StockStatus.PARTIAL);
							break;
							
						}else if(buyQuan > sellQuan) {
							
							buyQuan -= sellQuan;
							buy.setStockSts(StockStatus.PARTIAL);
							sell.setQuantity(0);
							sell.setStockSts(StockStatus.CLOSED);
							
						}else if(buyQuan == sellQuan) {
							
							buy.setStockSts(StockStatus.CLOSED);
							sell.setQuantity(0);
							sell.setStockSts(StockStatus.CLOSED);
							break;
							
						}//end of if
						
					}//end of if

				}//end of if
				
			}//end of for
			
		}//end of for
		
		buyProducts.forEach(buySellStocksRepo::save);
		sellProducts.forEach(buySellStocksRepo::save);
		
	}//end of doBuySellServ
	
}
