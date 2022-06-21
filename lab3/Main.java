package techprog.lab3;
import techprog.lab3.matrixes.*;
public class Main{
	public static void main(String[] args){
			try{			
				SquareMatrix m = new SquareMatrix(2);	
				System.out.println(m);
				NewMatrix q = new NewMatrix(2, 2);
				q.setElem(0, 0, 1);
				//q.setElem(0, 1, 2);
				//q.setElem(1, 0, 1);
				q.setElem(1, 1, 2);
				/*q.setElem(2, 0, 1);
				q.setElem(2, 1, 2);			
				q.setElem(3, 0, 1);
				q.setElem(3, 1, 2);
				q.setElem(4, 0, 1);
				q.setElem(4, 1, 2);*/
				System.out.println(q);
				System.out.println("res: ");
				System.out.println(q.add(m));
				System.out.println(q.equals(m));
			}
			catch(MyException e){
				System.out.println(e.getMessage());
			}			
		}
}