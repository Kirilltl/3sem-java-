package com.company;
import java.util.*;
public class SortedIntegerList {
    private final LinkedList<Integer>list;
    private final boolean param;

    SortedIntegerList(boolean param) {
        this.param = param;
        list = new LinkedList<Integer>();
    }

    public void add(int val) {
        if (list.isEmpty()){
            list.add(val);
            return;
        }
        ListIterator<Integer>it = list.listIterator();
        int elem = 0;
        while(it.hasNext()){
            elem = it.next();
            if((elem == val) && (!this.param))
                return;
            if(elem >= val){
                it.previous();
                it.add(val);
                return;
            }
        }
        if(elem < val)
            list.addLast(val);
    }

    public  void remove(int val){
        ListIterator<Integer>it = list.listIterator();
        int elem = 0;
        while(it.hasNext()) {
            elem = it.next();
            if(elem == val) {
                it.remove();
            }
        }
    }

    public SortedIntegerList unity(SortedIntegerList a){
        if(list.size() != a.list.size())
            return null;

        SortedIntegerList result = new SortedIntegerList(param);
        ListIterator<Integer> it1 = list.listIterator();
        ListIterator<Integer> it2 = a.list.listIterator();
        int lt1 = 0; int lt2 = 0;
        while (it1.hasNext() && it2.hasNext()) {
            lt1 = it1.next();
            lt2 = it2.next();;
            result.add(lt1);
            result.add(lt2);
        }
        return result;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        ListIterator<Integer>it = list.listIterator();
        while(it.hasNext()){
            str.append(it.next());
            str.append(" ");
        }
        String s = str.toString();
        return s;
    }

    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(o == null)
            return false;
        if(!(o instanceof SortedIntegerList l))
            return false;
        if(list.size() != l.list.size())
            return false;
        ListIterator<Integer>it1 = list.listIterator();
        ListIterator<Integer>it2 = l.list.listIterator();
        while((it1.hasNext()) && (it2.hasNext())){
            if(!it1.next().equals(it2.next()))
                return false;
        }
        return true;
    }
}

