package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Actividades;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class ListaActividades implements Initializable {

    /***
     * Atributos
     */
    private ArrayList<Actividades>act;
    private FilePlan file;

    public ObservableList<Actividades> acti;

    @FXML
    public TableView<Actividades> tabla;

    @FXML
    public TableColumn actividad;

    @FXML
    public TableColumn porcentaje;

    @FXML
    public TableColumn id;

    @FXML
    public TableColumn fecha;

    @FXML
    public TableColumn descripcion;

    @FXML
    public TableColumn id_materia;

    @FXML
    public Label materia;

    @FXML
    public Button cerrar;

    /***
     * Metodo para cerrar ventana
     * @param event evento
     */
    @FXML
    void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) this.cerrar.getScene().getWindow();
        stage.close();
    }

    /***
     * Muestra las actividades
     */
    public void muestra(){
        for (Actividades a:act){
            System.out.println(a.toString());
        }
        System.out.println(act.size());
    }

    /***
     * Metodo para poder agregar tabla
     * @param idMateria id de la materia
     */
    public void agregarTabla(String idMateria){
        for (Actividades a:act){
            if (a.getIdMateria().equalsIgnoreCase(idMateria)){
                Actividades b = a;
                acti.add(b);
                tabla.setItems(acti);
            }
        }
    }

    /***
     * Metodo para agregar tabla
     */
    public void agregarTabla(){
        for (Actividades a:act){
                Actividades b = a;
                acti.add(b);
                tabla.setItems(acti);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        act = new ArrayList();
        file = new FilePlan();

        ServiceActividad servicea = new ServiceActividad("resources/","actividades.csv");
        servicea.getClass().getResourceAsStream("actividades.csv");
        try {
            servicea.loadDate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        act =  servicea.getActividades();
        System.out.println(servicea.getActividades());
        System.out.println(servicea.findActividad("1"));
        try {
            servicea.dumpData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        acti = FXCollections.observableArrayList();
        this.actividad.setCellValueFactory(new PropertyValueFactory("actividad"));
        this.porcentaje.setCellValueFactory(new PropertyValueFactory("porcentaje"));
        this.id.setCellValueFactory(new PropertyValueFactory("idActividad"));
        this.fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.descripcion.setCellValueFactory(new PropertyValueFactory("descripcionActividad"));
        this.id_materia.setCellValueFactory(new PropertyValueFactory("idMateria"));
    }

}
