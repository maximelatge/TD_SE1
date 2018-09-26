import heap.SortedHeap;

public class Main {



    public static void main(String[] args) {

        SortedHeap test = new SortedHeap(11);

        for(int i=0;i<=10;i++) {
            test.insertElement(100+i);
        }
        boolean a = test.insertElement(3);

        System.out.println(a);
        System.out.println(test);
    }
}
