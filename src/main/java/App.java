import controllers.ArbolBinario;
import models.Node;

public class App {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        int[] valoresIniciales = {9, 14, 17, 19, 23, 50, 54, 76};

        for (int val : valoresIniciales) {
            arbol.insert(val);
        }
        System.out.println("\nPeso del árbol = " + arbol.getPeso());
        System.out.println("Altura es = " + arbol.getAltura());

        System.out.print("\nArbol InOrder\n");
        arbol.imprimirInOrder();

        System.out.print("\nArbol InOrder con alturas\n");
        arbol.imprimirAlturas();

        System.out.print("\nArbol InOrder con factor de equilibrio\n");
        arbol.imprimirBalanceFactors();

        boolean equilibradoAntes = arbol.estaEquilibrado();
        System.out.println("\nArbol está equilibrado = " + equilibradoAntes);

        System.out.println("\nAgregamos valor = 15");
        arbol.insert(15);

        System.out.print("\nArbol InOrder con factor de equilibrio\n");
        arbol.imprimirBalanceFactors();

        System.out.println("\nNodos desequilibrados:");
        arbol.imprimirDesequilibrados();
    }

}
