import avltree.AVLTree;
import Excepciones.ItemDuplicated;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        try {
            // Caso 1: Forzar rotacion RSR
            avl.insert(30);
            avl.insert(20);
            avl.insert(10); // Desequilibrio
            System.out.println("Después RSR: " + avl);

            // Caso 2: Forzar rotacion RSL
            avl.insert(40);
            avl.insert(50); // Desequilibrio
            System.out.println("Después RSL: " + avl);

            // Caso 3: Forzar rotacion RDR
            avl.insert(25);
            avl.insert(22); // Desequilibrio
            System.out.println("Después RDR: " + avl);

            // Caso 4: Forzar rotacion RDL
            avl.insert(45);
            avl.insert(43); // Desequilibrio
            System.out.println("Después RDL: " + avl);

            // Otros casos
            avl.insert(35);
            avl.insert(15);
            avl.insert(27);
            avl.insert(55);

            System.out.println("Árbol AVL final: " + avl);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
            }

    }}

