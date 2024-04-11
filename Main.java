import java.util.ArrayList;
public class Main{
    public interface Subscriber{
        public void update(String context);
    }

    static class Listener implements Subscriber{
        public void update(String context){
            System.out.println(context);
        }
    }

    static class Subject{
        ArrayList<Listener> listaObservadores;

        public Subject(){
            this.listaObservadores = new ArrayList<>();
        }

        public void subscribe(Listener observador){
            listaObservadores.add(observador);
        }
        public void unsubscribe(Listener observador){
            listaObservadores.remove(observador);
        }
        public void notifySubscribers(){
            for (int i = 0; i < listaObservadores.size(); i++){
                Listener observador = listaObservadores.get(i);
                observador.update("Houve uma mudança no Subject");
            }
        }



    }
    public static void main(String[] args){
        Listener observador = new Listener();
        Subject observado = new Subject();
        observado.subscribe(observador);
        observado.notifySubscribers();
    }
}