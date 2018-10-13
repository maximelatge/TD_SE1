package heap;

import java.util.Comparator;

public class HeapComparator implements Comparator<Integer> {

    public HeapComparator(){
    }

    public int compare(Integer n1,Integer n2){
        if(n1<n2){return -1;}
        else if (n1 == n2){return 0;}
        else {return 1;}
    }

}
