package clases;

public class Ticket {

public String codigoTicket;

public String DNIpaciente;

public String DNIdoctor;

public String descripcion;

public String respuesta;




public Ticket(String codigoTicket,String DNIpaciente,String DNIdoctor,String descripcion,String respuesta) {

	this.codigoTicket=codigoTicket;
	this.DNIpaciente=DNIpaciente;
	this.DNIdoctor=DNIdoctor;
	this.descripcion=descripcion;
	this.respuesta=respuesta;

}


public String getCodigoTicket() {
	return codigoTicket;
}


public void setCodigoTicket(String codigoTicket) {
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
