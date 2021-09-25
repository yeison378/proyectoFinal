package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.security.Principal;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    /***
     * Atributos de la clase
     */
    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private Button materias,promedios,estudiantes,salir;

    @FXML
    private Button actividad_programacion;

    @FXML
    private Button actividad_calculo;

    @FXML
    private Button actividad_fisica;

    @FXML
    private Button actividad_economia;

    @FXML
    private Button actividad_algebra;

    @FXML
    private Button actividad_electronica;

    @FXML
    private Button lista_programacion;
    @FXML
    private Button lista_calculo;
    @FXML
    private Button lista_fisica;
    @FXML
    private Button lista_economia;
    @FXML
    private Button lista_algebra;
    @FXML
    private Button lista_electronica;

    private Actividad control;
    private ListaActividades controlLista;


 private ControlEstudinates controlEstudinates;


 @FXML
 private Button Pr_actividad_programacion;

    @FXML
    private Button Pr_actividad_calculo;

    @FXML
    private Button Pr_actividad_fisica;

    @FXML
    private Button Pr_actividad_economia;

    @FXML
    private Button Pr_actividad_algebra;

    @FXML
    private Button Pr_actividad_electronica;

    private ControlGraficas controlGraficas;

    /***
     * Metodo para calcular el promedio
     * @param event evento
     */
    @FXML
    void CalcularPromedio(ActionEvent event) {
        Object materia = event.getSource();
        if(materia.equals(Pr_actividad_programacion)){
            mostrarGraficas();
            controlGraficas.titulo.setText("Programacion");
            controlGraficas.id="1";
            controlGraficas.promediar();
        }else if(materia.equals(Pr_actividad_calculo)){
            mostrarGraficas();
            controlGraficas.titulo.setText("Calculo");
            controlGraficas.id="2";
            controlGraficas.promediar();
        }else if(materia.equals(Pr_actividad_fisica)){
            mostrarGraficas();
            controlGraficas.titulo.setText("Fisica");
            controlGraficas.id="3";
            controlGraficas.promediar();
        }else if(materia.equals(Pr_actividad_economia)){
            mostrarGraficas();
            controlGraficas.titulo.setText("Economia");
            controlGraficas.id="4";
            controlGraficas.promediar();
        }else if(materia.equals(Pr_actividad_algebra)){
            mostrarGraficas();
            controlGraficas.titulo.setText("Algebra");
            controlGraficas.id="5";
            controlGraficas.promediar();
        }else if(materia.equals(Pr_actividad_electronica)){
            mostrarGraficas();
            controlGraficas.titulo.setText("Electronica");
            controlGraficas.id="6";
            controlGraficas.promediar();
        }
    }

    /***
     * Metodo para poder mostrar graficas
     */
    public void mostrarGraficas(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Vista/Graficas.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            controlGraficas = fxmlLoader.getController();
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
     * Metodo para poder agregar actividades
     * @param event evento
     */
    @FXML
    void agregarActividad(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Vista/Actividades.fxml"));
            Parent root = (Parent) fxmlLoader.load();

             control = fxmlLoader.getController();
             control.actividad_materia.setText(seleccionActividad(event.getSource()));
            control.idNumeroMateria.setText(seleccionIdActividad(event.getSource()));
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
     * Metodo para generar lista de actividades
     * @param event
     */
    @FXML
    void listadoActividade(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Vista/ListaActividades.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            controlLista = fxmlLoader.getController();
            controlLista.materia.setText(seleccionLista(event.getSource()));
            controlLista.agregarTabla(seleccionListaNumero(event.getSource()));
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
     * Metodo para seleccionar la lista de actividades
     * @param materia materia
     * @return el nombre de la materia
     */
    public String seleccionLista(Object materia){
        if(materia.equals(lista_programacion)){
            return "Programacion";
        }else if(materia.equals(lista_calculo)){
            return "Calculo";
        }else if(materia.equals(lista_fisica)){
            return "Fisica";
        }else if(materia.equals(lista_economia)){
            return "Economia";
        }else if(materia.equals(lista_algebra)){
            return "Algebra";
        }else if(materia.equals(lista_electronica)){
            return "Electronica";
        }
        return "no";
    }

    /***
     * Metodo para seleccionar lista de numeros
     * @param materia materias
     * @return retorna el id de la materia
     */
    public String seleccionListaNumero(Object materia){
        if(materia.equals(lista_programacion)){
            return "1";
        }else if(materia.equals(lista_calculo)){
            return "2";
        }else if(materia.equals(lista_fisica)){
            return "3";
        }else if(materia.equals(lista_economia)){
            return "4";
        }else if(materia.equals(lista_algebra)){
            return "5";
        }else if(materia.equals(lista_electronica)){
            return "6";
        }
        return "no";
    }

    /***
     * Metodo seleccionar actividades
     * @param materia materia
     * @return nombre de la materia
     */
    public String seleccionActividad(Object materia){
        if(materia.equals(actividad_programacion)){
            return "Programacion";
        }else if(materia.equals(actividad_calculo)){
            return "Calculo";
        }else if(materia.equals(actividad_fisica)){
            return "Fisica";
        }else if(materia.equals(actividad_economia)){
            return "Economia";
        }else if(materia.equals(actividad_algebra)){
            return "Algebra";
        }else if(materia.equals(actividad_electronica)){
            return "Electronica";
        }
        return "";
    }

    /***
     * Metodo para seleccionar id de la acrividad
     * @param materia materia
     * @return el id de la materia
     */
    public String seleccionIdActividad(Object materia){
        if(materia.equals(actividad_programacion)){
            return "1";
        }else if(materia.equals(actividad_calculo)){
            return "2";
        }else if(materia.equals(actividad_fisica)){
            return "3";
        }else if(materia.equals(actividad_economia)){
            return "4";
        }else if(materia.equals(actividad_algebra)){
            return "5";
        }else if(materia.equals(actividad_electronica)){
            return "6";
        }
        return "";
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /***
     * Metodo para cambiar panel
     * @param event event
     */
    @FXML
    public void cambiar(ActionEvent event) {
        Object boton = event.getSource();
        if(boton.equals(materias)){
            BotonSetPanel("Materias");
        }else if(boton.equals(promedios)){
            BotonSetPanel("Promedios");
        }else if(boton.equals(estudiantes)){
            BotonSetPanel("Estudiantes");
        }else if(boton.equals(salir)){
            System.exit(0);
        }
    }

    /***
     * Metodo carga el panel estudiantes
     * @throws IOException excepcion por lectura de archivo
     */
    public void panelEstudiantes() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Vista/Estudiantes.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        controlEstudinates= fxmlLoader.getController();
        controlEstudinates.tablaEstudiantes();
        panelPrincipal.setCenter(root);

    }

    /***
     * Metodo para ca,biar el panel
     * @param panel panel
     */
    public void BotonSetPanel(String panel){
        if(panel.equalsIgnoreCase("Estudiantes")){
            System.out.println("entro");
            try {
                panelEstudiantes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../Vista/"+panel+".fxml"));
            }catch (IOException e){

            }
            panelPrincipal.setCenter(root);
        }
    }
}
