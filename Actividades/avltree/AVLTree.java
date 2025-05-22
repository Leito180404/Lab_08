package avltree;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
    class NodeAVL extends Node {
        protected int bf;  // factor de equilibrio

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;  // Inicializamos el factor de equilibrio en 0
        }

        @Override
        public String toString() {
            return data.toString() + "(" + bf + ")";
        }
    }

    @SuppressWarnings("unused")
    private boolean height;  // indicador de cambio de altura
}

