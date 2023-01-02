package verificaciones;
import dominio.Banco;
import dominio.CajaDeAhorro;
import dominio.Cliente;
import dominio.Cuenta;
import dominio.CuentaCorriente;
import dominio.ExcepcionSobregiro;


public class PruebaOperacionesBancarias {

	public static void main(String[] args) {
		Cliente cliente;
		Cuenta cuenta;

		Banco.agregaCliente("Juan", "Perez");
		cliente = Banco.getCliente(0);
		cliente.agregaCuenta(new CajaDeAhorro(500.00, 0.05));
		cliente.agregaCuenta(new CuentaCorriente(200.00, 500.00));
		Banco.agregaCliente("Oscar", "Toma");
		cliente = Banco.getCliente(1);
		cliente.agregaCuenta(new CuentaCorriente(200.00));

		cliente = Banco.getCliente(0);
		cuenta = cliente.getCuenta(1);
		System.out.println("El Cliente [" + cliente.getApellido() + ", "
				+ cliente.getPrimerNombre() + "]"
				+ " tiene un balance en cuenta corriente de "
				+ cuenta.getBalance()
				+ " con una protección por sobregiro de 500.00.");
		try {
			System.out.println("Cuenta Corriente [Juan Perez]: retira 150.00");
			cuenta.retira(150.00);
			System.out
					.println("Cuenta Corriente [Juan Perez]: deposita 22.50");
			cuenta.deposita(22.50);
			System.out.println("Cuenta Corriente [Juan Perez]: retira 147.62");
			cuenta.retira(147.62);
			System.out.println("Cuenta Corriente [Juan Perez]: retira 470.00");
			cuenta.retira(470.00);
		} catch (ExcepcionSobregiro e1) {
			System.out.println("Excepción: " + e1.getMessage() + "   Deficit: "
					+ e1.getDeficit());
		} finally {
			System.out.println("El Cliente [" + cliente.getApellido() + ", "
					+ cliente.getPrimerNombre() + "]"
					+ " tiene un balance en cuenta corriente de "
					+ cuenta.getBalance());
		}
		System.out.println();

		cliente = Banco.getCliente(1);
		cuenta = cliente.getCuenta(0);
		System.out.println("El Cliente [" + cliente.getApellido() + ", "
				+ cliente.getPrimerNombre() + "]"
				+ " tiene un balance en cuenta corriente de "
				+ cuenta.getBalance());
		try {
			System.out.println("Cuenta Corriente [Oscar Toma]: retira 100.00");
			cuenta.retira(100.00);
			System.out
					.println("Cuenta Corriente [Oscar Toma]: deposita 25.00");
			cuenta.deposita(25.00);
			System.out.println("Cuenta Corriente [Oscar Toma]: retira 175.00");
			cuenta.retira(175.00);
		} catch (ExcepcionSobregiro e1) {
			System.out.println("Excepción: " + e1.getMessage() + "   Deficit: "
					+ e1.getDeficit());
		} finally {
			System.out.println("El Cliente [" + cliente.getApellido() + ", "
					+ cliente.getPrimerNombre() + "]"
					+ " tiene un balance en cuenta corriente de "
					+ cuenta.getBalance());
		}
	}
}






