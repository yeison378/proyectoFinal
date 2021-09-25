package sample;

import model.Actividades;
import model.Notas;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ServiceNotas {

    /***
     * Atributos
     */
    private ArrayList<Notas> notas;
    private FilePlan file;
    private ArrayList<Actividades> act;

    /***
     * Constructor de la clase
     * @param path direccion
     * @param nombre nombre
     */
    public ServiceNotas(String path, String nombre){
        notas = new ArrayList();
        file = new FilePlan();
        act = new ArrayList();
        file.setPathFile(path);
        file.setNameFile(nombre);
    }

    /***
     * Metodo paracargar los dtaos del arreglo
     * @throws IOException excepcion carga invalida
     * @throws NumberFormatException excepacion formato incorrctro
     * @throws NoSuchElementException excepcion elemnto inexistente
     */
    public void loadDate() throws IOException, NumberFormatException, NoSuchElementException {
        file.openFile();
        String [] content = file.getContentFile();
        for (String redor: content){
            StringTokenizer tokens = new StringTokenizer(redor, ",");
            while (tokens.hasMoreTokens()){
                try {
                    String idMateria =tokens.nextToken();
                    String idActividad = tokens.nextToken();
                    int idEstudiante = Integer.parseInt(tokens.nextToken());
                    double nota = Double.parseDouble(tokens.nextToken());
                    String aux = tokens.nextToken().replace('/','-');
                    LocalDate fechaEntrega = LocalDate.parse(aux);

                    notas.add(new Notas(idMateria, idActividad,idEstudiante,nota,fechaEntrega));
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /***
     * metodo para agregar notas
     * @param nota nota
     * @return verdadero si es posible agregar nota y false si no
     */
    public boolean addNotas(Notas nota){
        if (nota.getIdMateria().equalsIgnoreCase("1")|| nota.getIdMateria().equalsIgnoreCase("2") || nota.getIdMateria().equalsIgnoreCase("3") || nota.getIdMateria().equalsIgnoreCase("4")|| nota.getIdMateria().equals("5") || nota.getIdMateria().equals("6")){
              if (nota.getIdEstudiantes()>=7 && nota.getIdEstudiantes()<=26){
                  if (nota.getNota()>=0 && nota.getNota()<=5){
                      notas.add(nota);
                      return true;
                  }else{
                      System.out.println("Digite una nota correcta");
                  }
              }
            }
//        }
        return false;
    }

    /***
     * Metodo get Nota
     * @return notas
     */
    public ArrayList<Notas> getNotas(){
        return (ArrayList<Notas>) notas.clone();
    }

    /***
     * Metodo para recagr datos en el archivo (persistencia)
     * @throws IOException excepcione por carga de archivo
     */
    public void dumpData() throws IOException {
        file.openFile();
        String [] dump = new String[notas.size()];
        int cont=0;
        for (Notas nota: notas){
            String idMateria = nota.getIdMateria();
            String idActividad = nota.getIdActividad();
            int idEstudiante = nota.getIdEstudiantes();
            double notas = nota.getNota();
            LocalDate fechaEntrega = nota.getFechaEntrega();
            dump[cont++]=idMateria+","+idActividad+","+idEstudiante+","+notas+","+fechaEntrega;
        }
        file.setContentFile(dump);
    }
}
