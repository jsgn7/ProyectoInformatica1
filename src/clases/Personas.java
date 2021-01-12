package clases;

public class Personas {
	
	public String Nombre;
	public String Apellido;
	public int DNI;	
	public int telefono;
	public boolean sensor;
	
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	public int getDNI() {
		return DNI;
	}
	
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public boolean isSensor() {
		return sensor;
	}
	
	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}

	public Personas(String nombre, String apellido, int dNI, int telefono, boolean sensor) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
		this.telefono = telefono;
		this.sensor = sensor;
	}

	public Personas() {
		super();
	}
	



}
