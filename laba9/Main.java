import java.util.Random;
public class Main {
    public static void main(String []args){
        int size = 10;
        Random rnd = new Random();
        MyRandomList s = new MyRandomList(false);
        int r = rnd.nextInt(100);
        for(int i = 0; i < size; i++)
            s.add(i * r % 11);
        //System.out.println(s);
        s.remove(7);
        //System.out.println(s);
        Object x = new Object();
        Object y = new Object();
        new Thread(()->{
            synchronized(x){
                System.out.println(Thread.currentThread().getName()+": 1 start");
                try{Thread.sleep(1000);}
                catch(Throwable ignored){}
                System.out.println(Thread.currentThread().getName()+": try 1");
                synchronized(y){
                    System.out.println(Thread.currentThread().getName()+": 2 start");
                }
            }
        }).start();

        new Thread(()->{
            synchronized(y){
                System.out.println(Thread.currentThread().getName()+": 2 start");
                try{Thread.sleep(1000);}
                catch(Throwable ignored){}
                System.out.println(Thread.currentThread().getName()+": try 1");
                synchronized(x){
                    System.out.println(Thread.currentThread().getName()+": 1 start");
                }
            }
        }).start();

    }
}
