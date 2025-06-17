import controllers.ArbolBinario;
import models.Node;

public class App {
    public static void main(String[] args) {
        ArbolBinario ab = new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        ab.imprimirArbol();
        ab.imprimirArbolPreorden();
        ab.buscar(23);
        if (!ab.buscar(77)) {
            System.out.println("No encontro");

        }
    }

}
