/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Erik
 */
public class FXMLDocumentController implements Initializable {

    //Project táblázat
    @FXML
    private TableView<ProjectInfo> tableProjects;

    @FXML
    private TableColumn<ProjectInfo, String> colClient;

    @FXML
    private TableColumn<ProjectInfo, String> colProjects;

    //Task táblázat
    @FXML
    private TableView<TaskInfo> tableTasks;

    @FXML
    private TableColumn<TaskInfo, String> colTask;

    @FXML
    private TableColumn<TaskInfo, String> colDate;

    //Project szövegek és gombok
    @FXML
    private TextField txProjectName;

    @FXML
    private TextField txProjectPrior;

    @FXML
    private TextField txProjectExtra;

    @FXML
    private TextArea txProjectDetails;

    @FXML
    private Button buttonEditProject;

    @FXML
    private Button buttonNewProject;

    @FXML
    private Button buttonDeleteProject;

    //Task szövegek és gombok
    @FXML
    private TextField txTaskName;

    @FXML
    private TextField txTaskDate;

    @FXML
    private TextField txTaskExtra;

    @FXML
    private TextArea txTaskDetails;

    @FXML
    private Button buttonEditTask;

    @FXML
    private Button buttonNewTask;

    @FXML
    private Button buttonDeleteTask;

    //Gombok metódusai
    @FXML
    void actionDeleteProject(/*ActionEvent event*/) {

    }

    @FXML
    void actionDeleteTask(/*ActionEvent event*/) {

    }

    @FXML
    void actionEditProject(/*ActionEvent event*/) {

    }

    @FXML
    void actionEditTask(/*ActionEvent event*/) {

    }

    @FXML
    void actionNewProject(/*ActionEvent event*/) {

    }

    @FXML
    void actionNewTask(/*ActionEvent event*/) {

    }

    //változó kijelölt projeck indexéhez
    private int selectedProjectIndex;

    //Projekt adatok kiírása
    //kapott int változó: táblázatban kijelölt sor indexe
    private void textProjectInfo(int i) {
        if (i == -1) {
            return;
        }
        ProjectInfo tx = tableProjects.getItems().get(i);
        txProjectName.setText(tx.getProjectName());
        txProjectPrior.setText(tx.getProjectPrior());
        txProjectExtra.setText(tx.getProjectExtra());
        txProjectDetails.setText(tx.getProjectDetails());
        //kijelölt projektindex
        selectedProjectIndex=tx.getProjectID();
        database.loadSelectedProjectTasks(tableTasks.getItems(), tx.getProjectID());
        //projectID lekérése: tx.getProjectID()
    }
    
    //task adatok kiírása
    private void textTaskInfo(int i) {
        if (i == -1) {
            return;
        }
        TaskInfo tx = tableTasks.getItems().get(i);
        txTaskName.setText(tx.getTaskName());
        txTaskDate.setText(tx.getTaskDate());
        txTaskExtra.setText(tx.getTaskExtra());
        txTaskDetails.setText(tx.getTaskDetails());
    }

    //DataBase osztály példányosítása
    LoadFromDataBase database = new LoadFromDataBase();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Project áblázat oszlopaihoz rendelt mezők (ProjectInfo osztály)
        colProjects.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        colClient.setCellValueFactory(new PropertyValueFactory<>("projectClient"));
        //Task táblázat oszlopaihoz rendelt mezők (TaskInfo osztály)
        colTask.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("taskDate"));
        //load(betöltés) metódusok (LoadFromDataBase osztályban) meghívása
        database.loadProjects(tableProjects.getItems());

        //Project táblázat kijelölés figyelése
        tableProjects.getSelectionModel().selectedIndexProperty()
                .addListener((o, regi, uj) -> textProjectInfo(uj.intValue()));
        //Task táblázat kijelölés figyelése
        tableTasks.getSelectionModel().selectedIndexProperty()
                .addListener((o, regi, uj) -> textTaskInfo(uj.intValue()));
    }

}