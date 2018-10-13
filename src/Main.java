import heap.*;

public class Main {



    public static void main(String[] args) {

        SortedHeap test = new SortedHeap(20, new HeapComparator());

        for(int i=0;i<10;i++) {
            test.insertElement(100+i);
        }
        test.insertElement(566);
        test.insertElement(25);
        test.insertElement(1);
        test.insertElement(999999999);
        test.insertElement(0);
        test.insertElement(-25);

        System.out.println(test);



        //TEST ITERATOR AVEC 2 BOUCLES !=
        /*
        Iterator<Integer> it = test.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
        for (Integer i : test){
            System.out.println(i);
        }
        */

        //  TEST POPELEMENT & ELEMENT

        /*
        Integer j = test.element();
        Integer i = test.popElement();
        System.out.println("element() : " + j + " / popElement() : " + i +"\n");
        System.out.println(test);
        */

    }
}
