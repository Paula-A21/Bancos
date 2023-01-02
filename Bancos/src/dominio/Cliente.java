package dominio;

import java.util.List;
import java.util.ArrayList;

public class Cliente implements Comparable<Cliente> {

	  
	  private String  primerNombre;
	  private String  apellido;
	  private List<Cuenta> cuentas;

	  public Cliente(String pn, String a) {
		  
		  cuentas = new ArrayList<Cuenta>();
		  primerNombre = pn;
		  apellido = a;
	  }

	  public String getPrimerNombre() {
	    return primerNombre;
	  }
	  
	  public String getApellido() {
	    return apellido;
	  }
	  
	  public void agregaCuenta(Cuenta cta) {
			cuentas.add(cta);
	  }
	  
	  public Cuenta getCuenta(int indice_cuenta) {
			return cuentas.get(indice_cuenta);
	  }

	  public int getNumeroDeCuentas() {
			return cuentas.size();
	  }
		
	  @Override
	  public int compareTo(Cliente otroCliente) {
		  
		  int comparacion = 0;
		  
		  comparacion = this.apellido.compareTo(otroCliente.apellido);

		  if (comparacion == 0 ) {
			  comparacion = this.primerNombre.compareTo(otroCliente.primerNombre);
		  } 
		  
		  return comparacion;
	  }
}


