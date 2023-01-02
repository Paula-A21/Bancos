package verificaciones;

import dominio.Banco;
import dominio.CajaDeAhorro;
import dominio.Cliente;
import dominio.CuentaCorriente;
import reportes.ReporteCliente;

public class VerificaReporteDeClientes {
    
    public static void main(String[] args) {
     
    	inicializarClientes();
        
        // Ejecutar el reporte de clientes
        ReporteCliente report = new ReporteCliente();
        report.generarReporte();
     
    }
    
    private static void inicializarClientes() {
        Cliente cliente;
        
        // Crear varios clientes y sus respectivas cuentas
        Banco.agregaCliente("Juan", "P�rez");
		cliente = Banco.getCliente(0);
		cliente.agregaCuenta(new CajaDeAhorro(500.00, 0.03));
		cliente.agregaCuenta(new CuentaCorriente(200.00));
        
        Banco.agregaCliente("Pedro", "Garc�a");
		cliente = Banco.getCliente(1);
		cliente.agregaCuenta(new CuentaCorriente(500.00));
		cliente.agregaCuenta(new CajaDeAhorro(380.00, 0.03));
        
        Banco.agregaCliente("Oscar", "Toma");
		cliente = Banco.getCliente(2);
		cliente.agregaCuenta(new CuentaCorriente(500.00, 500.00));
		cliente.agregaCuenta(new CajaDeAhorro(700.00, 0.03));
        
        Banco.agregaCliente("Maria", "Soley");
		cliente = Banco.getCliente(3);
		// Maria y Oscar tienen una caja de ahorros en com�n
		cliente.agregaCuenta(Banco.getCliente(2).getCuenta(1));
		cliente.agregaCuenta(new CuentaCorriente(150.00, 0.05));
		
    	Banco.ordenarClientes();
    }
}