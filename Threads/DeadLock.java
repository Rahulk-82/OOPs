package OOPs.Threads;



public class DeadLock {
    public static void main(String []args){
        String r1="Resource 1";
        String r2="Resource 2";
        Thread t1=new Thread(()->{
            synchronized (r1){
                System.out.println("Got lock of r1 by t1");
                synchronized (r2){
                    System.out.println("Got lock of r2 by t1");
                }
            }
        });
        Thread t2=new Thread(()->{
            synchronized (r2){
                System.out.println("Got lock of r2 by t2");
                synchronized (r1){
                    System.out.println("Got lock of r2 by t2");
                }
            }
        });
        t1.start();
        t2.start();
    }



}
