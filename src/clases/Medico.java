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

public class Medico {
	
	//Atributos
	private String nombre;
	private String pass;
	private String preguntaSeguridad;
	private String respuesta;
	private ArrayList<Paciente> pacientes;
	
	//Constructor
	public Medico() {
		
	}
	
	public Medico(String nombre, String pass, String preguntaSeguridad, String respuesta, ArrayList<Paciente> pacientes) {
		this.nombre = nombre;
		this.pass = pass;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuesta = respuesta;
		this.pacientes = pacientes;
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public void añadirPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}
	
	public Vector<Medico> recuperarMedicos(){
    	Vector<Medico> medicos = new Vector<Medico>();
    	
    	try(Reader reader = new FileReader("Datos.json")){
    		Gson gson = new Gson();
    		Type tipoListaUsuarios = new TypeToken<Vector<Medico>>() {}.getType();
    		medicos = gson.fromJson(reader, tipoListaUsuarios);
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	return medicos;
    }
	
	public void añadirMedico(Medico medico) {
		Vector<Medico> medicos = recuperarMedicos();
		medicos.add(medico);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();		
		try(FileWriter writer = new FileWriter("Datos.json",false)){
			prettyGson.toJson(medicos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void modificarMedico(Vector<Medico> medicos) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();		
		try(FileWriter writer = new FileWriter("Datos.json",false)){
			prettyGson.toJson(medicos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
