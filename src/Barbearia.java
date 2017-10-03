import java.util.LinkedList;

public class Barbearia {
    private int tamanhoFila = 5;
    private LinkedList<Cliente> fila = new LinkedList<Cliente>();
    private Barbeiro barbeiro = new Barbeiro(this);
    private Thread thBarbeiro = new Thread(barbeiro);


    public Barbearia(){
        thBarbeiro.start();
    }

    public synchronized void cortar(Cliente cliente){
        System.out.println(cliente.getNome() + " chegou");
        if(fila.size() == tamanhoFila){
            System.out.println("Fila cheia");
        } else {
            System.out.println("Cliente "+ cliente.getNome() + " entrou na fila");
            fila.add(cliente);
        }
    }

    public synchronized Cliente cortarProximo(){
        Cliente proximo = null;
        if(fila.size() > 0){
            proximo = fila.getFirst();
            fila.removeFirst();
        }
        return proximo;
    }
}
