package heap;
import java.util.*;


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
    private int posPere(int posFils){
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
    private int nbFils(int posPere){
        /*retourne le nb de fils d'un elt du tas*/
        int compteur = 0;
        int a = 2*posPere+1;
        int b = 2*posPere+2;
        if(a<capacity && queue[a]!=null){
            compteur++;
        }
        if(b<capacity && queue[b]!=null){
            compteur++;
        }
        return compteur;
    }

    private boolean hasFils(int posPere){
        return nbFils(posPere)!=0;
    }

    private int posBiggestFils(int posPere){
        /*retourne la position du plus grand des 2 fils en supposant qu'il a au moins un fils */
        int nb = nbFils(posPere);
        int posfa = 2*posPere+1;
        int posfb = 2*posPere +2;

        if(nb==1){
            return posfa;
        }
        else{
            Integer vala = queue[posfa];
            Integer valb = queue[posfb];
            if(vala>valb){
                return posfa;
            }
            else{
                return posfb;
            }
        }
    }

    private void sortUp(int pos){
        Integer e = queue[pos];
        int posp = posPere(pos);
        Integer temp = queue[posp];

        while (e > temp || pos>0) {
            queue[pos] = temp;
            queue[posp] = e;
            pos = posp;
            posp = posPere(pos);
            temp = queue[posp];
        }
    }

    private void sortDown(int pos) {

        Integer e = queue[pos];

        if (hasFils(pos)) {

            int posbf = posBiggestFils(pos);
            Integer temp = queue[posbf];

            while (temp > e && hasFils(pos)) {

                queue[posbf] = e;
                queue[pos] = temp;
                pos = posbf;
                if(hasFils(pos)) {
                    posbf = posBiggestFils(pos);
                    temp = queue[posbf];
                }
            }
        }
    }

    /*------------------------------------------------------------------------------------------------------*/

    /**
     *
     * @param e elt que l'on ajoute
     * @return true si l'ajout de l'elt s'est bien passé, false sinon.
     */
    public boolean insertElement(Integer e) {
        if (this.size == this.capacity) {
            /*cas ou il n'y a pas de place pour ajouter notre élément */

            this.queue = Arrays.copyOf(queue, capacity * 2);
            this.capacity = capacity * 2;

        }

        /* procédure pour ajouter notre élément */
        int pos = size;
        queue[pos] = e;
        sortUp(pos);
        size++;

        return true;
    }

    /**
     *
     * @return le plus grand elt de la liste sans l'enlever
     * @throws NoSuchElementException
     */
    public Integer element()throws NoSuchElementException {
            if (size == 0) {
                throw new NoSuchElementException();
            } else {
                return queue[0];
            }
        }



    public Integer popElement()throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Integer IntegerToReturn = queue[0];

            size--;
            queue[0]=queue[size];
            queue[size]=null;
            sortDown(0);

            return IntegerToReturn;
        }
    }

    /**
     *
     * @return true si le tas est vide
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     *
     * @return nb d'elt du tas
     */
    public int size(){
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
