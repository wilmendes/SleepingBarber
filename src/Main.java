public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Barbearia barbearia = new Barbearia();
        GeradorDeClientes gc = new GeradorDeClientes(barbearia, 1000);
        Thread thGc = new Thread(gc);
        thGc.start();
    }
}
