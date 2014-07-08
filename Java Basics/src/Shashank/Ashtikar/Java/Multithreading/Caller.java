package Shashank.Ashtikar.Java.Multithreading;

public class Caller {

    public static void main(String[] args)
    {
        UnixPipe up = new UnixPipe(100);
        System.out.println("Starting the threads");
        new Thread(new Reader(up)).start();
        new Thread(new Writer(up)).start();
    }
}
