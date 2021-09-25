package model;

public class Estudiantes {

    /***
     * Atributos
     */
    private String nombre;
    private int id;

    /***
     * Constructor de la clase
     * @param nombre nombre del estudiante
     * @param id id del estudiante
     */
    public Estudiantes(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    /***
     * metodo get nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * metodo set nombre
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * metodo get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /***
     * metodo set id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * metodo to string
     * @return estidiante y id
     */
    @Override
    public String toString() {
        return "Estudiantes{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
