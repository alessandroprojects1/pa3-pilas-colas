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
3. Ejecutar la clase que contiene el método `main` (por ejemplo, `PilaAcciones` en `Actividad1` o `ColaSolicitudes` en `Actividad2`).
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

### a. Características de una estructura FIFO

FIFO significa *First In, First Out* (primero en entrar, primero en salir). Es el principio de funcionamiento de la cola, una estructura de datos lineal en la que los elementos se atienden en el mismo orden en que llegan, como una fila de atención en ventanilla: la primera solicitud en registrarse es la primera en ser atendida.

Sus características principales son:

- **Acceso por dos extremos diferenciados:** la inserción se realiza únicamente por el **final** (*fin*) y la extracción o consulta se realiza únicamente por el **frente**. No se puede retirar ni insertar arbitrariamente un elemento en el medio de la fila.
- **Orden de llegada preservado:** los elementos salen exactamente en el mismo orden en que ingresaron, garantizando equidad y evitando que una solicitud quede postergada indefinidamente.
- **Operaciones básicas:** encolar (agregar un elemento al final de la cola), desencolar (retirar y atender el elemento del frente), frente (consultar el primer elemento sin retirarlo) y estaVacia (verificar si no hay elementos en espera).

### Representación gráfica para el caso propuesto

En el caso de la unidad de servicios académicos, la cola almacena las solicitudes de los alumnos para atenderlas por estricto orden de llegada. La figura muestra tres momentos:

1. La cola vacía, con las referencias `frente` y `final` en nulo.
2. La cola después de encolar "Solicitud de constancia", "Solicitud de certificado", "Duplicado de carné" y "Rectificación de nota". La primera solicitud registrada ("Solicitud de constancia") queda en el `frente`, mientras que la última en ingresar ("Rectificación de nota") se ubica en el `final`.
3. La cola después de desencolar dos veces: primero se atiende y retira "Solicitud de constancia" y luego "Solicitud de certificado", quedando "Duplicado de carné" en el `frente` y "Rectificación de nota" en el `final`.

```text
Momento 1: Cola vacía
frente → null
final  → null

Momento 2: Después de encolar las 4 solicitudes
frente                                                                                          final
  ↓                                                                                               ↓
[Solicitud de constancia] → [Solicitud de certificado] → [Duplicado de carné] → [Rectificación de nota] → null

Momento 3: Después de desencolar 2 solicitudes ("Solicitud de constancia" y "Solicitud de certificado")
frente                      final
  ↓                           ↓
[Duplicado de carné] → [Rectificación de nota] → null
```

### b. Algoritmos de la cola

La cola se implementa con nodos enlazados. Cada nodo guarda un `dato` (la solicitud) y un `siguiente` (el nodo que está detrás en la fila). La cola mantiene dos referencias: `frente` (primer nodo a atender) y `fin` (último nodo ingresado), que valen nulo cuando está vacía.

**estaVacia()**

```text
Función estaVacia()
    Si frente = nulo entonces
        Retornar verdadero
    Sino
        Retornar falso
    Fin Si
Fin Función
```

**encolar(solicitud)**

```text
Procedimiento encolar(solicitud)
    nuevo ← crear Nodo(solicitud)
    Si estaVacia() entonces
        frente ← nuevo
        fin ← nuevo
    Sino
        fin.siguiente ← nuevo
        fin ← nuevo
    Fin Si
Fin Procedimiento
```

**desencolar()**

```text
Función desencolar()
    Si estaVacia() entonces
        Mostrar "La cola está vacía"
        Retornar nulo
    Fin Si
    solicitud ← frente.dato
    frente ← frente.siguiente
    Si frente = nulo entonces
        fin ← nulo
    Fin Si
    Retornar solicitud
Fin Función
```

**frente()**

```text
Función frente()
    Si estaVacia() entonces
        Mostrar "La cola está vacía"
        Retornar nulo
    Fin Si
    Retornar frente.dato
Fin Función
```

**Implementación en Java**

La implementación completa está en la carpeta `Actividad2`. La clase `ColaLista` contiene las operaciones `enqueue` (encolar), `dequeue` (desencolar), `frente` y `estaVacia`. El método `main` encola las cuatro solicitudes del caso, desencola dos y muestra cómo se atienden en estricto orden de llegada.

```java
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

    public boolean estaVacia() { return frente == null; }

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

    public String frente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return frente.dato;
    }
}
```

### c. Aplicación concreta del caso

En la unidad de servicios académicos, la cola es la estructura más adecuada para la **atención de solicitudes de trámites estudiantiles** (solicitud de constancia, solicitud de certificado, duplicado de carné y rectificación de nota). Cada vez que un alumno registra un trámite, la solicitud se encola al final; al atender, se desencola la solicitud del frente, que es la más antigua en espera.

La cola es la más adecuada por tres razones:

- **El orden de atención coincide con el principio FIFO:** el primer trámite registrado debe ser el primero en atenderse, garantizando equidad y evitando que solicitudes antiguas queden relegadas.
- **Acceso directo a ambos extremos de operación:** el `frente` indica siempre cuál es la siguiente solicitud por atender y el `final` (`fin`) indica dónde insertar la nueva solicitud entrante.
- **Las operaciones son rápidas:** tanto encolar como desencolar solo actualizan referencias (`frente` o `fin`) en tiempo constante, sin recorrer toda la fila de espera.

## Actividad 3. Selección de estructura para situaciones reales

En una unidad de servicios académicos es necesario utilizar estructuras de datos que permitan gestionar correctamente las acciones registradas y las solicitudes recibidas. Para ello, se analiza cada situación y se determina si corresponde utilizar una pila (LIFO) o una cola (FIFO).

| Situación | Estructura | Justificación |
|-----------|------------|------------------------|
| **Registro de acciones recientes para revertir cambios** | Pila (LIFO) | La pila permite deshacer las acciones en orden inverso a su registro. La última acción realizada es la primera que se revierte. Por ejemplo, si primero se registra una matrícula y después se modifican los datos del alumno, la modificación debe deshacerse antes que el registro de matrícula. Esto se consigue mediante las operaciones apilar y desapilar. |
| **Atención de solicitudes en orden de llegada** | Cola (FIFO) | La cola permite atender primero la solicitud que ingresó antes que las demás. Por ejemplo, si una solicitud de constancia llega antes que una solicitud de certificado, la primera debe atenderse antes. Las operaciones encolar y desencolar permiten mantener este orden de atención. |
| **Procesamiento donde el último ingresado debe atenderse primero** | Pila (LIFO) | El principio LIFO establece que el último elemento ingresado es el primero en salir. Esto permite procesar primero la acción más reciente mediante la operación desapilar, sin alterar el orden de los elementos anteriores. |
| **Flujo de espera de trámites pendientes** | Cola (FIFO) | La cola organiza los trámites pendientes según su orden de llegada. Los trámites nuevos se incorporan al final y los más antiguos se retiran desde el frente para ser atendidos. Esto permite mantener un flujo ordenado y evitar que las solicitudes recientes se adelanten a las anteriores. |





## Actividad 4. Comparación y argumentación

## Estructura de datos: Pila (Stack)
 
### 1. Principio de funcionamiento
 
La pila utiliza el principio **LIFO** (*Last In, First Out*: último en entrar, primero en salir). Es decir, el último elemento agregado es el primero en retirarse.
 
### 2. Operaciones principales
 
| Operación | Descripción |
|-----------|-------------|
| `push`    | Agrega un elemento. |
| `pop`     | Elimina el último elemento. |
| `peek`    | Muestra el elemento superior. |
 
### 3. Forma de uso
 
Los elementos se agregan y eliminan desde la parte superior de la pila.
 
### 4. Ventajas y desventajas
 
**Ventajas**
- Es sencilla, rápida y fácil de implementar.
**Desventajas**
- Solo permite acceder directamente al elemento superior.
### 5. Ejemplos de aplicación
 
- Deshacer acciones (`Ctrl + Z`).
- Historial de navegación.
- Ejecución de funciones en programación.

### Estructura de datos Cola 

### 1. Principio de funcionamiento

La cola utiliza el principio FIFO (primero en entrar, primero en salir). Es decir, el primer elemento agregado es el primero en retirarse.

### 2. Operaciones principales

- Enqueue:agrega un elemento al final.

- Dequeue:elimina el primer elemento.

- Front:muestra el primer elemento sin eliminarlo.

### 3. Forma de uso

Los elementos ingresan por el final de la cola y se retiran desde el inicio, respetando el orden de llegada.

### 4. Ventajas y desventajas

- Ventajas: mantiene el orden de llegada y permite organizar tareas.
- Desventajas: no permite acceder directamente a cualquier elemento.

### 5. Ejemplos de aplicación

- Turnos de atención en bancos.
- Cola de impresión de documentos.
- Procesamiento de tareas en una computadora.


### Conclusión grupal

La pila y la cola son estructuras útiles para organizar datos, pero tienen diferentes formas de funcionamiento. La pila utiliza LIFO, mientras que la cola utiliza FIFO. Por eso, elegir la estructura correcta permite resolver los problemas de manera más ordenada y eficiente.



 

