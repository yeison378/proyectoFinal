package sample;

import model.Estudiantes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ServiceEstudiante {

    /***
     * Atributos
     */
    private ArrayList<Estudiantes>estudiantes;
    private FilePlan file;

    /***
     * Constructor de la calse
     * @param path direccion
     * @param nombre nombre
     */
    public ServiceEstudiante(String path, String nombre){
        estudiantes = new ArrayList();
        file = new FilePlan();
        file.setPathFile(path);
        file.setNameFile(nombre);
    }

    /***
     * Metodo para poder cargar datos en el arrgelo
     * @throws IOException excepcion por crag de archivo
     * @throws NumberFormatException excepacion formato incorrceto
     * @throws NoSuchElementException excepcion elemento inexistente
     */
    public void loadDate() throws IOException, NumberFormatException, NoSuchElementException {
        file.openFile();
        String [] content = file.getContentFile();
        for (String record: content){
            StringTokenizer tokens = new StringTokenizer(record,",");
            while (tokens.hasMoreTokens()){
                try {
                    String nombre = tokens.nextToken();
                    int id = Integer.parseInt(tokens.nextToken());

                    estudiantes.add(new Estudiantes(nombre,id));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    Metodo para buscar estudiante por medio de su Id

    /***
     * Metodo para buscar estudiantes por medio del Id
     * @param id id
     * @return si se encuentra el estudiante devuelve este de lo contrario null
     */
    public Estudiantes findEstudiante(int id){
        for (Estudiantes students: estudiantes){
            if (students.getId()==id){
                return students;
            }
        }
        return null;
    }

//    Metodo para mostrar estudiante por medio del Id

    /***
     * Metodo para poder mostrar estudiantes por medio del Id
     * @param id id
     * @return estudiando si este extiste de lo contrario no existe
     */
    public String mostrarEstudianteId(int id){
        if (findEstudiante(id)==null){
            return "No existe";
        }else{
            return findEstudiante(id).toString();
        }
    }

    /***
     * Metodo get estudiantes
     * @return estudiantes
     */
    public ArrayList<Estudiantes> getEstudiantes(){
        return (ArrayList<Estudiantes>) estudiantes.clone();
    }

    /***
     * Metodo para poder actualizar el archivo (persistencia)
     * @throws IOException excepcion por carga de archivos
     */
    public void dumpData() throws IOException {
        file.openFile();
        String [] dump = new String[estudiantes.size()];
        int cont=0;
        for (Estudiantes students: estudiantes){
            String nombre = students.getNombre();
            int id = students.getId();

            dump[cont++]=nombre+","+id;
        }
        file.setContentFile(dump);
    }

}
