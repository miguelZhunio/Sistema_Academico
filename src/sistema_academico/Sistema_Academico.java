package sistema_academico;

import com.db4o.*;
import java.util.Scanner;

public class Sistema_Academico {

   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String op, auxCedula, ops;
        ObjectContainer Base = Db4o.openFile("//home//vaioz//Documentos//BBDDO/BaseO//Sistema_Academico.yap"); // Abrir base de datos


        System.out.print("BIENVENIDO AL SOFTWARE EDUACATIVO \n"
        + "1. Estudiante \n"
        + "2. Matricula \n"
        + "----> ");
        op = in.next();
        

        if (op.equals("1") || op.equals("2")) {
            System.out.print("Que desea realizar ----> \n"
                    + "1. Crear \n"
                    + "2. Consultar \n"
                    + "3. Modificar \n"
                    + "4. Eliminar \n"
                    + "5. Generar Reporte \n"
                    + "6. Salir \n"
                    + "----> ");
            ops = in.next();
            
            switch(ops) {
                case "1":
                    if (op.equals("1")) {
                        CrudEstudiante.Crear(Base);
                    } else {
                        CrudMatricula.Crear(Base);
                    }
                    
                    break;
                case "2":
                    System.out.print("Ingrese el numero de cedula del estudiante a buscar ---> ");
                    auxCedula = in.next();
                    CrudEstudiante.GenerarReporteConsulta(auxCedula, Base);
                    break;
                case "3":
                    System.out.print("Ingrese el numero de cedula del estudiante a buscar ---> ");
                    auxCedula = in.next();
                    CrudEstudiante.Modificar(auxCedula, Base);
                    break;
                case "4":
                    System.out.print("Ingrese el numero de cedula del estudiante a eliminar---> ");
                    auxCedula = in.next();
                    CrudEstudiante.Eliminar(auxCedula, Base);
                    break;
                case "5":
                    CrudEstudiante.GenerarReporteGeneral(Base);
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("OPCION INVALIDAD");
                    
            }

        }
        
        
                 
        // Buscar_Estudiantes (Base);
        CerrarBBDD(Base);
    }
         
    public static void CerrarBBDD(ObjectContainer base) {
        base.close();         
   }    
}
