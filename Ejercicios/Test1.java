package Ejercicios;

import avltree.AVLTree;
import avltree.BSTree;
import Excepciones.ItemDuplicated;
import Excepciones.ItemNoFound;
import Excepciones.ExceptionEmpty;

public class Test1 {
    public static void main(String[] args) throws ExceptionEmpty {
        BSTree<Integer> bst = new BSTree<>();
        AVLTree<Integer> avl = new AVLTree<>();

        try {
            // Insertar elementos en BST
            bst.insert(10);
            bst.insert(20);
            bst.insert(30);
            bst.insert(40);
            bst.insert(50);

            // Insertar mismos elementos en AVL
            avl.insert(10);
            avl.insert(20);
            avl.insert(30);
            avl.insert(40);
            avl.insert(50);

            // Mostrar alturas para comparar balance
            System.out.println("Altura BST para 50: " + bst.height(50));
            System.out.println("Altura AVL para 50: " + avl.height(50));

            // Buscar elemento en ambos rboles
            System.out.println("Buscar 30 en BST: " + bst.search(30));
            System.out.println("Buscar 30 en AVL: " + avl.search(30));

            // Buscar elemento no existente para probar excepcion
            try {
                System.out.println("Buscar 100 en BST: " + bst.search(100));
            } catch (ItemNoFound e) {
                System.out.println("BST: " + e.getMessage());
            }

            try {
                System.out.println("Buscar 100 en AVL: " + avl.search(100));
            } catch (ItemNoFound e) {
                System.out.println("AVL: " + e.getMessage());
            }

        } catch (ItemDuplicated | ItemNoFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

