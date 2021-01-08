package clases;

public class Usuario {
	
public int DNI;	

public String Nombre;

public String Apellido;

public int edad;

public String tipo;

public Usuario() {

DNI=11242;
tipo="Paciente";
Nombre="a";
edad=14;
}

public int getDNI() {
	return DNI;
}

public void setDNI(int dNI) {
	DNI = dNI;
}

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

public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	this.edad = edad;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}



}
