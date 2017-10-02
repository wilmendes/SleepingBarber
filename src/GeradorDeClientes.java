public class GeradorDeClientes implements Runnable{
    private Barbearia barbearia;
    private int id = 0;
    private int intervalo;
    public GeradorDeClientes(Barbearia barbearia, int intervalo){
        this.barbearia = barbearia;
        this.intervalo = intervalo;
    }

    @Override
    public void run() {
        while (true){
            barbearia.cortar(new Cliente("Cliente " + id++));
            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
