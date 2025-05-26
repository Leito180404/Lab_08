import Excepciones.ItemDuplicated;
import avltree.AVLTree;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        try {
            // Rotaciones simples a la derecha (RSR) - 2 casos
            System.out.println("Insertando para RSR - Caso 1");
            tree.insert(30);
            tree.insert(20);
            tree.insert(10);
            System.out.println("Inorder: " + tree.toString());

            System.out.println("Insertando para RSR - Caso 2");
            tree.insert(40);
            tree.insert(35);
            tree.insert(25); // Otra rotacion simple derecha
            System.out.println("Inorder: " + tree.toString());

            // Rotaciones simples a la izquierda (RSL) - 2 casos
            System.out.println("Insertando para RSL - Caso 1");
            tree.insert(50);
            tree.insert(60);
            tree.insert(70); // Aquí rotacion simple izquierda
            System.out.println("Inorder: " + tree.toString());

            System.out.println("Insertando para RSL - Caso 2");
            tree.insert(65);
            tree.insert(80);
            tree.insert(90); // Otra rotacion simple izquierda
            System.out.println("Inorder: " + tree.toString());

            // Rotaciones dobles a la derecha (RDR) - 2 casos
            System.out.println("Insertando para RDR - Caso 1");
            tree.insert(15);
            tree.insert(12);
            tree.insert(18); // Aquí rotacion doble derecha
            System.out.println("Inorder: " + tree.toString());

            System.out.println("Insertando para RDR - Caso 2");
            tree.insert(17);
            tree.insert(14);
            tree.insert(19); // Otra rotacion doble derecha
            System.out.println("Inorder: " + tree.toString());

            // Rotaciones dobles a la izquierda (RDL) - 2 casos
            System.out.println("Insertando para RDL - Caso 1");
            tree.insert(75);
            tree.insert(85);
            tree.insert(82); // Aquí rotacion doble izquierda
            System.out.println("Inorder: " + tree.toString());

            System.out.println("Insertando para RDL - Caso 2");
            tree.insert(78);
            tree.insert(90);
            tree.insert(83); // Otra rotacion doble izquierda
            System.out.println("Inorder: " + tree.toString());

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

