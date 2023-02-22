package sistema_academico;

import java.util.ArrayList;
import java.util.Date;

public class Matricula {
    private String codigo_matr;
    private Estudiante est_matr;
    private Date fecha_matr;
    private ArrayList<String> Materias_matr;
    private String ciclo;

    public Matricula() {
        
    }

    public Matricula(String codigo_matr, Estudiante est_matr, Date fecha_matr, ArrayList<String> Materias_matr, String ciclo) {
        this.codigo_matr = codigo_matr;
        this.est_matr = est_matr;
        this.fecha_matr = fecha_matr;
        this.Materias_matr = Materias_matr;
        this.ciclo = ciclo;
    }

    
    public String getCodigo_matr() {
        return codigo_matr;
    }

    public void setCodigo_matr(String codigo_matr) {
        this.codigo_matr = codigo_matr;
    }

    public Estudiante getEst_matr() {
        return est_matr;
    }

    public void setEst_matr(Estudiante est_matr) {
        this.est_matr = est_matr;
    }

    public Date getFecha_matr() {
        return fecha_matr;
    }

    public void setFecha_matr(Date fecha_matr) {
        this.fecha_matr = fecha_matr;
    }

    public ArrayList<String> getMaterias_matr() {
        return Materias_matr;
    }

    public void setMaterias_matr(ArrayList<String> Materias_matr) {
        this.Materias_matr = Materias_matr;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigo_matr=" + codigo_matr + ", est_matr=" + est_matr + ", fecha_matr=" + fecha_matr + ", Materias_matr=" + Materias_matr + ", ciclo=" + ciclo + '}';
    }
    
}
