import Excepciones.ItemDuplicated;

public class Testejercicio2 {
    public static void main(String[] args) {
        AVLTree2<Integer> avl = new AVLTree2<>();

        try {
            // Insertar nodos iniciales
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(20);
            avl.insert(40);
            avl.insert(60);
            avl.insert(80);

            System.out.print("arbol inicial (Preorden): ");
            avl.preorden();

            // Eliminar nodo hoja (20)
            avl.delete(20);
            System.out.print("Despues de eliminar hoja (20): ");
            avl.preorden();

            // Eliminar nodo con un solo hijo (30)
            avl.delete(30);
            System.out.print("Despues de eliminar nodo con un hijo (30): ");
            avl.preorden();

            // Eliminar nodo con dos hijos (50)
            avl.delete(50);
            System.out.print("Despues de eliminar nodo con dos hijos (50): ");
            avl.preorden();

        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
