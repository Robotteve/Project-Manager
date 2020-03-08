/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Erik
 */
public class ProjectPopUpWindowController implements Initializable {

    @FXML
    private ComboBox<String> comboProjectName;

    @FXML
    private ComboBox<String> comboProjectClient;

    @FXML
    private ComboBox<String> comboProjectPrior;

    @FXML
    private TextField textProjectExtra;

    @FXML
    private TextArea textProjectDetails;

    @FXML
    void cancel(/*ActionEvent event*/) {

    }

    @FXML
    void save(/*ActionEvent event*/) {

    }

    private int projectID;

    public void setProject(ProjectInfo prinfo) {
        this.projectID = prinfo.getProjectID();
        comboProjectName.setValue(prinfo.getProjectName());
        comboProjectClient.setValue(prinfo.getProjectClient());
        comboProjectPrior.setValue(prinfo.getProjectPrior());
        textProjectExtra.setText(prinfo.getProjectExtra());
        textProjectDetails.setText(prinfo.getProjectDetails());
    }

    private LoadFromDataBase database;

    public void setDatabase(LoadFromDataBase database) {
        this.database = database;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboProjectPrior.getItems().addAll("1", "2", "3", "4", "5");
    }

}
