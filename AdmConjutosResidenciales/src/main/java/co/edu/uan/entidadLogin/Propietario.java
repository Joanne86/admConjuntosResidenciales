
package co.edu.uan.entidadLogin;

public class Propietario extends Persona{
	

	

	private int torre;
    private int apartamento;
    
    public Propietario(int documento, String nombre, String telefono, String nacimiento, String correo, Login login) {
		super(documento, nombre, telefono, nacimiento, correo, login);
		// TODO Auto-generated constructor stub
	}

    public int getTorre() {
        return torre;
    }

    public void setTorre(int torre) {
        this.torre = torre;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    
}
