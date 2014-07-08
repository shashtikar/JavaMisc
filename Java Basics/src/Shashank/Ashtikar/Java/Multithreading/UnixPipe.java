package Shashank.Ashtikar.Java.Multithreading;

public class UnixPipe {
	
	int pipe[] = new int[100];
	
	private int maxSize;
	
	private int runningIndex;
	
	public UnixPipe(int refSize) {
		maxSize = refSize;		
		runningIndex=0;
		pipe[runningIndex]=123456;
	}
	
	public boolean isEmpty()
	{
		return (runningIndex==0);
	}
	
	public boolean isFull()
	{
		return (runningIndex==maxSize);
	}
	
	public synchronized int read()
	{
		int output;
		if(!isEmpty())
		{
			output = pipe[runningIndex];
			runningIndex--;
		}
		else
		{
			output=0;	
		}
		return output;
		
	}
	
	public synchronized boolean write(int data)
	{
		if (!isFull())
		{
			runningIndex++;
			pipe[runningIndex]=data;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
