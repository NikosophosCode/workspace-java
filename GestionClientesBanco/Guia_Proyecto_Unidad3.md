# Guía de Desarrollo Académico: Módulo de Gestión de Clientes y Cuentas
**Tecnología en Programación de Sistemas Informáticos (TPSI) - FESAD UPTC**
**Unidad 3: Fundamentos de Programación**

---

## 1. Estructura del Proyecto en Eclipse
Para cumplir con los estándares exigidos en la rúbrica, tu proyecto debe estar organizado en paquetes. Esto es el primer paso hacia una arquitectura de software ordenada.

- **Nombre del Proyecto:** `Proyecto_Unidad3`
- **Paquetes y Clases:**
  - `co.uptc.edu.negocio`: Contendrá las clases modelo (`Cliente.java` y `Cuenta.java`).
  - `co.uptc.edu.gui`: Contendrá la clase principal de ejecución (`Principal.java`).

---

## 2. Clases de Negocio (Paquete `co.uptc.edu.negocio`)

Dado que aún no hemos profundizado en el encapsulamiento estricto (uso de `private`, constructores complejos, *getters* y *setters*), declararemos nuestros atributos como `public`. Esto permite que la clase `Principal` acceda a ellos directamente.

### Clase `Cliente.java`
```java
package co.uptc.edu.negocio;

public class Cliente {
    // Atributos públicos básicos usando tipos de datos primitivos y String
    public String tipoDocumento; // Ej: RC, TI, CC, CE, PA, PEP
    public String numeroDocumento;
    public String nombresApellidos;
    public String telefono;
    public String direccion;
    public String fechaNacimiento; 
    public String codigoCliente; // Alfanumérico de 8 caracteres generado por el sistema
}
```

### Clase `Cuenta.java`
```java
package co.uptc.edu.negocio;

public class Cuenta {
    // Atributos del producto financiero
    public String tipoCuenta; // Ahorros, Corriente o CDT
    public String numeroCuenta; // Máscara: CA#####, CC##### o CDT#####
    public double valorConsignar;
    public double valorRetirar;
    public double interesesGenerados;
    public double saldoActual;
}
```

---

## 3. Lógica y Ejecución (Paquete `co.uptc.edu.gui`)

La clase `Principal.java` será el "director de la orquesta". Aquí pediremos los datos, haremos los cálculos y mostraremos los resultados.

### Clase `Principal.java`
```java
package co.uptc.edu.gui;

// Importamos nuestras clases de negocio y la herramienta Scanner
import co.uptc.edu.negocio.Cliente;
import co.uptc.edu.negocio.Cuenta;
import java.util.Scanner;

public class Principal {

    // NOTA PARA EL VIDEO: Recuerda poner aquí el enlace de YouTube
    // URL del Video: https://www.youtube.com/watch?v=tu_enlace_aqui

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Instanciamos (creamos) los objetos
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();

        System.out.println("=== SISTEMA DE GESTIÓN BANCARIA UPTC ===");

        // 2. Captura de datos del Cliente
        System.out.println("Ingrese el Tipo de Documento (RC, TI, CC, CE, PA, PEP):");
        cliente.tipoDocumento = sc.nextLine();

        System.out.println("Ingrese el Número de Documento:");
        cliente.numeroDocumento = sc.nextLine();

        System.out.println("Ingrese Nombres y Apellidos:");
        cliente.nombresApellidos = sc.nextLine();

        // (Continúa pidiendo teléfono, dirección, fecha de nacimiento...)

        // 3. Generación del Código Alfanumérico del Cliente (8 caracteres)
        // Utilizamos un texto con las opciones y Math.random() para elegir al azar
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        cliente.codigoCliente = "";

        for (int i = 0; i < 8; i++) {
            // Genera un número aleatorio entre 0 y la longitud del texto
            int posicionAleatoria = (int) (Math.random() * caracteres.length());
            // Extrae el carácter en esa posición y lo suma al código
            cliente.codigoCliente += caracteres.charAt(posicionAleatoria);
        }

        // 4. Captura de datos de la Cuenta
        System.out.println("Ingrese el Tipo de Cuenta (Ahorros, Corriente, CDT):");
        cuenta.tipoCuenta = sc.nextLine();

        // 5. Generación del Número de Cuenta con Máscara
        // Math.random() genera un decimal entre 0.0 y 0.999. 
        // Al multiplicar por 90000 y sumar 10000, aseguramos un número de 5 dígitos (10000 a 99999).
        int numeroAleatorio = (int) (Math.random() * 90000) + 10000;

        // Usamos condicionales básicos (if) para asignar la máscara según el tipo
        if (cuenta.tipoCuenta.equalsIgnoreCase("Ahorros")) {
            cuenta.numeroCuenta = "CA" + numeroAleatorio;
        } else if (cuenta.tipoCuenta.equalsIgnoreCase("Corriente")) {
            cuenta.numeroCuenta = "CC" + numeroAleatorio;
        } else if (cuenta.tipoCuenta.equalsIgnoreCase("CDT")) {
            // Para CDT, la guía pide generar los 5 números igual
            cuenta.numeroCuenta = "CDT" + numeroAleatorio;
        } else {
            cuenta.numeroCuenta = "Desconocido";
        }

        // 6. Movimientos Financieros (Ejemplo básico)
        System.out.println("Ingrese el valor a consignar:");
        // Usamos Double.parseDouble(sc.nextLine()) para evitar el salto de línea residual del Scanner
        cuenta.valorConsignar = Double.parseDouble(sc.nextLine());

        System.out.println("Ingrese el valor a retirar:");
        cuenta.valorRetirar = Double.parseDouble(sc.nextLine());

        // Cálculos básicos (La lógica de interés depende de lo que hayan definido en clase, aquí un 5% de ejemplo)
        cuenta.saldoActual = cuenta.valorConsignar - cuenta.valorRetirar;
        cuenta.interesesGenerados = cuenta.saldoActual * 0.05; 
        cuenta.saldoActual = cuenta.saldoActual + cuenta.interesesGenerados;

        // Generar número de formulario aleatorio (Ej: 6 dígitos)
        int numFormulario = (int) (Math.random() * 900000) + 100000;

        // 7. IMPRESIÓN DE LA ORDEN DE TRANSACCIÓN (Salida esperada)
        System.out.println("\n==================================================");
        System.out.println("          ORDEN DE TRANSACCIONES");
        System.out.println("==================================================");
        System.out.println("Formulario: " + numFormulario);
        // La fecha se puede pedir por consola o poner estática si no han visto la clase Date
        System.out.println("Fecha y hora del registro: 2026-05-05 15:30"); 
        System.out.println("Tipo de Documento: " + cliente.tipoDocumento);
        System.out.println("Numero de Documento: " + cliente.numeroDocumento);

        // REQUISITO CLAVE: Mayúscula sostenida usando .toUpperCase()
        System.out.println("Nombres y Apellidos del cliente: " + cliente.nombresApellidos.toUpperCase());
        System.out.println("Código: " + cliente.codigoCliente);
        System.out.println("Nombre del programa Asociado: Tecnología en Programación de Sistemas Informáticos");
        System.out.println("Tipo Cuenta: Cuenta de " + cuenta.tipoCuenta);
        System.out.println("No. Cuenta: " + cuenta.numeroCuenta);
        System.out.println("Valor a consignar: " + cuenta.valorConsignar);
        System.out.println("Valor a retirar: " + cuenta.valorRetirar);
        System.out.println("Intereses generados: " + cuenta.interesesGenerados);
        System.out.println("Saldo: " + cuenta.saldoActual);
        System.out.println("==================================================");

        sc.close();
    }
}
```

---

## 4. Aspectos Clave para la Nota Máxima (5.0)

1. **La URL del Video:** Es el requisito eliminatorio. Debe ir obligatoriamente en la primera línea de la clase `Principal.java` como comentario (`// https://...`).
2. **Uso de `.toUpperCase()`:** Esta función propia de los `String` convierte el texto ingresado a mayúsculas sostenidas de forma automática, cumpliendo el requerimiento de la guía sin necesidad de lógica extra.
3. **El video explicativo:** Asegúrate de que el video dure más de 20 minutos, que tu rostro sea visible todo el tiempo, y que expliques detalladamente cómo generaste los números aleatorios con `Math.random()`. Muestra también cómo haces *Export > Archive File* en Eclipse para entregar el proyecto.
4. **Claridad del Código:** Como estudiante de primer semestre, no se te evalúa por hacer código complejo, sino por hacer código **claro y que resuelva el problema**. El uso de indentación (espacios ordenados) y nombres de variables descriptivos (ej. `valorConsignar` en vez de `vC`) demuestra un dominio conceptual sólido.
