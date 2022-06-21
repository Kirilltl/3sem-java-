package techprog.las;
import techprog.las.matrixes.*;
public class Main {
    public static void main(String[] args) {
        try {
            IMatrix u1 = new UsualMatrix(5, 5);
            IMatrix u2 = new UsualMatrix(5, 5);
            IMatrix um = new UsualMatrix(5, 5);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    u1.setElem(i, j, i + j * 3);
                    u2.setElem(i, j, i + j * 3);
                }
            }
            um = u1.sum(u2);

            IMatrix s1 = new SparseMatrix(5, 5);
            IMatrix s2 = new SparseMatrix(5, 5);
            IMatrix sm = new SparseMatrix(5, 5);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    s1.setElem(i, j, i + j * 4);
                    s2.setElem(i, j, i + j * 4);
                }
            }
            sm = s1.sum(s2);

            System.out.println(s1.equals(u1));
            System.out.println(s2.equals(u2));
            System.out.println(sm.equals(um));
        }
        catch(MyException e){
            System.out.println(e.getMessage());
        }
    }
}
/*IMatrix b = new SquareMatrix(3);
System.out.println(b);
IMatrix c = new SparseMatrix(3,2);
c.setElem(1,1,5);
System.out.println(c);
System.out.println(c.sum(b));*/