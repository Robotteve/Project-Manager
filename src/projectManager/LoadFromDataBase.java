/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import panel.Panel;

/**
 *
 * @author Erik
 */
public class LoadFromDataBase {

    final String dataBaseUrl1 = "jdbc:mysql://localhost:3306/";
    final String dataBaseUrl2 = "jdbc:mysql://localhost:3306/projectmanager"
            + "?useUnicode=true&characterEncoding=UTF-8";
    final String datBaseUser = "root";
    final String dataBasePass = "";

    //Projektek adatainak lekérdezése adatbázisból --> ProjectInfo osztály
    public void loadProjects(ObservableList<ProjectInfo> list) {
        /*SELECT clientName, projectName FROM project JOIN client ON project.clientID=client.clientID*/
        String sqlCommand = "SELECT projectID, projectName, clientName, clientAddress, projectDetails, projectPrior, projectExtra "
                + "FROM project JOIN client ON project.clientID=client.clientID ORDER BY clientName;";
        try (Connection connect = DriverManager.getConnection(dataBaseUrl2, datBaseUser, dataBasePass);
                PreparedStatement command = connect.prepareStatement(sqlCommand)) {
            ResultSet result = command.executeQuery();
            list.clear();
            while (result.next()) {
                list.add(new ProjectInfo(
                        //sql lekérdezés eredménye alapján ("fejléc")
                        result.getInt("projectID"),
                        result.getString("projectName"),
                        result.getString("clientName"),
                        result.getString("clientAddress"),
                        result.getString("projectDetails"),
                        result.getString("projectPrior"),
                        result.getString("projectExtra")));
            }
        } catch (SQLException ex) {
            Panel.error("Load projects", ex.getMessage());
        }
    }

    //Kijelölt projekthez tartozó feladatok adatainak lekérdezése adatbázisból --> TaskInfo osztály
    public void loadSelectedProjectTasks(ObservableList<TaskInfo> list, int selectedProjectIndex) {
        String sqlCommand = "SELECT taskID, taskName, projectName, taskDate, taskDetails, taskExtra "
                + "FROM task "
                + "JOIN project ON task.projectID=project.projectID "
                + "WHERE project.projectID=" + selectedProjectIndex + " "
                + "ORDER BY taskDate;";
        try (Connection connect = DriverManager.getConnection(dataBaseUrl2, datBaseUser, dataBasePass);
                PreparedStatement command = connect.prepareStatement(sqlCommand)) {
            ResultSet result = command.executeQuery();
            list.clear();
            while (result.next()) {
                list.add(new TaskInfo(
                        //sql lekérdezés eredménye alapján ("fejléc")
                        result.getInt("taskID"),
                        result.getString("taskName"),
                        result.getString("projectName"),
                        result.getString("taskDate"),
                        result.getString("taskDetails"),
                        result.getString("taskExtra")));
            }
        } catch (SQLException ex) {
            Panel.error("Load tasks", ex.getMessage());
        }
    }

    public LoadFromDataBase() {
        String useDB = "USE projectmanager;";

        try (Connection connect = DriverManager.getConnection(dataBaseUrl1, datBaseUser, dataBasePass);
                PreparedStatement comm1 = connect.prepareStatement(useDB)) {
            comm1.execute();
        } catch (SQLException ex) {
            Panel.error("Use database", ex.getMessage());
        }
    }
}
