package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Actividades;
import model.Estudiantes;
import model.Notas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControlEstudinates implements Initializable {

    /***
     * Atributos
     */
    private ArrayList<Estudiantes> estudiantes;
    private FilePlan file;
    public ObservableList<Estudiantes> est;
    private ListaActividades controlLista;

    @FXML
    public TableView<Estudiantes> E_tabla;

    @FXML
    public TableColumn nombre;

    @FXML
    public TableColumn idEstudiante;

    @FXML
    public TextField E_materiaId;

    @FXML
    public TextField E_actividadId;

    @FXML
    public TextField E_estudianteId;

    @FXML
    public TextField E_nota;

    @FXML
    public Button agregar_nota;

    @FXML
    public Button ver_tabla;

    /***
     * Este metodo es utilizado para poder mostrar una tabla
     * @param event es un evento
     */
    @FXML
    public void E_verTabla(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Vista/ListaActividades.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            controlLista = fxmlLoader.getController();
            controlLista.materia.setText("funciona");
            controlLista.agregarTabla();
            Stage stage = new Stage();
            stage.setTitle("actividad");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            System.out.println("panel no encontrado");
        }
    }

    /***
     * Metodo donde muestra la tabla de estudiantes(datos)
     */
    public void tablaEstudiantes(){
        for (Estudiantes es: estudiantes){
            Estudiantes b=es;
            est.add(b);
            E_tabla.setItems(est);
        }
    }

    /***
     * Metodo para poder generar nueva nota
     * @param event evento
     */
    @FXML
    public void nuevaNota(ActionEvent event) {
        ServiceNotas serviceN = new ServiceNotas("resources/","notas.csv");
        serviceN.getClass().getResourceAsStream("notas.csv");
        try {
            serviceN.loadDate();
        } catch (IOException e) {
            System.out.println("Error1");
            e.printStackTrace();
        }
        ArrayList<Notas> notas = serviceN.getNotas();
        System.out.println("Id materia "+E_materiaId.getText());
        System.out.println("Id actovidad "+E_actividadId.getText());
        System.out.println("Id estudiante "+Integer.parseInt(E_estudianteId.getText()));
        System.out.println("Nota "+Double.parseDouble(E_nota.getText()));
        System.out.println(LocalDate.now());
        Notas notes = new Notas(E_materiaId.getText(),E_actividadId.getText(),Integer.parseInt(E_estudianteId.getText()),Double.parseDouble(E_nota.getText()), LocalDate.now());
        serviceN.addNotas(notes);
        try {
            serviceN.dumpData();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        estudiantes = new ArrayList();
        file = new FilePlan();
        ServiceEstudiante servicee = new ServiceEstudiante("resources/","estudiantes.csv");
        servicee.getClass().getResourceAsStream("estudiantes.csv");
        try {
            servicee.loadDate();
        } catch (IOException e) {
            System.out.println("Error");
        }
        estudiantes = servicee.getEstudiantes();
        try {
            servicee.dumpData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        est = FXCollections.observableArrayList();
        this.nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.idEstudiante.setCellValueFactory(new PropertyValueFactory("id"));
    }
}
