import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MyRandomList {
    private LinkedList<Integer> MySortList;
    boolean canRepeat;

    public MyRandomList(boolean canRepeat1){
        canRepeat = canRepeat1;
        MySortList = new LinkedList<Integer>();
    }

    public  void add(int number) {
        if(MySortList.size() == 0) {
            MySortList.add(number);
            return;
        }
        ListIterator<Integer> it = MySortList.listIterator();
        int p = 0;
        while(it.hasNext()){
            p = it.next();
            if(p == number && !this.canRepeat)
                return;
            if(p >= number){
                it.previous();
                it.add(number);
                return;
            }
        }
        if(p < number)
            MySortList.addLast(number);
    }

    public  void remove(int number){
        ListIterator<Integer> it = MySortList.listIterator();
        int p = 0;
        while(it.hasNext()) {
            p = it.next();
            if(p == number) {
                it.remove();
            }
        }
        if(p == number)
            MySortList.remove();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<Integer> listIter = MySortList.listIterator();
        while(listIter.hasNext()){
            str.append(listIter.next() + " ");
        }
        return str.toString();
    }
}
