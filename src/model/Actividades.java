package model;

import java.time.LocalDate;

public class Actividades {

    /***
     * Atributos
     */
    private String actividad;
    private int porcentaje;
    private String idActividad;
    private String idMateria;
    private LocalDate fecha;
    private String descripcionActividad;

    /***
     * Constructos de clase
     * @param actividad tipo de actividad
     * @param porcentaje porcentaje de la actividad
     * @param idActividad id de la actividad
     * @param idMateria id de la materia
     * @param fecha fecha para entrega del trabajo
     * @param descripcionActividad breve descripcion de la actividad
     */
    public Actividades(String actividad, int porcentaje, String idActividad, String idMateria, LocalDate fecha, String descripcionActividad) {
        this.actividad = actividad;
        this.porcentaje = porcentaje;
        this.idActividad = idActividad;
        this.idMateria = idMateria;
        this.fecha = fecha;
        this.descripcionActividad = descripcionActividad;
    }

    /***
     * Metodo get actividad
     * @return actividad
     */
    public String getActividad() {
        return actividad;
    }

    /***
     * Metodo set actovidad
     * @param actividad actovidad
     */
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    /***
     * Metodo get porcentaje
     * @return porcentaje
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /***
     * Metodo set porcentaje
     * @param porcentaje porcentaje
     */
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    /***
     * Metodo get actividad
     * @return id de la actividad
     */
    public String getIdActividad() {
        return idActividad;
    }

    /***
     * metodo set id de la actividad
     * @param idActividad id de la actovidad
     */
    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    /***
     * Metodo get id de la materia
     * @return id de la materia
     */
    public String getIdMateria() {
        return idMateria;
    }

    /***
     * Metodo set id de la materia
     * @param idMateria id de la materia
     */
    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    /***
     * metodo get fecha
     * @return fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /***
     * metodo set fecha
     * @param fecha fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /***
     * metodo get descripciones
     * @return descripcion
     */
    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    /***
     * metodo set descripcion
     * @param descripcionActividad descricpion actividad
     */
    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    /***
     * Metodo to string
     * @return todo lo que contiene una actividad
     */
    @Override
    public String toString() {
        return "Actividades{" +
                "actividad='" + actividad + '\'' +
                ", porcentaje=" + porcentaje +
                ", idActividad='" + idActividad + '\'' +
                ", idMateria='" + idMateria + '\'' +
                ", fecha=" + fecha +
                ", descripcionActividad='" + descripcionActividad + '\'' +
                '}';
    }
}
