package p03_IteratorTest;

import javax.naming.OperationNotSupportedException;

public class Main{
    public static void main(String[] args) throws OperationNotSupportedException {
        //Just a Probe
        ListIterator ls = new ListIterator("first","SECOND");
        String first = ls.print();
        System.out.println(first.equals("first"));
    }
}

