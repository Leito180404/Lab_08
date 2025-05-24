import Excepciones.ItemDuplicated;

public class Testejercicio5 {
    public static void main(String[] args) {
        AVLTree2<Integer> avl = new AVLTree2<>();
        try {
            // Insertar valores para probar rotaciones y recorrido preorden
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(20);
            avl.insert(40);
            avl.insert(60);
            avl.insert(80);

            System.out.print("Recorrido Preorden: ");
            avl.preorden();

            System.out.print("Recorrido por amplitud: ");
            avl.recorridoAmplitud();
            System.out.println();

            // Prueba eliminación
            avl.delete(20);
            System.out.print("Preorden después de eliminar 20: ");
            avl.preorden();

        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error durante eliminación: " + e.getMessage());
        }
    }
}


