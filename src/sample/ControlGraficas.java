package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Notas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControlGraficas implements Initializable {

    /***
     * Atributos de la clase
     */
    public ArrayList<Notas> notas;
    private FilePlan file;
    public String id;

    @FXML
    public Label titulo;

    @FXML
    public PieChart grafica;

    @FXML
    public Button cerrar;

    public String idMaterias_;

    /***
     * Metodo para cerrar ventana
     * @param event evento
     */
    @FXML
    void cerrarVentana(ActionEvent event) {
//        promediar();
        Stage stage = (Stage) this.cerrar.getScene().getWindow();
        stage.close();
    }

    /***
     * Este metodo es para iniciar el diagrama de promedio
     * @param bajo la nota mas baja
     * @param alto la nota media
     * @param superior la nota alta
     */
    public void iniciarDiagrama(int bajo, int alto, int superior){
        ObservableList<PieChart.Data>datos = FXCollections.observableArrayList(
                new PieChart.Data("Superior",superior),
                new PieChart.Data("Alto",alto),
                new PieChart.Data("bajo",bajo)

        );
        grafica.setData(datos);
    }

    /***
     *Verificar notas
     */
    public void notas(){
        for (Notas n:notas){
            System.out.println(n.toString());
        }
    }

    /***
     * Metodo para promediar el diagrama
     */
    public void promediar(){
        int superior=0;
        int alto=0;
        int bajo=0;
        for (Notas n:notas){
            if(n.getIdMateria().equalsIgnoreCase(id)){
              if(n.getNota()<3){
                  bajo++;
              } else if (n.getNota()<4){
                  alto++;
              } else {
                  superior++;
                }
            }
        }
        iniciarDiagrama(bajo,alto,superior);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id="";
//        valor();
        ServiceNotas servicen = new ServiceNotas("resources/","notas.csv");
        servicen.getClass().getResourceAsStream("notas.csv");
        try {
            servicen.loadDate();
        } catch (IOException e) {

        }
        notas = servicen.getNotas();
        try {
            servicen.dumpData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        notas();
    }
}
