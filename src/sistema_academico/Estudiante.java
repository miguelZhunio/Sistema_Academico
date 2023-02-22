package sistema_academico;


public class Estudiante {
    
    private String cedula_est;
    private String nombre_est;
    private String apellido_est;
    private int edad_est;
    private String correo_est;
    private String direccion;

    public Estudiante() {
    
    }

    public Estudiante(String cedula_est, String nombre_est, String apellido_est, int edad_est, String correo_est, String direccion) {
        this.cedula_est = cedula_est;
        this.nombre_est = nombre_est;
        this.apellido_est = apellido_est;
        this.edad_est = edad_est;
        this.correo_est = correo_est;
        this.direccion = direccion;
    }

    public String getCedula_est() {
        return cedula_est;
    }

    public void setCedula_est(String cedula_est) {
        this.cedula_est = cedula_est;
    }

    public String getNombre_est() {
        return nombre_est;
    }

    public void setNombre_est(String nombre_est) {
        this.nombre_est = nombre_est;
    }

    public String getApellido_est() {
        return apellido_est;
    }

    public void setApellido_est(String apellido_est) {
        this.apellido_est = apellido_est;
    }

    public int getEdad_est() {
        return edad_est;
    }

    public void setEdad_est(int edad_est) {
        this.edad_est = edad_est;
    }

    public String getCorreo_est() {
        return correo_est;
    }

    public void setCorreo_est(String correo_est) {
        this.correo_est = correo_est;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "cedula_est=" + cedula_est + ", nombre_est=" + nombre_est + ", apellido_est=" + apellido_est + ", edad_est=" + edad_est + ", correo_est=" + correo_est + ", direccion=" + direccion + '}';
    }
    
    
    
}
