package test;

import heap.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;



class SortedHeapTest {


    @org.junit.jupiter.api.Test
    void Tests() {

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

        assertEquals(999999999, (int)integerHeap.returnElement(0));
        assertEquals(109,(int)integerHeap.returnElement(1));
        assertEquals(1, (int)integerHeap.returnElement(12));

        assertEquals(999999999, (int)integerHeap.popElement());
        assertEquals(566, (int)integerHeap.popElement());

        assertEquals(14, integerHeap.size());
        assertEquals(false,integerHeap.isEmpty());


    }


}