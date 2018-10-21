package co.edu.uan.entidad;

public abstract class Persona {

    private String documento;
    private String nombre;
    private String telefono;
    private String nacimiento;
    private String correo;
    private Login login;

    public Persona(String documento, String nombre, String telefono, String nacimiento, String correo, Login login) {
        super();
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.correo = correo;
        this.login = login;
    }

	public Persona(String documento, String nombre, String correo, Login login) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.correo = correo;
		this.login = login;
	}

    public Persona() {
    }
    

    public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }



}
