/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private TextField txProjectAddress;

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
    //Project
    @FXML
    void actionNewProject() throws Exception {
        popUpWindow("New Project", -1);
    }

    @FXML
    void actionEditProject() throws Exception {
        int selectedIndex = tableProjects.getSelectionModel().getSelectedIndex();
        if (selectedIndex > -1) {
            popUpWindow("Edit Project", selectedIndex);
        }
    }

    @FXML
    void actionDeleteProject() {

    }

    //Task
    @FXML
    void actionNewTask() {

    }

    @FXML
    void actionEditTask() {

    }

    @FXML
    void actionDeleteTask() {

    }

    //Projekt adatok kiírása
    //kapott int változó: táblázatban kijelölt sor indexe
    private void textProjectInfo(int i) {
        if (i == -1) {
            return;
        }
        ProjectInfo tx = tableProjects.getItems().get(i);
        txProjectName.setText(tx.getProjectName());
        txProjectPrior.setText(tx.getProjectPrior());
        txProjectAddress.setText(tx.getProjectAddress());
        txProjectExtra.setText(tx.getProjectExtra());
        txProjectDetails.setText(tx.getProjectDetails());
        //kijelölt projekthez tartozó feladatok lekérdezése adatbázisból
        database.loadSelectedProjectTasks(tableTasks.getItems(), tx.getProjectID());
        //projectID lekérése: tx.getProjectID()
    }

    //task adatok kiírása
    private void textTaskInfo(int i) {
        if (i == -1) {
            //Amikor olyan projekt kerül kijelölésre, amihez nem tartozik feladat, a feladat adatok mezői törlődnek
            txTaskName.clear();
            txTaskDate.clear();
            txTaskExtra.clear();
            txTaskDetails.clear();
        }
        TaskInfo tx = tableTasks.getItems().get(i);
        txTaskName.setText(tx.getTaskName());
        txTaskDate.setText(tx.getTaskDate());
        txTaskExtra.setText(tx.getTaskExtra());
        txTaskDetails.setText(tx.getTaskDetails());
    }

    //DataBase osztály példányosítása
    LoadFromDataBase database = new LoadFromDataBase();

    private void popUpWindow(String windowTitle, int selectedIndex) throws Exception {
        //Új ablak betöltése ProjectPopUpWindow.fxml alapján
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProjectPopUpWindow.fxml"));
        Parent root = loader.load();
        //Adatok átadása
        ProjectPopUpWindowController controller = loader.getController();
        if (selectedIndex > -1) {//módosítás esetén
            controller.setProject(tableProjects.getItems().get(selectedIndex));
        } else {//új létrehozásakor
            controller.setProject(new ProjectInfo(0, "", "", "", "", "1", ""));
        }
        controller.setDatabase(database);
        //új ablak megnyitása
        Scene scene = new Scene(root);
        Stage popUpWindow = new Stage();
        popUpWindow.setResizable(false);
        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        popUpWindow.setScene(scene);
        popUpWindow.setTitle(windowTitle);
        popUpWindow.showAndWait();
    }

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
