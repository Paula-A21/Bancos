package dominio;

public class CajaDeAhorro extends Cuenta {

	
	private double porcentajeInteres;
	
	public CajaDeAhorro (double bal, double porcentaje) {
		super(bal);
		
		porcentajeInteres = porcentaje;
	}
	
	public double getPorcentajeInteres() {
		return porcentajeInteres;
	}

	public void retira(double cantidad) throws ExcepcionSobregiro {
		
		if (balance < cantidad) {
			throw new ExcepcionSobregiro(balance - cantidad,
					"Fondos insuficientes");
		}
		
		balance = balance - cantidad;
	}
}

	

