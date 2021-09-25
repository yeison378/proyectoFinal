package sample;



import model.Materias;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ServiceMaterias {

    /***
     * Atributos
     */
    private ArrayList<Materias>materias;
    private FilePlan file;

    /***
     * Constructos de la clase
     * @param path direccion
     * @param nombre nombre
     */
    public ServiceMaterias(String path, String nombre){
        materias = new ArrayList();
        file = new FilePlan();
        file.setPathFile(path);
        file.setNameFile(nombre);
    }

    /***
     * Metodo para cargar datos en el arrgelo
     * @throws IOException excepacion por carga de archivos
     * @throws NumberFormatException excepacion por fomrato incorrecto
     * @throws NoSuchElementException excepcion por elemnto inexistente
     */
    public void loadDate() throws IOException, NumberFormatException, NoSuchElementException {
        file.openFile();
        String [] content = file.getContentFile();
        for (String record: content){
            StringTokenizer tokens = new StringTokenizer(record, ",");
            while (tokens.hasMoreTokens()){
                try {
                    String nombre = tokens.nextToken();
                    String id= tokens.nextToken();

                    materias.add(new Materias(nombre,id));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    Mirar si ya esta una materia por medio de su Id

    /***
     * Metodo para mirar si ya se encuentra una materia por medio de su id
     * @param id id
     * @return la materia y si no esta null
     */
    public Materias findMaterias(String id){
        for (Materias subjects: materias){
            if (subjects.getId().equals(id)){
                return subjects;
            }
        }
        return null;
    }
//    Mostrar materia por medio de Id

    /***
     * Metodo para poder mostrar materia por medio del id
     * @param id id
     * @return si existe la materia esta de lo contrario no existe
     */
    public String mostrarMateriaId(String id){
        if (findMaterias(id)==null){
            return "No existe";
        }else{
            return findMaterias(id).toString();
        }
    }

    /***
     * Metodo get Materia
     * @return materia
     */
    public ArrayList<Materias> getMaterias(){
        return (ArrayList<Materias>) materias.clone();
    }

    /***
     * Metodo para cargar los datos en el archivo plano(persistencia)
     * @throws IOException excepcion carrga invalida
     */
    public void dumpData() throws IOException {
        file.openFile();
        String[] dump = new String[materias.size()];
        int cont=0;
        for (Materias subject: materias){
            String nombre = subject.getMateria();
            String id = subject.getId();
            dump[cont++]= nombre+","+id;
        }
        file.setContentFile(dump);
    }

}
