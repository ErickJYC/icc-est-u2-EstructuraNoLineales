package controllers;

import models.Node;

public class ArbolBinario {
    private Node root;
    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);

    }

    private Node insertRec(Node padre, int value){
        if (root == null){
            return new Node(value);
        }
        if (value < padre.getValue())
//            ME VOY A LA IZQUIERDA
            padre.setLeft(insertRec(padre.getLeft(),value));

         else if (value > padre.getValue()) {
//            ME VOY A LA DERECHA
            padre.setLeft(insertRec(padre.getRight(),value));

        }
        return padre;
    }
    public void imprimirArbol(){
        imprimir(root);

    }

    private void imprimir(Node node){
        if (node != null) {
            imprimir(node.getLeft());
            System.out.println(node.getValue() + " , ");
            imprimir(node.getRight());
        }
    }
//    Preorden
    public void imprimirPreorden(Node node){
        if (node != null){
            System.out.println(node.getValue() + " , ");
            imprimir(node.getLeft());
            imprimir(node.getRight());
        }

    }
    public void imprimirArbolPreorden(){
        imprimirPreorden(root);
    }
    public boolean buscar (int value){
        return buscar(value);
    }
    public boolean buscarRec(Node padre, int value){
        if (padre.getValue() == value)
            return true;
        if (value < padre.getValue()) {
            if (value > padre.getValue()){
                return buscarRec(padre, value);
            }

        }
        return false;
    }
}
