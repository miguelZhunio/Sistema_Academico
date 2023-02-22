package sistema_academico;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CrudEstudiante {
    private static final Scanner in = new Scanner(System.in);
    private static String auxCedula, auxNombre, auxApellido, auxCorreo, auxDireccion, option = "0";
    private static int auxEdad;
    
    public static void Crear(ObjectContainer base){
        Estudiante estudiante;
       
        System.out.print("Ingrese la cedula del estudiante ----> ");
        auxCedula = in.nextLine();
        if (ConsultarExistencia(auxCedula, base)) {
            System.out.print("Ingrese el nombre del estudiante ----> ");
            auxNombre = in.nextLine();
            System.out.print("Ingrese el apellido del estudiante ----> ");
            auxApellido = in.nextLine();
            System.out.print("Ingrese la edad del estudiante ----> ");
            auxEdad = in.nextInt();
            System.out.print("Ingrese el correo del estudiante ----> ");
            auxCorreo = in.next();
            System.out.print("Ingrese la direccion del estudiante ----> ");
            auxDireccion = in.next();

            estudiante = new Estudiante(auxCedula, auxNombre, auxApellido, auxEdad, auxCorreo, auxDireccion); 

            base.set(estudiante);
            
            JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante con la cedula " + auxCedula + " ya existe");
        }
        
        
    }
    
    public static boolean ConsultarExistencia(String cedula, ObjectContainer base) {
        
        ObjectSet consulta = base.get(new Estudiante(cedula, null, null, 0, null, null));
        
        return consulta.isEmpty(); // true si esta vacio y flase si no esta vacio.
    }
    public static void GenerarReporteConsulta(String cedula, ObjectContainer base) {
        
        ObjectSet busquedad = base.get(new Estudiante(cedula, null, null, 0, null, null));
        
        if (busquedad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ESTUDIANTE CON CEDULA " + cedula + " NO EXISTE");
        } else {
            while(busquedad.hasNext()) {
                System.out.println(busquedad.next());
            }           
        }
        
    }
    
    public static void GenerarReporteGeneral(ObjectContainer base) {
        ObjectSet busquedad = base.get(new Estudiante(null, null, null, 0, null, null));
        
        if (busquedad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO EXISTEN ESTUDIANTES ");
        } else {
            while(busquedad.hasNext()) {
                System.out.println(busquedad.next());
            }           
        }     
        
    }
    public static void Modificar(String cedula, ObjectContainer base) {
        ObjectSet busquedad = base.get(new Estudiante(cedula, null, null, 0, null, null));

        if (busquedad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO EXISTEN ESTUDIANTES ");
        } else {
            Estudiante est_modificar = (Estudiante) busquedad.next();     
            System.out.print("Ingrese el nuevo nombre ---> ");
            auxNombre = in.next();
            est_modificar.setNombre_est(auxNombre);
            base.set(est_modificar);
            System.out.println(est_modificar.toString());
            JOptionPane.showMessageDialog(null, "SE CAMBIO EL NOMBRE EXITOSAMENTE");
        } 
        
    }
    
    public static void Eliminar(String cedula, ObjectContainer base) {
        ObjectSet busquedad = base.get(new Estudiante(cedula, null, null, 0, null, null));
        if (busquedad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "SE ELIMINO EXITOSAMENTE");
        } else {
            Estudiante est_eliminar = (Estudiante) busquedad.next();
            System.out.println(est_eliminar.toString());
            System.out.print("Desea eliminarlo ---> (1. SI/ 2. NO)");
            option = in.next();
            if (option.equals("1")) {
                base.delete(est_eliminar);
                JOptionPane.showMessageDialog(null, "SE ELIMINO EXITOSAMENTE");
            
            } else {
                JOptionPane.showMessageDialog(null, "SE CANCELO EXITOSAMENTE");

            }
            
        }
    }
    
    
    
    
    
}
