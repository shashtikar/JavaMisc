package Shashank.Ashtikar.Java.Multithreading;

import java.util.Random;

public class Reader implements Runnable{

	Random r;
	UnixPipe up;
	
	public Reader(UnixPipe upRef) {
		this.up=upRef;
		r= new Random();
	}
	public void read() throws InterruptedException
	{
		
	}

	@Override
	public void run() {
		System.out.println("Starting the reader thread");
		while(true)
		{
			try {
				
				System.out.println("Reader Sleeping ...");
				Thread.sleep(r.nextInt(400)+100);
				System.out.println("Attempting to read ...");
				//read();
				while (up.isEmpty())
				{
					System.out.println("Waiting because pipe is empty");
					synchronized (up) {
						up.wait();
					}
					
				}
				
				System.out.println("Reader thread: "+up.read());
				synchronized (up) {
				up.notifyAll();	
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
