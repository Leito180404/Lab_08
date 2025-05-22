package avltree;

import Excepciones.ItemDuplicated;

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

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL rightChild = (NodeAVL) node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        return rightChild;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL leftChild = (NodeAVL) node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        return leftChild;
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

}

