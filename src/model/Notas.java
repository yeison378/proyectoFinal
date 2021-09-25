package model;

import java.time.LocalDate;

public class Notas {

    /***
     * Atributos
     */
    private String idMateria;
    private String idActividad;
    private int idEstudiantes;
    private double nota;
    private LocalDate fechaEntrega;

    /***
     * Constructor de la clase
     * @param idMateria id de la materia
     * @param idActividad id de la actividad
     * @param idEstudiantes id de estudiantes
     * @param nota nota
     * @param fechaEntrega fecha entrega de la actividad
     */
    public Notas(String idMateria, String idActividad, int idEstudiantes, double nota, LocalDate fechaEntrega) {
        this.idMateria = idMateria;
        this.idActividad = idActividad;
        this.idEstudiantes = idEstudiantes;
        this.nota = nota;
        this.fechaEntrega = fechaEntrega;
    }

    /***
     * metodo get id materia
     * @return id de la materia
     */
    public String getIdMateria() {
        return idMateria;
    }

    /***
     * Metodo Set Id de la materia
     * @param idMateria id de la materia
     */
    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    /***
     * Metodo get id de la actividad
     * @return id de la actividad
     */
    public String getIdActividad() {
        return idActividad;
    }

    /***
     * metodo set id de la actividad
     * @param idActividad id de la actividad
     */
    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    /***
     * metodo get id estidiantes
     * @return id estudiantes
     */
    public int getIdEstudiantes() {
        return idEstudiantes;
    }

    /***
     * metodo set id estudiante
     * @param idEstudiantes id del estudiante
     */
    public void setIdEstudiantes(int idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    /***
     * metodo get nota
     * @return nota
     */
    public double getNota() {
        return nota;
    }

    /***
     * metodo set nota
     * @param nota nota
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /***
     * metodo get fecha entrega
     * @return fecha entrega
     */
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    /***
     * metodo set fecha entrega
     * @param fechaEntrega fecha entrega
     */
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /***
     * metodo to string
     * @return todo lo que contiene una nota
     */
    @Override
    public String toString() {
        return "Notas{" +
                "idMateria='" + idMateria + '\'' +
                ", idActividad='" + idActividad + '\'' +
                ", idEstudiantes='" + idEstudiantes + '\'' +
                ", nota=" + nota +
                ", fechaEntrega=" + fechaEntrega +
                '}';
    }
}
