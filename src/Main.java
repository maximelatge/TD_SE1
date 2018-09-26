import heap.SortedHeap;

public class Main {



    public static void main(String[] args) {

        SortedHeap test = new SortedHeap(20);

        for(int i=0;i<10;i++) {
            test.insertElement(100+i);
        }
        System.out.println(test);

        //Integer i = test.element();
        //System.out.println(i);


    }
}
