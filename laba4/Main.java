package com.company;
public class Main {
    public static void main(String[] args) {
        SortedIntegerList l1 = new SortedIntegerList(false);
        l1.add(-22);
        l1.add(-22);
        l1.add(-22);
        l1.add(-23);
        l1.add(-23);
        l1.add(27);
        l1.add(-23);
        l1.add(-25);
        l1.add(-29);
        l1.add(-30);
        l1.remove(-23);
        System.out.print("List1: ");
        System.out.println(l1);

        SortedIntegerList l2 = new SortedIntegerList(false);
        l2.add(-22);
        l2.add(-22);
        l2.add(-22);
        l2.add(-23);
        l2.add(-23);
        l2.add(27);
        l2.add(-23);
        l2.add(-25);
        l2.add(-29);
        l2.add(-30);
        l2.remove(-23);
        System.out.print("List2: ");
        System.out.println(l2);
        System.out.print("ListUnion: ");
        System.out.println(l1.unity(l2));
    }
}

