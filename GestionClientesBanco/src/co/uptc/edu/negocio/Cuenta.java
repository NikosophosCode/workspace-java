package co.uptc.edu.negocio;

public class Cuenta {
    public String tipoCuenta;
    public String numeroCuenta;
    public double valorConsignar;
    public double valorRetirar;
    public double interesesGenerados;
    public double saldoActual;

    public boolean validarMovimiento() {
        return valorConsignar >= 0 && valorRetirar >= 0 && valorRetirar <= valorConsignar;
    }
}
