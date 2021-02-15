package clases;

public class Ticket {

public String mensajeMedico;

public String mensajePaciente;

public Ticket() {}

public Ticket(String mensajeMedico, String mensajePaciente) {
	this.mensajeMedico = mensajeMedico;
	this.mensajePaciente = mensajePaciente;
}

public String getMensajeMedico() {
	return mensajeMedico;
}

public void setMensajeMedico(String mensajeMedico) {
	this.mensajeMedico = mensajeMedico;
}

public String getMensajePaciente() {
	return mensajePaciente;
}

public void setMensajePaciente(String mensajePaciente) {
	this.mensajePaciente = mensajePaciente;
}





}
