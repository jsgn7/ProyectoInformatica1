package clases;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
	private boolean sensorPuerta;
	private boolean sensor1;
	private boolean sensor2;
	private String telefono;
	
	//Constructor
	public Paciente() {
		
	}
	
	public Paciente(String nombre, String dni, String pass, int edad, String genero, String preguntaSeguridad, String respuesta, ArrayList<Integer>pulsaciones, boolean sensorPuerta,
			boolean sensor1, boolean sensor2, String telefono) {
		this.nombre = nombre;
		this.dni = dni;
		this.pass = pass;
		this.edad = edad;
		this.genero = genero;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuesta = respuesta;
		this.pulsaciones = pulsaciones;
		this.sensorPuerta = sensorPuerta;
		this.sensor1 = sensor1;
		this.sensor2 = sensor2;
		this.telefono = telefono;
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

	public boolean isSensorPuerta() {
		return sensorPuerta;
	}

	public void setSensorPuerta(boolean sensorPuerta) {
		this.sensorPuerta = sensorPuerta;
	}

	public boolean isSensor1() {
		return sensor1;
	}

	public void setSensor1(boolean sensor1) {
		this.sensor1 = sensor1;
	}

	public boolean isSensor2() {
		return sensor2;
	}

	public void setSensor2(boolean sensor2) {
		this.sensor2 = sensor2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void añadirPulsacion(int pulso) {
		pulsaciones.add(pulso);
	}
	
	public Vector<Paciente> recuperarPacientes(){
    	Vector<Paciente> pacientes = new Vector<Paciente>();
    	
    	try(Reader reader = new FileReader("pacientes.json")){
    		Gson gson = new Gson();
    		Type tipoListaPacientes = new TypeToken<Vector<Paciente>>() {}.getType();
    		pacientes = gson.fromJson(reader, tipoListaPacientes);
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	return pacientes;
    }
	
	public void añadirPaciente(Paciente paciente) {
		Vector<Paciente> pacientes = recuperarPacientes();
		pacientes.add(paciente);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();		
		try(FileWriter writer = new FileWriter("pacientes.json",false)){
			prettyGson.toJson(pacientes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void modificarPaciente(Vector<Paciente> pacientes) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();		
		try(FileWriter writer = new FileWriter("pacientes.json",false)){
			prettyGson.toJson(pacientes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
}
