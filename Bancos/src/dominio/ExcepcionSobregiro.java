package dominio;

@SuppressWarnings("serial")

public class ExcepcionSobregiro extends Exception {

	private double deficit = 0;
	
	
	
	public ExcepcionSobregiro(double deficit, String mensaje) {
		
		super (mensaje);
		this.deficit = deficit;
	}

	public double getDeficit () {
		
		return deficit;
	}
}
