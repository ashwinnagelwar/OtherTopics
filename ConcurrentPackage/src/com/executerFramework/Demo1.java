package com.executerFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo1 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<3;i++) 
		{
			executorService.submit(()->
				{
					System.out.println("Executing task 1 with thread: "+Thread.currentThread().getName());
						try 
							{
				
								Thread.sleep(1000);
				
							}catch(InterruptedException exception)
							{
								Thread.currentThread().interrupt();
							}
			
				});
		}
		executorService.shutdown();
		
	}
}
