package model;

public class Materias {

    /***
     * Atributros
     */
    private String materia;
    private String id;

    /***
     * Constructor de la clase
     * @param materia nombre de la materia
     * @param id id de la materia
     */
    public Materias(String materia, String id) {
        this.materia = materia;
        this.id = id;
    }

    /***
     * Metodo get materia
     * @return materia
     */
    public String getMateria() {
        return materia;
    }

    /***
     * metodo set materia
     * @param materia materia
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    /***
     * metodo get id
     * @return id
     */
    public String getId() {
        return id;
    }

    /***
     * metodo set id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /***
     * metodo to string
     * @return materia y id de esta
     */
    @Override
    public String toString() {
        return "Materias{" +
                "materia='" + materia + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
