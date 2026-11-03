package nodo;

public class PilaAcciones {

    static class Nodo {
        String dato;
        Nodo siguiente;

        Nodo(String dato){
            this.dato= dato;
            this.siguiente = siguiente;
        }
    }

    static class PilaLista{
        private Nodo tope;


        public PilaLista(){
            tope = null;
        }
        public boolean estaVacia(){
            return tope == null;
        }

        //push
        public void push (String accion){
            Nodo nuevo = new Nodo (accion);
            nuevo.siguiente = tope;
            tope = nuevo;
            System.out.println("Acción apilada: " + accion);
        }

        //pop
        public String pop(){
            if (estaVacia()){
                System.out.println("La pila está vacía");
                return null;
            }
            String accion = tope.dato;
            tope = tope.siguiente;
            System.out.println("Acción deshecha " + accion);
            return accion;
        }

        //tope
        public String peek(){
            if (estaVacia()){
                System.out.println("La pila esta vacía");
                return null;
            }
            return tope.dato;
        }
        public void mostrar() {
            System.out.println("--- TOPE ---");
            Nodo actual = tope;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
            System.out.println("--- BASE ---");
        }

    }

    public static void main(String[] args) {
        PilaLista pila = new PilaLista();

        System.out.println("¿Pila vacía? " + pila.estaVacia());

        pila.push("Modificar nota");
        pila.push("Registrar matrícula");
        pila.push("Cambiar datos del alumno");
        pila.push("Anular constancia");

        pila.mostrar();
        System.out.println("Tope actual: " + pila.peek());

        pila.pop();
        pila.pop();

        pila.mostrar();
        System.out.println("Tope actual: " + pila.peek());
        System.out.println("¿Pila vacía? " + pila.estaVacia());
    }
}

