package co.uptc.edu.gui;

// URL del Video Explicativo: https://www.youtube.com/watch?v=tu_enlace_aqui

import co.uptc.edu.negocio.Cliente;
import co.uptc.edu.negocio.Cuenta;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();

        System.out.println("=== SISTEMA DE GESTION BANCARIA UPTC ===");

        do {
            System.out.println("Ingrese el Tipo de Documento (RC, TI, CC, CE, PA, PEP):");
            cliente.tipoDocumento = sc.nextLine();
            if (!cliente.validarTipoDocumento()) {
                System.out.println("Error: Tipo de documento no valido.");
            }
        } while (!cliente.validarTipoDocumento());

        do {
            System.out.println("Ingrese el Numero de Documento:");
            cliente.numeroDocumento = Long.parseLong(sc.nextLine());
            if (!cliente.validarNumeroDocumento()) {
                System.out.println("Error: Numero de documento debe ser positivo.");
            }
        } while (!cliente.validarNumeroDocumento());

        System.out.println("Ingrese Nombres y Apellidos:");
        cliente.nombresApellidos = sc.nextLine();

        do {
            System.out.println("Ingrese el Telefono:");
            cliente.telefono = Long.parseLong(sc.nextLine());
            if (!cliente.validarTelefono()) {
                System.out.println("Error: Telefono no valido.");
            }
        } while (!cliente.validarTelefono());

        System.out.println("Ingrese la Direccion:");
        cliente.direccion = sc.nextLine();

        System.out.println("Ingrese la Fecha de Nacimiento (DD/MM/AAAA):");
        cliente.fechaNacimiento = sc.nextLine();

        System.out.println("Ingrese la Edad:");
        cliente.edad = Integer.parseInt(sc.nextLine());

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        cliente.codigoCliente = "";

        for (int i = 0; i < 8; i++) {
            int posicionAleatoria = (int) (Math.random() * caracteres.length());
            cliente.codigoCliente += caracteres.charAt(posicionAleatoria);
        }

        System.out.println("Ingrese el Tipo de Cuenta (Ahorros, Corriente, CDT):");
        cuenta.tipoCuenta = sc.nextLine();

        int numeroAleatorio = (int) (Math.random() * 90000) + 10000;

        if (cuenta.tipoCuenta.equalsIgnoreCase("Ahorros")) {
            cuenta.numeroCuenta = "CA" + numeroAleatorio;
        } else if (cuenta.tipoCuenta.equalsIgnoreCase("Corriente")) {
            cuenta.numeroCuenta = "CC" + numeroAleatorio;
        } else if (cuenta.tipoCuenta.equalsIgnoreCase("CDT")) {
            cuenta.numeroCuenta = "CDT" + numeroAleatorio;
        } else {
            cuenta.numeroCuenta = "Desconocido";
        }

        do {
            System.out.println("Ingrese el valor a consignar:");
            cuenta.valorConsignar = Double.parseDouble(sc.nextLine());

            System.out.println("Ingrese el valor a retirar:");
            cuenta.valorRetirar = Double.parseDouble(sc.nextLine());

            if (!cuenta.validarMovimiento()) {
                System.out.println("Error: Los valores deben ser positivos y el retiro no puede superar la consignacion.");
            }
        } while (!cuenta.validarMovimiento());

        cuenta.saldoActual = cuenta.valorConsignar - cuenta.valorRetirar;
        cuenta.interesesGenerados = cuenta.saldoActual * 0.05;
        cuenta.saldoActual = cuenta.saldoActual + cuenta.interesesGenerados;

        int numFormulario = (int) (Math.random() * 900000) + 100000;

        System.out.println("\n==================================================");
        System.out.println("          ORDEN DE TRANSACCIONES");
        System.out.println("==================================================");
        System.out.println("Formulario: " + numFormulario);
        System.out.println("Fecha y hora del registro: 2026-05-05 15:30");
        System.out.println("Tipo de Documento: " + cliente.tipoDocumento);
        System.out.println("Numero de Documento: " + cliente.numeroDocumento);
        System.out.println("Nombres y Apellidos del cliente: " + cliente.nombresApellidos.toUpperCase());
        System.out.println("Edad: " + cliente.edad);
        System.out.println("Codigo: " + cliente.codigoCliente);
        System.out.println("Nombre del programa Asociado: Tecnologia en Programacion de Sistemas Informaticos");
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
