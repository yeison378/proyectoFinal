package sample;

import com.sun.prism.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Actividades;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Actividad implements Initializable {

    /***
     * Atributos
     */
    public ServiceActividad sactividades;

    @FXML
    public Label idNumeroMateria;

    @FXML
    public Label actividad_materia;

    @FXML
    public TextField actividad;

    @FXML
    public TextField porcentaje;

    @FXML
    public DatePicker fecha;

    @FXML
    public Button aceptar;

    @FXML
    public Button cancelar;

    @FXML
    public TextArea descripcion;

//    @FXML
//    public TextField id;

    /***
     * Metodo para poder crera una nueva actividad
     * @param event evento
     */
    @FXML
    void traertexto(ActionEvent event) {
        Object accion = event.getSource();
        if(accion.equals(aceptar)){

            ServiceActividad servicea = new ServiceActividad("resources/","actividades.csv");
            servicea.getClass().getResourceAsStream("actividades.csv");
            try {
                servicea.loadDate();
            } catch (IOException e) {
                System.out.println("Error");
            }
            ArrayList<Actividades> act =  servicea.getActividades();
            int idA = (int) ((Math.random()*100)+20);
            String actividad_ = actividad.getText();
            int porcentaje_ = Integer.valueOf(porcentaje.getText());
            String idActividad_ = idA+"";
            String idMateria_ = idNumeroMateria.getText();
            LocalDate fecha_ = fecha.getValue();
            String descripcion_ = descripcion.getText();
//            Actividades activites = new Actividades("taller",25, "45","6",LocalDate.now(),"Muy buena alternativca");
            Actividades activites = new Actividades(actividad_,porcentaje_, idActividad_,idMateria_,fecha_,descripcion_);
            System.out.println(idMateria_);
            servicea.addActividad(activites);
            try {
                servicea.dumpData();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage stage = (Stage) this.cancelar.getScene().getWindow();
            stage.close();
        }else {

            Stage stage = (Stage) this.cancelar.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
