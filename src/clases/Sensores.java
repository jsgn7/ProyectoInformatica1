package clases;

public class Sensores {

	public String Nombre;
	public String Apellido;
	public int telefono;
	public boolean sensores;
	public boolean sensores2;
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public boolean isSensores() {
		return sensores;
	}
	public void setSensores(boolean sensores) {
		this.sensores = sensores;
	}
	public boolean isSensores2() {
		return sensores2;
	}
	public void setSensores2(boolean sensores2) {
		this.sensores2 = sensores2;
	}
	public Sensores(String nombre, String apellido, int telefono, boolean sensores, boolean sensores2) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		this.telefono = telefono;
		this.sensores = sensores;
		this.sensores2 = sensores2;
	}
	public Sensores() {
		super();
	}
	
	
}
