import Excepciones.ItemDuplicated;

public class Testejercicio6 {
    public static void main(String[] args) {
        AVLTree2<Integer> avl = new AVLTree2<>();

        try {
            // Inserciones con posibles rotaciones
            insertAndPrint(avl, 30, "Insertar 30");
            insertAndPrint(avl, 20, "Insertar 20");
            insertAndPrint(avl, 10, "Insertar 10 (Rotacion Simple Derecha - RSD)");
            insertAndPrint(avl, 40, "Insertar 40");
            insertAndPrint(avl, 50, "Insertar 50 (Rotacion Simple Izquierda - RSI)");
            insertAndPrint(avl, 25, "Insertar 25 (Rotacion Doble Derecha - RDD)");
            insertAndPrint(avl, 45, "Insertar 45");
            insertAndPrint(avl, 43, "Insertar 43 (Rotacion Doble Izquierda - RDI)");

            // Eliminaciones con posibles rotaciones
            deleteAndPrint(avl, 10, "Eliminar 10 (Posible rebalanceo)");
            deleteAndPrint(avl, 50, "Eliminar 50 (Posible rebalanceo)");
            deleteAndPrint(avl, 30, "Eliminar 30 (Posible rebalanceo)");

        } catch (ItemDuplicated e) {
            System.out.println("Error en insercion: " + e.getMessage());
        }
    }

    private static void insertAndPrint(AVLTree2<Integer> avl, int val, String action) throws ItemDuplicated {
        System.out.println("\n" + action);
        avl.insert(val);
        System.out.print("arbol AVL: ");
        avl.recorridoAmplitud();
    }

    private static void deleteAndPrint(AVLTree2<Integer> avl, int val, String action) {
        System.out.println("\n" + action);
        avl.delete(val);
        System.out.print("arbol AVL: ");
        avl.recorridoAmplitud();
    }
}
