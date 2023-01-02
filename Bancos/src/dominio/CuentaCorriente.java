package dominio;

public class CuentaCorriente extends Cuenta {
	
	private double proteccionSobregiro;
	private static final double SIN_PROTECTION = -1.0;
	
	public CuentaCorriente (double bal) {
		super(bal);
		
	}
	
public CuentaCorriente (double b, double proteccion) {
	
	super(b);
	proteccionSobregiro = proteccion;
}

@Override

public void retira(double cantidad) throws ExcepcionSobregiro {
	if (balance < cantidad) {
		// No hay suficiente saldo para el retiro solicitado
		// Verificar que en caso que exista haya suficiente protección de
		// sobregiro
		double sobregiroNecesario = cantidad - balance;
		
		if (proteccionSobregiro == SIN_PROTECTION) {
			// No hay protección de sobregiro
			throw new ExcepcionSobregiro(balance - cantidad,
					"No hay protección por sobregiro");
		
		} else {
			// No hay suficiente protección de giro para la cantidad
			// solicitada
			if (proteccionSobregiro < sobregiroNecesario) {
				
				throw new ExcepcionSobregiro(balance - cantidad,
						"Fondos insuficientes para proteger el sobregiro");
			}

			// Hay suficiente protección de giro para la cantidad solicitada
			// y cubre
			balance = 0.0;
			proteccionSobregiro = proteccionSobregiro - sobregiroNecesario;
		}

	} else {

		// Hay suficiente para la cantidad solicitada
		// Proceder normalmente
		balance = balance - cantidad;
	}

}	
}


















