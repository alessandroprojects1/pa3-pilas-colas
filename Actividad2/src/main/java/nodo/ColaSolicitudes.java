package nodo;

public class ColaSolicitudes {

    static class Nodo {
        String dato;
        Nodo siguiente;

        Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    static class ColaLista {
        private Nodo frente;
        private Nodo fin;

        public ColaLista() {
            frente = null;
            fin = null;
        }

        public boolean estaVacia() {
            return frente == null;
        }

        // enqueue (encolar)
        public void enqueue(String solicitud) {
            Nodo nuevo = new Nodo(solicitud);
            if (estaVacia()) {
                frente = nuevo;
                fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
            System.out.println("Solicitud encolada: " + solicitud);
        }

        // dequeue (desencolar)
        public String dequeue() {
            if (estaVacia()) {
                System.out.println("La cola está vacía");
                return null;
            }
            String solicitud = frente.dato;
            frente = frente.siguiente;
            if (frente == null) {
                fin = null;
            }
            System.out.println("Solicitud atendida: " + solicitud);
            return solicitud;
        }

        // frente
        public String frente() {
            if (estaVacia()) {
                System.out.println("La cola está vacía");
                return null;
            }
            return frente.dato;
        }

        public void mostrar() {
            System.out.println("--- FRENTE ---");
            Nodo actual = frente;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
            System.out.println("--- FINAL ---");
        }
    }

    public static void main(String[] args) {
        ColaLista cola = new ColaLista();

        System.out.println("¿Cola vacía? " + cola.estaVacia());

        cola.enqueue("Solicitud de constancia");
        cola.enqueue("Solicitud de certificado");
        cola.enqueue("Duplicado de carné");
        cola.enqueue("Rectificación de nota");

        cola.mostrar();
        System.out.println("Frente actual: " + cola.frente());

        cola.dequeue();
        cola.dequeue();

        cola.mostrar();
        System.out.println("Frente actual: " + cola.frente());
        System.out.println("¿Cola vacía? " + cola.estaVacia());
    }
}
