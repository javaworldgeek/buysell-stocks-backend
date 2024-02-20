package com.javaworldgeek.buysellstocksbackend.util;

import java.util.Random;

import com.javaworldgeek.buysellstocksbackend.entity.StockStatus;
import com.javaworldgeek.buysellstocksbackend.entity.TransactionType;

public class BuySellStocksUtil {

	public static int genRandomProdQuantity() {
		int result = new Random().nextInt(20) * 50;
		return result <=0 ? genRandomProdQuantity() : result;	
	}//end of genRandomProdQuantity
	
	public static int genRandomProdPrice() {
		int result = new Random().nextInt(11) * 100 + new Random().nextInt(11) * 50;
		return result <= 0 ? genRandomProdPrice() : result;	
	}//end of genRandomProdQuantity
	
	public static TransactionType getRandomStockStatus() {
		return TransactionType.values()[new Random().nextInt(StockStatus.values().length-1)];
	}//end of getRandomStockStatus
	
	public static void main(String[] args) {
		System.out.println(getRandomStockStatus());	
	}
	
}
