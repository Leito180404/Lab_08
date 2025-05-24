import Excepciones.ItemDuplicated;
import Excepciones.ItemNoFound;
import avltree.*;

public class AVLTree2<E extends Comparable<E>> extends BSTree<E> {
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

    private boolean height;  // indicador de cambio de altura

    @Override
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL) this.root);
    }

    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;
            if (node == null) {
                this.height = true;
                fat = new NodeAVL(x);
            } else {
                int resC = node.data.compareTo(x);
            if (resC == 0)
                throw new ItemDuplicated(x + " ya se encuentra en el arbol...");
        if (resC < 0) {
            fat.right = insert(x, (NodeAVL) node.right);
            if (this.height) {
                switch (fat.bf) {
                    case -1:
                        fat.bf = 0;
                        this.height = false;
                        break;
                    case 0:
                        fat.bf = 1;
                        this.height = true;
                        break;
                    case 1:
                        fat = balanceToLeft(fat);
                        this.height = false;
                        break;
                }
            }
        } else {
            fat.left = insert(x, (NodeAVL) node.left);
            if (this.height) {
                switch (fat.bf) {
                    case 1:
                        fat.bf = 0;
                        this.height = false;
                        break;
                    case 0:
                        fat.bf = -1;
                        this.height = true;
                        break;
                    case -1:
                        fat = balanceToRight(fat);
                        this.height = false;
                        break;
                }
            }
        }
    }
    return fat;
    }

    private NodeAVL balanceToLeft(NodeAVL node){
    NodeAVL hijo = (NodeAVL)node.right;
    switch(hijo.bf) {
        case 1:
            node.bf = 0;
            hijo.bf = 0;
            node = rotateSL(node);
            break;
        case -1:
            NodeAVL nieto = (NodeAVL)hijo.left;
            switch(nieto.bf) {
                case -1: node.bf = 0; hijo.bf = 1; break;
                case 0:  node.bf = 0; hijo.bf = 0; break;
                case 1:  node.bf = 1; hijo.bf = 0; break;
            }
            nieto.bf = 0;

            node.right = rotateSR(hijo); 
            node = rotateSL(node);
    }
        return node;
    }
    private NodeAVL balanceToRight(NodeAVL node){
        NodeAVL hijo = (NodeAVL) node.left;
        switch(hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch(nieto.bf) {
                    case -1: node.bf = 1; hijo.bf = 0; break;
                    case 0:  node.bf = 0; hijo.bf = 0; break;
                    case 1:  node.bf = 0; hijo.bf = -1; break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
                break;
        }
        return node;
    }

    private NodeAVL rotateSL(NodeAVL node){
        NodeAVL p = (NodeAVL)node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }

    private NodeAVL rotateSR(NodeAVL node){
        NodeAVL p = (NodeAVL)node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }

    //ejercicio 2
    @Override
    public void delete(E x) {
        this.height = false;
        try {
            this.root = delete(x, (NodeAVL) this.root);
        } catch (ItemNoFound e) {
            throw new RuntimeException(e);}
    }


    protected NodeAVL delete(E x, NodeAVL node) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound(x + " no encontrado en el arbol");
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(x, (NodeAVL) node.left);
            if (this.height) {
                node = balanceToLeft(node);
            }
        } else if (cmp > 0) {
            node.right = delete(x, (NodeAVL) node.right);
            if (this.height) {
                node = balanceToRight(node);
            }
        } else {
            // Nodo encontrado
            if (node.left == null) {
                this.height = true;
                return (NodeAVL) node.right;
            } else if (node.right == null) {
                this.height = true;
                return (NodeAVL) node.left;
            } else {
                NodeAVL sucesor = (NodeAVL) findMinNode(node.right);
                node.data = sucesor.data;
                node.right = delete(sucesor.data, (NodeAVL) node.right);
                if (this.height) {
                    node = balanceToLeft(node);
                }
            }
        }
        return node;
    }

    //ejercicio 3 y 4
    public void recorridoAmplitud() {
        int h = height();
        for (int i = 0; i < h; i++) {
            recorridoNivel(root, i);
        }
    }

    private void recorridoNivel(Node node, int nivel) {
        if (node == null) return;
        if (nivel == 0) {
            System.out.print(node.data + " ");
        } else {
            recorridoNivel(node.left, nivel - 1);
            recorridoNivel(node.right, nivel - 1);
        }
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    //ejercicio 5
    public void preorden() {
        preordenRec(root);
        System.out.println();
    }

    private void preordenRec(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preordenRec(node.left);
        preordenRec(node.right);
    }
    //ejercicio 6
    
}
