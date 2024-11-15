package com.LockNSynchronize;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo2 {

//	2. ReentrantReadWriteLock
//	Supports separate read and write locks.
//	Multiple threads can acquire the read lock simultaneously, but the write lock is exclusive.
	
	ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
	
	public void write()
	{
		reentrantReadWriteLock.writeLock().lock();
		try
		{
			System.out.println("Performing write operation by Thread "+Thread.currentThread().getName());
			
		}finally
		{
			reentrantReadWriteLock.writeLock().unlock();
		}
	}
	
	public void read()
	{
		reentrantReadWriteLock.readLock().lock();
		try
		{
			System.out.println("Performing read operation by Thread "+Thread.currentThread().getName());
			
		}finally
		{
			reentrantReadWriteLock.readLock().unlock();
		}
	}
	public static void main(String[] args) {
		
		Demo2 demo2=new Demo2();
		
		//write
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				demo2.write();
			}
		});
		thread1.run();
		
		//write
		Thread thread2=new Thread(new Runnable() {
					
			@Override
			public void run() {
						
				demo2.write();
			}
		});
		thread2.run();
				
		//read
		Thread thread3=new Thread(new Runnable() {
					
			@Override
			public void run() {
						
				demo2.read();
			}
		});
		thread3.run();
		
		//read
		Thread thread4=new Thread(new Runnable() {
							
			@Override
			public void run() {
								
				demo2.read();
			}
		});
		thread4.run();
	}
}
