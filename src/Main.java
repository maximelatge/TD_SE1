import heap.*;

public class Main {



    public static void main(String[] args) {

        SortedHeap<Integer> integerHeap = new SortedHeap(20, new IntegerComparator());

        for(int i=0;i<10;i++) {
            integerHeap.insertElement(100+i);
        }
        integerHeap.insertElement(566);
        integerHeap.insertElement(25);
        integerHeap.insertElement(1);
        integerHeap.insertElement(999999999);
        integerHeap.insertElement(0);
        integerHeap.insertElement(-25);

        System.out.println(integerHeap);

        SortedHeap<String> stringHeap = new SortedHeap(10,new StringComparator());

        stringHeap.insertElement("a");
        stringHeap.insertElement("cheval");
        stringHeap.insertElement("Cédric");
        stringHeap.insertElement("Ceci est une phrase.");
        stringHeap.insertElement("Bologne");
        stringHeap.insertElement("abc");
        stringHeap.insertElement("Strasbourg");
        stringHeap.insertElement("Jouques");

        System.out.println(stringHeap);

        stringHeap.popElement();

        System.out.println(stringHeap);

    }
}
