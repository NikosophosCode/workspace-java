package co.uptc.edu.negocio;

public class Cliente {
    public String tipoDocumento;
    public long numeroDocumento;
    public String nombresApellidos;
    public long telefono;
    public String direccion;
    public String fechaNacimiento;
    public int edad;
    public String codigoCliente;

    public boolean validarTipoDocumento() {
        return tipoDocumento.equalsIgnoreCase("RC") ||
               tipoDocumento.equalsIgnoreCase("TI") ||
               tipoDocumento.equalsIgnoreCase("CC") ||
               tipoDocumento.equalsIgnoreCase("CE") ||
               tipoDocumento.equalsIgnoreCase("PA") ||
               tipoDocumento.equalsIgnoreCase("PEP");
    }

    public boolean validarNumeroDocumento() {
        return numeroDocumento > 0;
    }

    public boolean validarTelefono() {
        return telefono > 0;
    }
}
