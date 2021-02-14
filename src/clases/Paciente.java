package clases;

import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Paciente {

	//Atributos
	private String nombre;
	private String dni;
	private String pass;
	private int edad;
	private String genero;
	private String preguntaSeguridad;
	private String respuesta;
	private ArrayList<Integer> pulsaciones;
	private ArrayList<String> tickets;
	private boolean ambulancia;
	private ArrayList<Boolean> sensores;
	private boolean respiracion;
	private String telefono;
	private String medico;
	private Encargado encargado;

	//Constructor
	public Paciente() {
		
	}
	
	public Paciente(String nombre, String dni, String pass, int edad, String genero, String preguntaSeguridad, String respuesta,
			ArrayList<Integer> pulsaciones, boolean ambulancia, String telefono) {
		this.nombre = nombre;
		this.dni = dni;
		this.pass = pass;
		this.edad = edad;
		this.genero = genero;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuesta = respuesta;
		this.pulsaciones = pulsaciones;
		this.ambulancia = ambulancia;
		this.telefono = telefono;
		sensores = sensoresAleatorios();
		respiracion = true;
		medico = medicoAleatorio();
		tickets = new ArrayList<String>();
		this.encargado = new Encargado();
	}
	
	public boolean isRespiracion() {
		return respiracion;
	}

	public void setRespiracion(boolean respiracion) {
		this.respiracion = respiracion;
	}

	public ArrayList<Boolean> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Boolean> sensores) {
		this.sensores = sensores;
	}

	public Encargado getEncargado() {
		return encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}

	public ArrayList<String> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<String> tickets) {
		this.tickets = tickets;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	public ArrayList<Integer> getPulsaciones() {
		return pulsaciones;
	}

	public void setPulsaciones(ArrayList<Integer> pulsaciones) {
		this.pulsaciones = pulsaciones;
	}
	
	public boolean isAmbulancia() {
		return ambulancia;
	}

	public void setAmbulancia(boolean ambulancia) {
		this.ambulancia = ambulancia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void anadirPulsacion(int pulso) {
		pulsaciones.add(pulso);
	}
	
	public String medicoAleatorio() {
		Medico medico = new Medico();
		Vector<Medico> medicos = medico.recuperarMedicos();
		Random random = new Random();
		return medicos.get(random.nextInt(medicos.size())).getNombre();
	}
	
	public ArrayList<Boolean> sensoresAleatorios(){
		Random random = new Random();
		ArrayList<Boolean> sensores = new ArrayList<Boolean>();
		for(int i = 0; i<5 ; i++) {
			sensores.add(false);
		}
		sensores.set(random.nextInt(sensores.size()), true);
		return sensores;
	}
	
}
