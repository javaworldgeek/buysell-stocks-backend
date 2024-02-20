package com.javaworldgeek.buysellstocksbackend.concurrency;

import java.math.BigDecimal;

import com.javaworldgeek.buysellstocksbackend.entity.Product;
import com.javaworldgeek.buysellstocksbackend.entity.StockStatus;
import com.javaworldgeek.buysellstocksbackend.entity.TransactionType;
import com.javaworldgeek.buysellstocksbackend.service.BuySellStocksService;
import com.javaworldgeek.buysellstocksbackend.util.BuySellStocksUtil;


public class ProductBulkExecutorTask implements Runnable {
	
	private BuySellStocksService buySellStockServ;
	private int price;
	
	public ProductBulkExecutorTask(BuySellStocksService buySellStockServ, int price){
		this.buySellStockServ = buySellStockServ;
		this.price = price;
	}
	
	@Override
	public void run() {
		
		Product prod = new Product(
				"INFY", 
				BuySellStocksUtil.genRandomProdQuantity(), 
				new BigDecimal(price), 
				BuySellStocksUtil.getRandomStockStatus(), 
				StockStatus.OPEN);
		buySellStockServ.addProductServ(prod);
		
	}

}
