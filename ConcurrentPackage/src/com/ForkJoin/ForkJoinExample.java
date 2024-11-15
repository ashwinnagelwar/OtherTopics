package com.ForkJoin;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample extends RecursiveTask<Integer>{

	private int[] arr;
	private int start;
	private int end;
	
	
	public ForkJoinExample(int[] arr, int start, int end) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
	}


	@Override
	protected Integer compute() {
		 if (end - start <= 10) 
		 {
	            int sum = 0;
	            for (int i = start; i < end; i++)
	            {
	            	sum += arr[i];
	            }
	            return sum;
	        }else 
	        {
		int mid=start+end/2;
		
		ForkJoinExample task1 = new ForkJoinExample(arr,start,mid);
		ForkJoinExample task2 = new ForkJoinExample(arr,mid,end);
		
		task1.fork();
		task2.fork();
		
		Integer join1 = task1.join();
		Integer join2 = task1.join();
		
		return join1+join2;
		}
	}
	
	public static void main(String[] args) {
		int [] num=IntStream.range(1, 100).toArray();
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		ForkJoinExample task = new ForkJoinExample(num,0,num.length);
		
		Integer result = forkJoinPool.invoke(task);
		System.out.println("Total sum of result of Fork and Join "+result);
	}
    
}
