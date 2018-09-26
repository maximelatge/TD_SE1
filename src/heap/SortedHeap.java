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

    /* Fonction subsidières -----------------------------------------------------------------------------*/
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
/*------------------------------------------------------------------------------------------------------*/


    public boolean insertElement(Integer e){
        /*ajoute un elt dans le heap et retourne true si l'ajout s'est bien passé, false sinon. */
        try {

            if (this.size == this.capacity) {
                /*cas ou il n'y a pas de place pour ajouter notre élément */

                Integer queue2[] = new Integer[capacity*2];

                for(int j=0;j<capacity;j++){
                    queue2[j]=this.queue[j];
                }
                this.capacity=capacity*2;
                this.queue = queue2;
                /* est ce que l'on supprime l'ancienne queue ? */

            }

            /* procédure pour ajouter notre élément */
            int pos = size;
            queue[pos] = e;

            int posp = posPere(pos);
            Integer temp = queue[posp];
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
        /* retourne le plus grand élément de la liste sans l'enlever mais ne marche pas */
        if(size==0){
            //throw new NoSuchElementException;        comment ça marche?
            return 0;
        }
        else {
            Integer m = queue[0];
            Integer e = queue[0];
            for (int i=1; i<capacity; i++){
                e = queue[i];
                if(e>m){
                    m=e;
                }
            }
            return m;
        }
    }


    public Integer popElement(){
        /* retourne le plus grand élément de la liste en l'enlevant mais ne marche pas */
        Integer elt = element();
        return elt;
    }


    public boolean isEmpty(){
        /* return true si le tas est vide*/
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        /* return le nb d'elt du tas */
        return size;
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
