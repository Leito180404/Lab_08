package avltree;
import Excepciones.ExceptionEmpty;
import Excepciones.ItemDuplicated;
import Excepciones.ItemNoFound;

public interface BSTree<E> {   
    void insert(E data) throws ItemDuplicated;
    E search(E data) throws ItemNoFound;
    void delete(E data) throws ExceptionEmpty;
    boolean isEmpty();
}
