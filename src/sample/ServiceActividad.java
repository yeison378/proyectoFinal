package sample;

import model.Actividades;
import model.Materias;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ServiceActividad {

    /***
     * Atributos
     */
    private ArrayList<Actividades>actividades;
    private ArrayList<Materias>materia;
    private FilePlan file;

    /***
     * Constructor de la clase
     * @param path camino
     * @param nombre nombre
     */
    public ServiceActividad(String path, String nombre){
       actividades = new ArrayList();
       materia= new ArrayList();
       file = new FilePlan();
       file.setPathFile(path);
       file.setNameFile(nombre);
    }

    /***
     * Metodo para la craga del archivo plano
     * @throws IOException excepcion por carga del archivo
     * @throws NumberFormatException excepcion por formato incorrcto
     * @throws NoSuchElementException excepcion por elemnto inexistente
     */
    public void loadDate() throws IOException, NumberFormatException, NoSuchElementException {
        file.openFile();
        String [] content = file.getContentFile();
        for (String record: content){
            StringTokenizer tokens = new StringTokenizer(record, ",");
            while (tokens.hasMoreTokens()){
                try {
                    String tipoActividad = tokens.nextToken();
                    int porcentaje = Integer.parseInt(tokens.nextToken());
                    String id = tokens.nextToken();
                    String materiaId = tokens.nextToken();
                    String aux = tokens.nextToken().replace('/','_');
                    LocalDate fecha = LocalDate.parse(aux);
                    String descripcion = tokens.nextToken();

                    actividades.add(new Actividades(tipoActividad, porcentaje, id, materiaId, fecha, descripcion));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /***
     * Metodo para encontrar una actividad por medio del Id
     * @param id id
     * @return actividades
     */
    public Actividades findActividad(String id){
        for (Actividades activities: actividades){
            if (activities.getIdActividad().equals(id)){
                return activities;
            }
        }
        return null;
    }

    /***
     * Metodo para mostrar actividad por medio del Id
     * @param id id
     * @return la actividad encontrada
     */
    public String mostrarActividadId(String id){
        if(findActividad(id)==null){
            return "No existe";
        }else{
            return findActividad(id).toString();
        }
    }

    /***
     * Metodo para agregar actividades
     * @param act actividad
     * @return verdaero si es posible agregar la actividad y falso si no
     */
    public boolean addActividad(Actividades act){
        for (Actividades a:actividades){
            System.out.println("Hola");
            if (findActividad(act.getIdActividad())==null){
                System.out.println("como");
                if (act.getIdMateria()=="1"|| act.getIdMateria()=="2" || act.getIdMateria()=="3" || act.getIdMateria()=="4"|| act.getIdMateria()=="5" || act.getIdMateria()=="6") {
                    System.out.println("estas");
                        int aux = act.getPorcentaje();
                        for (Actividades ab:actividades){
                            if (ab.getIdMateria().equals(act.getIdMateria())){
                                aux+=a.getPorcentaje();
                                System.out.println(aux);
                            }
                            if (aux>100){
                                System.out.println("Su porcentaje es mayor ");
                                return false;
                            }else{
                                System.out.println("Su porcjentaje es correcto");
                            }
                        }
                            if (act.getFecha().isAfter(LocalDate.now()) || act.getFecha().isEqual(LocalDate.now())){
                                actividades.add(act);
                                return true;
                            }
                }else{
                    System.out.println("No fue posible");
                }
            }
        }
        return false;
    }

//    Suma porcentajes

    /***
     * Metodo para suma del porcentaje
     * @param b porcentaje
     * @return verdadero si el porcjenate es correcto y si el porcj¿centaje pasa de 100 false
     */
    public boolean porcentaje(int b){
        int aux=b;
        for (Actividades a:actividades){
            aux+=a.getPorcentaje();
            System.out.println(aux);
           if (aux>100){
               System.out.println("Su porcentaje es mayor ");
               return false;
           }else{

           }
        }
        return true;
    }

    /***
     * Metodo para poder verificar materias de la actividad
     * @param b id de la materia
     * @return materia o si no esta null
     */
    public Actividades materias(String b){
        for (Actividades a:actividades){
            if (a.getIdMateria().equals(b)){
                return a;
            }
        }
        return null;
    }

    /***
     * Metodo get activiades
     * @return las actividades
     */
    public ArrayList<Actividades> getActividades(){
        return (ArrayList<Actividades>) actividades.clone();
    }

    /***
     * Metodo para poder actualizar datos en el rachivo (persistencia)
     * @throws IOException excepcion por carga de rachivo
     */
    public void dumpData() throws IOException {
        file.openFile();
        String[] dump = new String[actividades.size()];
        int cont =0;
        for (Actividades activites: actividades){
            String tipoActividad = activites.getActividad();
            int porcentaje = activites.getPorcentaje();
            String idActividad = activites.getIdActividad();
            String idMateria = activites.getIdMateria();
            LocalDate fecha = activites.getFecha();
            String descripcion = activites.getDescripcionActividad();
            dump[cont++]= tipoActividad+","+porcentaje+","+idActividad+","+idMateria+","+fecha+","+descripcion;
        }
        file.setContentFile(dump);
    }
}
