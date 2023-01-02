package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Banco {

 private static List<Cliente> clientes;


 public Banco() {
	 
 }
 
public static void ordenarClientes (){
	 
	 Collections.sort(clientes);
 }
 
 static {
	 clientes = new ArrayList<Cliente>(10);
 }

 public static void agregaCliente(String nombre, String apellido) {
	 
	 clientes.add(new Cliente (nombre, apellido));
 }
 
 public static Cliente getCliente(int indiceCliente) {
   
	return clientes.get(indiceCliente);
 }
 
 public static int getNumeroDeClientes () {
	  
	 return clientes.size();
 }

}