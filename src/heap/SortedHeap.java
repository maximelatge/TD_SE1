package heap;
import java.util.*;


public class SortedHeap<E> implements Heap<E>{


    private int capacity;
    private int size;
    private Object queue[];
    private Comparator<E> comparator;

    public SortedHeap(int capacity, Comparator<E> comparator){
        /* Constructeur */
        this.capacity = capacity;
        this.size=0;
        this.queue = new Object[this.capacity];
        this.comparator = comparator;

    }

    /*Iterateur ---------------------------------------------------------------------------------------*/

    private class HeapIterator implements Iterator<E> {

        private int cursor;

        private HeapIterator(){
            this.cursor = -1;
        }

        /*Returns true if the iteration has more elements.*/
        public boolean hasNext(){
            if(cursor == SortedHeap.this.capacity-1){
                return false;
            }
            else{
                return (SortedHeap.this.queue[cursor+1] != null);
            }
        }

        /*Returns the next element in the iteration.*/
        public E next(){
            return (E)SortedHeap.this.queue[++cursor];
        }
    }

    public Iterator<E> iterator(){
        return new HeapIterator();
    }

    /*------------------------------------------------------------------------------------------------------*/


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
        if(a<size){
            compteur++;
        }
        if(b<size){
            compteur++;
        }
        return compteur;
    }

    private boolean hasFils(int posPere){
        /*retourne True si le père à un fils ou plus   */
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
            E vala = (E)queue[posfa];
            E valb = (E)queue[posfb];
            if(comparator.compare(vala,valb)>0){
                return posfa;
            }
            else{
                return posfb;
            }
        }
    }

    private void sortUp(int pos){
        /*permet de ranger un élément lorsqu'il est ajouté à la fin*/
        E e = (E)queue[pos];
        int posp = posPere(pos);
        E temp = (E)queue[posp];

        while (comparator.compare(e,temp) > 0 && pos>0) {
            queue[pos] = temp;
            queue[posp] = e;
            pos = posp;
            posp = posPere(pos);
            temp = (E)queue[posp];
        }
    }

    private void sortDown(int pos) {
        /*permet de reranger la liste lors de la suppression d'un élément */
        E e = (E)queue[pos];

        if (hasFils(pos)) {

            int posbf = posBiggestFils(pos);
            E temp = (E)queue[posbf];

            while (comparator.compare(e,temp) < 0 && hasFils(pos)) {

                queue[posbf] = e;
                queue[pos] = temp;
                pos = posbf;
                if(hasFils(pos)) {
                    posbf = posBiggestFils(pos);
                    temp = (E)queue[posbf];
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
    public boolean insertElement(E e) {
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
     * @throws NoSuchElementException si il n'y a pas de 1er élément.
     */
    public E element()throws NoSuchElementException {
            if (size == 0) {
                throw new NoSuchElementException();
            } else {
                return (E)queue[0];
            }
        }



    public E popElement()throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            E ObjectToReturn = (E)queue[0];

            size--;
            queue[0]=queue[size];
            queue[size]=null;
            sortDown(0);

            return ObjectToReturn;
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
            str+=("position "+i+" : "+this.queue[i]+"\n");
        }
        return str;
    }

}
