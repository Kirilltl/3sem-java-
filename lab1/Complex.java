public class Complex {
	public double real;
    public double imaginary; 
	
	 public Complex() {
        this.real += 0;
        this.imaginary += 0;
    }
    
    public Complex(double real) {
        this.real += real;
        this.imaginary += 0;
    }
    
    public Complex(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }
	
	public void add(Complex other){
          this.real += other.real;
          this.imaginary += other.imaginary;
    }
	
	public void mult(Complex other){
          real *= other.real;
          imaginary *= other.imaginary;
    }
	
	public void print(){
    if(this.imaginary <0){
        System.out.println(this.real + "-" + Math.abs(this.imaginary) + "i");
     }
     if(this.imaginary >0){
        System.out.println(this.real + "+" + this.imaginary + "i");
     }
    }
}