package clases;

import java.util.ArrayList;

public class Usuario {
	
	//Atributos
	
	private String nombreUsuario;
	private String pass;
	private String preguntaSeguridad;
	private String respuesta;
	private String dni;	
	private String nombre;
	private String apellido;
	private int edad;
	private String rol;
	private ArrayList<String> pacientes;
	
	//CONSTRUCTORES
	//Constructor por defecto
	public Usuario() {
		
	}
	//Pacientes
	public Usuario(String nombreUsuario, String pass, String rol, String dni, String nombre, String apellido, int edad,
			String preguntaSeguridad, String respuesta) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.rol = "Paciente";
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuesta = respuesta;		
	}
	
	//Medico
	public Usuario(String nombreUsuario, String pass, String rol, String dni, String nombre, String apellido, int edad,
			String preguntaSeguridad, String respuesta, ArrayList<String> pacientes) {
		this(nombreUsuario,pass,"Medico",dni,nombre,apellido,edad,preguntaSeguridad,respuesta);
		this.pacientes = pacientes;
	}
	
	//METODOS
	
	public ArrayList<String> getPacientes() {
		return pacientes;
	}
	public void setPacientes(ArrayList<String> pacientes) {
		this.pacientes = pacientes;
	}
	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}
	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPass() {
		return pass;
	}
	public void setContrasena(String contrasena) {
		this.pass = contrasena;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}



}
