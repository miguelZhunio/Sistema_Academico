package sistema_academico;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static sistema_academico.CrudEstudiante.ConsultarExistencia;

public class CrudMatricula {
    private static final Scanner in = new Scanner(System.in);
    private static String auxCodigo, auxCiclo, option = "0", auxCedula;
    private static boolean error = false;
    private static Estudiante est_matriculado;
    private static ArrayList<String> auxMaterias;
    private static Date fecha_matr;
    private static int opInt;
    
    public static void Crear(ObjectContainer base){
        Matricula nuevaMatricula;
       
        System.out.print("Ingrese el codigo de la matricula ----> ");
        auxCodigo = in.nextLine();
        if (!(ConsultarExistencia(auxCodigo, base))) {
            JOptionPane.showMessageDialog(null, "MATRICULA CON CODIGO " + auxCodigo + " ya existe");
            error = true;     
        }
        System.out.print("Ingrese el nombre del estudiante ----> ");
        auxCedula = in.nextLine();
        if (CrudEstudiante.ConsultarExistencia(auxCedula, base)) {
            error = true;
        } else {
            ObjectSet busquedad = base.get(new Estudiante(auxCedula, null, null, 0, null, null)); // Buscar estudiante
            est_matriculado = (Estudiante) busquedad.next();
        }
        
        if (!error) {
            System.out.print("Ingrese el ciclo ----> ");
            auxCiclo = in.next();
            for (int i = 0; i < Materias.Materia.length; i++) {
                System.out.println((i+1) + Materias.Materia[i]);
            }
            System.out.println("Escoga la materia");
            do {
                do {
                    System.out.println("---> ");
                    option = in.next();
                    error = option.matches("[1-4]");
                } while (!error);
                opInt = Integer.valueOf(option);
                auxMaterias.add(Materias.Materia[opInt-1]); 
                System.out.print("Otra materia ---> (1. SI , 2. NO)");
                option = in.next();
            } while (option.equals("1"));
            fecha_matr = new Date();
            nuevaMatricula = new Matricula(auxCodigo, est_matriculado, fecha_matr , auxMaterias, auxCiclo); 
            base.set(nuevaMatricula);
            JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
                
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR LA MATRICULA EXITOSAMENTE");
        }
            
        
    } 
   
    
    
}
