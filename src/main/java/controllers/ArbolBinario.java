package controllers;

import models.Node;

public class ArbolBinario {
    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    // Insertar valor
    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node current, int value){
        if (current == null){
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setLeft(insertRec(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRec(current.getRight(), value)); // ✅ Aquí se corrigió
        }
        return current;
    }

    // InOrder simple
    public void imprimirInOrder(){
        imprimirInOrder(root);
        System.out.println();
    }

    private void imprimirInOrder(Node node){
        if (node != null) {
            imprimirInOrder(node.getLeft());
            System.out.print(node.getValue() + ", ");
            imprimirInOrder(node.getRight());
        }
    }

    // InOrder con altura
    public void imprimirAlturas(){
        imprimirAlturasRec(root);
        System.out.println();
    }

    private void imprimirAlturasRec(Node node){
        if (node != null) {
            imprimirAlturasRec(node.getLeft());
            System.out.print(node.getValue() + "(h=" + altura(node) + "), ");
            imprimirAlturasRec(node.getRight());
        }
    }

    // InOrder con factor de equilibrio
    public void imprimirBalanceFactors(){
        imprimirBFRec(root);
        System.out.println();
    }

    private void imprimirBFRec(Node node){
        if (node != null) {
            imprimirBFRec(node.getLeft());
            System.out.print(node.getValue() + "(bf=" + balanceFactor(node) + "), ");
            imprimirBFRec(node.getRight());
        }
    }

    // Altura
    private int altura(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(altura(node.getLeft()), altura(node.getRight()));
    }

    // Factor de equilibrio
    private int balanceFactor(Node node) {
        if (node == null) return 0;
        return altura(node.getRight()) - altura(node.getLeft());
    }

    // Ver si el árbol está equilibrado
    public boolean estaEquilibrado() {
        return estaEquilibradoRec(root);
    }

    private boolean estaEquilibradoRec(Node node){
        if (node == null) return true;
        int bf = balanceFactor(node);
        if (Math.abs(bf) > 1) return false;
        return estaEquilibradoRec(node.getLeft()) && estaEquilibradoRec(node.getRight());
    }

    // Imprimir nodos desequilibrados
    public void imprimirDesequilibrados(){
        imprimirDesequilibradosRec(root);
    }

    private void imprimirDesequilibradosRec(Node node){
        if (node != null) {
            imprimirDesequilibradosRec(node.getLeft());
            int bf = balanceFactor(node);
            if (Math.abs(bf) > 1) {
                System.out.println("Nodo desequilibrado: " + node.getValue() + " (fE = " + bf + ")");
            }
            imprimirDesequilibradosRec(node.getRight());
        }
    }

    // Altura total del árbol
    public int getAltura() {
        return altura(root);
    }

    // Peso del árbol
    public int getPeso() {
        return contarNodos(root);
    }

    private int contarNodos(Node node) {
        if (node == null) return 0;
        return 1 + contarNodos(node.getLeft()) + contarNodos(node.getRight());
    }
}
