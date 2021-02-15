package clases;

public class Ticket {

public int codigoTicket;

public String DNIpaciente;

public String DNIdoctor;

public String descripcion;

public String respuesta;

public Ticket() {}

public Ticket(int tamanioLista,String DNIpaciente,String DNIdoctor,String descripcion,String respuesta) {

	this.codigoTicket=tamanioLista;
	this.DNIpaciente=DNIpaciente;
	this.DNIdoctor=DNIdoctor;
	this.descripcion=descripcion;
	this.respuesta=respuesta;
}

// este es el Json que se generar� al final
public String toString() {
	String salida="ticket:";
	salida="\ncodigodeTicket"+codigoTicket;
	salida+="\nDNIdepacientet"+DNIpaciente;
	salida+="\nDNIdoctor"+DNIdoctor;
	salida+="\nDescripcion"+descripcion;
	salida+="\nRespuesta"+respuesta;
	salida += "\n";
	return salida;
}


public int getCodigoTicket() {
	return codigoTicket;
}


public void setCodigoTicket(int codigoTicket) {
	this.codigoTicket = codigoTicket;
}


public String getDNIpaciente() {
	return DNIpaciente;
}


public void setDNIpaciente(String dNIpaciente) {
	DNIpaciente = dNIpaciente;
}


public String getDNIdoctor() {
	return DNIdoctor;
}


public void setDNIdoctor(String dNIdoctor) {
	DNIdoctor = dNIdoctor;
}


public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


public String getRespuesta() {
	return respuesta;
}


public void setRespuesta(String respuesta) {
	this.respuesta = respuesta;
}


}
