public class Int {
	private int val;
	Int() {
		val = 0;
	}
	
	public void increment() {
		val++;
	}
	
	public void decrement() {
		val--;
	}
	
	public void add (Int n) {
		this.val += n.val;
	}
	
	public void substract (Int n) {
		this.val -= n.val;
	}
	
	public String toString() {
		return ("" + val);
	}
}