import Excepciones.ItemDuplicated;

public class Testejercicio3 {
    public static void main(String[] args) {
        AVLTree2<Integer> avl = new AVLTree2<>();

        try {
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(20);
            avl.insert(40);
            avl.insert(60);
            avl.insert(80);

            System.out.print("Recorrido por amplitud (niveles): ");
            avl.recorridoAmplitud();
            System.out.println();

            System.out.println("Altura del arbol: " + avl.height());

        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
}
