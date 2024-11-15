package com.LockNSynchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
	
//	ReentrantLock:
//	A reentrant lock allows the same thread to acquire the lock multiple times without blocking itself.
//	Requires explicit locking and unlocking.

	private Lock lock=new ReentrantLock();
	
	public void method1()
	{
		lock.lock();
		try {
			System.out.println("Thread "+Thread.currentThread().getName()+" got lock");
		}finally
		{
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		
		Demo1 demo1=new Demo1();
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				demo1.method1();
			}
		});
	
		thread1.run();
		
Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				demo1.method1();
			}
		});
	
		thread2.run();
	}
}
