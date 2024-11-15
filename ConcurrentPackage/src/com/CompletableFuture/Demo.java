package com.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Sum sum=new Sum();
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()->{
			int sum2 = sum.sum(3, 6);
			return sum2;
		});
		
		Divide divide=new Divide();
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()->{
			int sum2 = divide.divide(3, 6);
			return sum2;
		});
		
		Multiplication multiplication=new Multiplication();
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(()->{
			int sum2 = multiplication.multi(3, 6);
			return sum2;
		});
		
		Integer integer1 = future1.get();
		Integer integer2 = future2.get();
		Integer integer3 = future3.get();
		
		int result=integer1+integer2+integer3;
		System.out.println("All result "+result);
	}
}
