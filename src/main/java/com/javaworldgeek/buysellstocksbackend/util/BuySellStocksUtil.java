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
		int[] intArr = {950, 800, 1200, 1350, 600, 350};
		return intArr[new Random().nextInt(intArr.length)];
	}//end of genRandomProdQuantity
	
	public static TransactionType getRandomStockStatus() {
		return TransactionType.values()[new Random().nextInt(StockStatus.values().length-1)];
	}//end of getRandomStockStatus
	
}
