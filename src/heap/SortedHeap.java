package heap;

public class SortedHeap implements Heap<Integer> {


    private int capacity;
    private int size;
    private Integer queue[];

    public SortedHeap(int capacity){
        this.capacity=capacity;
        this.size=0;
        this.queue = new Integer[this.capacity];

    }
    public int posPere(int posFils){
        /*retourne la position du père*/
        if(posFils%2==1){return (posFils-1)/2;}
        else{return (posFils-2)/2;}
    }

    public boolean insertElement(Integer e){
        return true;

    }

    public Integer element(){
        return 0;
    }

    public Integer popElement(){
        return 0;
    }


    public boolean isEmpty(){
        return true;
    }

    public int size(){
        return 0;
    }

}
