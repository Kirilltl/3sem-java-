public class Main {
	public static void main(String[] args) {
		/*Int n = new Int();
		System.out.println(" n = " + n);
		
		n.increment();
		System.out.println(" Increment: n = " + n);
		
		n.decrement();
		System.out.println(" Decrement: n = " + n);
		
		n.add(n);
		System.out.println(" Add: n = " + n);
		
		n.substract(n);
		System.out.println(" Substract: n = " + n);
		
		Int v = new Int();
		v.increment();
		for(int i = 0; i < 10; i++)
			v.add(v);
		for(int i = 0; i < 24; i++)
			v.decrement();
		System.out.println(" Task, method 1: v = " + v);
		
		Int g = new Int();
		g.increment();
		for(int i = 0; i < 9; i++)
			g.add(g);
		for(int i = 0; i < 588; i++)
			g.increment();
		System.out.println(" Task, method 2: g = " + g);*/
		Complex c = new Complex(5, -2);
        Complex d = new Complex(-7, 1);
		c.mult(d);
        c.print();
		
	}	
}