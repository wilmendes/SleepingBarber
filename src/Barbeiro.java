public class Barbeiro implements Runnable {
    private Barbearia barbearia;

    public Barbeiro(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    public void sleep() {
        System.out.println("zzzZZZzzzZZZ...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            sleep();
            cortar();
        }
    }

    public synchronized void cortar() {
        Cliente cliente = barbearia.cortarProximo();
        if (cliente == null)
            return;

        System.out.println("Cortando cabelo de: " + cliente.getNome());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        cortar();
    }
}
