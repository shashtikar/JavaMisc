package Shashank.Ashtikar.Java.Multithreading;

import java.util.Random;

public class Writer implements Runnable {

	UnixPipe up;
	Random r;
	
	Writer(UnixPipe upRef)
	{
		this.up = upRef;
		this.r = new Random();
	}
	
	public void write(int data) throws InterruptedException
	{
		while(up.isFull())
		{
			synchronized (up) {
				up.wait();
			}
			
		}
		
		if(up.write(data)){
		System.out.println("Writer thread - Successfully wrote: "+data);
		synchronized (up) {
		up.notifyAll();	
		}
		
		}
		
		
	}

	@Override
	public void run() {
		System.out.println("Starting the writer thread");
		while(true)
		{
			try {
				System.out.println("Writer Sleeping ...");
				Thread.sleep(r.nextInt(3000)+700);
				write(r.nextInt(3000)+700);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
