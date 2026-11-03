# PA3 - Evaluación aplicada sobre pilas y colas

> **Curso:** Algoritmo y Estructura de Datos Basados en Inteligencia Artificial
> **Código:** 30710
> **Evaluación:** PA3
> **Video de exposición:** [PEGAR AQUÍ EL LINK DE YOUTUBE]

## Objetivo del trabajo

Seleccionar y justificar el uso de estructuras LIFO (pila) y FIFO (cola) en una unidad de servicios académicos, representando gráficamente sus operaciones, diseñando sus algoritmos (apilar, desapilar, encolar, desencolar) y argumentando qué estructura conviene en cada situación del caso.

## Integrantes

| Integrante | Rol | Aporte principal |
|---|---|---|
| [ALESSANDRO ISMAEL GALLO QUIROZ] | Desarrollador de Pila LIFO | Explicación de LIFO, representación gráfica de la pila, algoritmos (apilar, desapilar, tope, estaVacia), implementación en Java y aplicación concreta de la Actividad 1. |
| [JOSE FERNANDO FRIAS DÍAZ] | Desarrollador de Cola FIFO | Explicación de FIFO, representación gráfica de la cola, algoritmos (encolar, desencolar, frente, estaVacia) y aplicación concreta de la Actividad 2. |
| [GIANFRANCO ARTURO BERNAL SARAVIA] | Analista de Selección de Estructura | Elección de pila o cola en las 4 situaciones reales con su justificación técnica de la Actividad 3. Además, armado del informe final en PDF. |
| [YANHIRA LIZETH GUTIERREZ PÉREZ] | Analista de Comparación | Tabla comparativa entre pila y cola (principio, operaciones, acceso y ventajas) de la Actividad 4. |
| [MARTHA SOFIA LOZANO PAREDES] | Analista de Conclusiones y Documentación | Conclusión grupal de la Actividad 4. Además, gestión del repositorio en GitHub y README. |

## BASE COMÚN DEL PROYECTO (Alineación Grupal)

Para mantener la coherencia entre todas las actividades (1, 2, 3 y 4), se definió la siguiente estructura común:

### Estructuras

- **Pila de acciones (LIFO):** historial de acciones que se deshacen en orden inverso al registrado.
- **Cola de solicitudes (FIFO):** solicitudes que se atienden en el mismo orden en que llegan.

### Estructura del NODO

- **`dato`**: texto con la acción o la solicitud (por ejemplo, "Modificar nota").
- **`siguiente`**: enlace de referencia al nodo que está debajo (pila) o detrás (cola).

### Nombres de las operaciones

| Pila | Código | Cola | Código |
|---|---|---|---|
| apilar | `push` | encolar | `enqueue` |
| desapilar | `pop` | desencolar | `dequeue` |
| tope | `peek` | frente | `frente` |
| estaVacia | `estaVacia` | estaVacia | `estaVacia` |

### Datos de ejemplo base

**Pila de acciones** (la última en entrar queda en el tope):

```text
tope → [Anular constancia] → [Cambiar datos del alumno] → [Registrar matrícula] → [Modificar nota] → null
```

**Cola de solicitudes** (la primera en entrar queda al frente):

```text
frente → [Solicitud de constancia] → [Solicitud de certificado] → [Duplicado de carné] → [Rectificación de nota] → null
```

## Instrucciones de uso

1. Clonar el repositorio: `git clone [LINK DEL REPOSITORIO]`
2. Abrir la carpeta de la actividad en un IDE de Java (NetBeans, IntelliJ o Eclipse).
3. Ejecutar la clase que contiene el método `main` (por ejemplo, `PilaAcciones` en `Actividad1_Pila`).
4. La consola mostrará las acciones apiladas y desapiladas, o las solicitudes encoladas y desencoladas, según la actividad.

Las actividades 3 y 4 son documentos de análisis y están incluidas en el informe PDF.

--------------------------------------------------------------------------------------------------------------
## Actividad 1. Pila LIFO

### a. Características de una estructura LIFO

LIFO significa *Last In, First Out* (último en entrar, primero en salir). Es el principio de funcionamiento de la pila, una estructura de datos lineal en la que los elementos se organizan uno sobre otro, como una pila de platos: el último que se coloca es el primero que se retira.

Sus características principales son:

- **Acceso por un solo extremo:** tanto la inserción como la eliminación se realizan únicamente por el tope. No se puede sacar un elemento del medio ni de la base sin antes retirar los que están encima.
- **Orden inverso de salida:** los elementos salen en el orden contrario al que entraron.
- **Operaciones básicas:** apilar (agregar un elemento al tope), desapilar (retirar el elemento del tope), tope (consultar el elemento superior sin retirarlo) y estaVacia (verificar si no hay elementos).

### Representación gráfica para el caso propuesto

En el caso de la unidad de servicios académicos, la pila almacena las acciones registradas para poder deshacerlas en orden inverso. La figura muestra tres momentos:

1. La pila vacía, con el tope en nulo.
2. La pila después de apilar "Modificar nota", "Registrar matrícula", "Cambiar datos del alumno" y "Anular constancia". Esta última queda en el tope por ser la más reciente.
3. La pila después de desapilar dos veces: primero se deshace "Anular constancia" y luego "Cambiar datos del alumno", quedando "Registrar matrícula" en el tope.

### b. Algoritmos de la pila

La pila se implementa con nodos enlazados. Cada nodo guarda un `dato` (la acción) y un `siguiente` (el nodo que está debajo). La pila solo conoce el `tope`, que vale nulo cuando está vacía.

**estaVacia()**

```text
Función estaVacia()
    Si tope = nulo entonces
        Retornar verdadero
    Sino
        Retornar falso
    Fin Si
Fin Función
```

**apilar(accion)**

```text
Procedimiento apilar(accion)
    nuevo ← crear Nodo(accion)
    nuevo.siguiente ← tope
    tope ← nuevo
Fin Procedimiento
```

**desapilar()**

```text
Función desapilar()
    Si estaVacia() entonces
        Mostrar "La pila está vacía"
        Retornar nulo
    Fin Si
    accion ← tope.dato
    tope ← tope.siguiente
    Retornar accion
Fin Función
```

**tope()**

```text
Función tope()
    Si estaVacia() entonces
        Mostrar "La pila está vacía"
        Retornar nulo
    Fin Si
    Retornar tope.dato
Fin Función
```

**Implementación en Java**

La implementación completa está en la carpeta `Actividad1_Pila`. La clase `PilaLista` contiene las operaciones `push` (apilar), `pop` (desapilar), `peek` (tope) y `estaVacia`. El método `main` apila las cuatro acciones del caso, desapila dos y muestra cómo se deshacen en orden inverso.

```java
static class Nodo {
    String dato;
    Nodo siguiente;

    Nodo(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

static class PilaLista {
    private Nodo tope;

    public PilaLista() { tope = null; }

    public boolean estaVacia() { return tope == null; }

    public void push(String accion) {
        Nodo nuevo = new Nodo(accion);
        nuevo.siguiente = tope;
        tope = nuevo;
        System.out.println("Acción apilada: " + accion);
    }

    public String pop() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return null;
        }
        String accion = tope.dato;
        tope = tope.siguiente;
        System.out.println("Acción deshecha: " + accion);
        return accion;
    }

    public String peek() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return null;
        }
        return tope.dato;
    }
}
```

### c. Aplicación concreta del caso

En la unidad de servicios académicos, la pila es la estructura más adecuada para el **historial de acciones que pueden deshacerse**. Cada vez que se realiza una operación (modificar una nota, registrar una matrícula, cambiar datos de un alumno o anular una constancia), la acción se apila. Al deshacer, se desapila la acción del tope, que es la más reciente.

La pila es la más adecuada por tres razones:

- **El orden de reversión coincide con el principio LIFO:** lo último que se hizo debe deshacerse primero. Revertir una acción antigua antes que una reciente podría dejar los datos inconsistentes.
- **Solo se necesita acceder a la acción más reciente:** el tope siempre indica cuál es la próxima acción a deshacer, sin recorrer el historial.
- **Las operaciones son rápidas:** apilar y desapilar solo mueven el tope, sin importar cuántas acciones haya registradas.

## Actividad 2. Cola FIFO

## Actividad 3. Selección de estructura para situaciones reales

## Actividad 4. Comparación y argumentación


