package heap;

public class SortedHeap implements Heap<Integer> {


    private int capacity;
    private int size;
    private Integer queue[];

    public SortedHeap(int capacity){
        /* Constructeur */
        this.capacity=capacity;
        this.size=0;
        this.queue = new Integer[this.capacity];

    }
    public int posPere(int posFils){
        /*retourne la position du père; si le fils est la racine du heap alors retourne 0*/
        if (posFils>0) {
            if (posFils % 2 == 1) {
                return (posFils - 1) / 2;
            } else {
                return (posFils - 2) / 2;
            }
        }
        else{
            return 0;
        }
    }
    public int[] posFils(int posPere){
        /*retourne la position des 2 fils*/
        int tab[] = new int[2];
        tab[0]=2*posPere+1; tab[1]=2*posPere+2;
        return tab;
    }

    public boolean insertElement(Integer e){
        /*ajoute un elt dans le heap et retourne true si l'ajout s'est bien passé, false sinon. */
        try {

            if (this.size > this.capacity) {
                /*cas ou il n'y a pas de place pour ajouter notre élément */
                this.capacity=capacity*2;
                Integer newqueue[] = new Integer[capacity];
                newqueue = queue.clone();
                this.queue = newqueue;

            }

            /* procédure pour ajouter notre élément */
            int pos = size;
            queue[pos] = e;

            int posp = posPere(pos);
            int temp = queue[posp];
            while (e > temp) {
                queue[pos] = temp;
                queue[posp] = e;
                pos = posp;
                posp = posPere(pos);
                temp = queue[posp];
            }
            size++;


        }catch(Exception pb){
            return false;
        }finally{
            return true;
        }

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

    public String toString(){
        /* permet d'afficher tous les éléments du heap */
        String str ="";
        for(int i=0;i<this.capacity;i++){
            str+="position "+i+" : "+this.queue[i]+"\n";
        }
        return str;
    }

}
