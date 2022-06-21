public class Synchr {
	public static void main(String []args){
		Object x = new Object();
		Object y = new Object();
		new Thread(()->{
			synchronized(x){
				System.out.println(Thread.currentThread().getName()+": got x monitor");
				try{Thread.sleep(1000);}
				catch(Throwable ignored){}
				System.out.println(Thread.currentThread().getName()+": try get y monitor");
				synchronized(y){
					System.out.println(Thread.currentThread().getName()+": got y monitor");
				}
			}
		}).start();

		new Thread(()->{
			synchronized(y){
				System.out.println(Thread.currentThread().getName()+": got y monitor");
				try{Thread.sleep(1000);}
				catch(Throwable ignored){}
				System.out.println(Thread.currentThread().getName()+": try get x monitor");
				synchronized(x){
					System.out.println(Thread.currentThread().getName()+": got x monitor");
				}
			}
		}).start();	
	}
}