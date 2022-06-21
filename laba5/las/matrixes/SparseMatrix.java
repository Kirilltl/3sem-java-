package techprog.las.matrixes;
import java.util.*;
public class SparseMatrix extends UsualMatrix implements IMatrix {
    private final LinkedList<LinkedList<ElementSM>>list;
    public SparseMatrix(int rows, int columns) {
        super(rows, columns);
        list = new LinkedList<LinkedList<ElementSM>>();
    }

    public void setElem(int row, int column, int value) {
        ElementSM el = new ElementSM(row, column, value);
        Iterator<LinkedList<ElementSM>> itRow = list.listIterator();
        while (itRow.hasNext()) {
            LinkedList<ElementSM> i = itRow.next();
            if (!i.isEmpty()){
                if (i.getFirst().getX() == row){
                    for (ElementSM elementSM : i){
                        if (elementSM.getX() == row && elementSM.getY() == column)
                            i.remove();
                    }
                    if (value != 0)
                        i.add(el);
                    return;
                }

            }
        }
        if (value != 0) {
            LinkedList<ElementSM> newList = new LinkedList<ElementSM>();
            newList.add(el);
            list.add(newList);
        }
    }

    public int getElem(int row, int column) {
        Iterator<LinkedList<ElementSM>> itRow = list.listIterator();
        while (itRow.hasNext()){
            LinkedList<ElementSM> i = itRow.next();
            if (i.getFirst().getX() == row){
                for (ElementSM elementSM : i){
                    if (elementSM.getY() == column)
                        return elementSM.getVal();
                }
            }
        }
        return 0;
    }
}


