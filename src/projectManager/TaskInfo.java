/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectManager;

/**
 *
 * @author Erik
 */
public class TaskInfo {

    private int taskID;
    private String taskName;
    private String taskProject;
    private String taskDate;
    private String taskDetails;
    private String taskExtra;

    public TaskInfo(int taskID, String taskName, String taskProject, String taskDate, String taskDetails, String taskExtra) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskProject = taskProject;
        this.taskDate = taskDate;
        this.taskDetails = taskDetails;
        this.taskExtra = taskExtra;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskProject() {
        return taskProject;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public String getTaskExtra() {
        return taskExtra;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskProject(String taskProject) {
        this.taskProject = taskProject;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public void setTaskExtra(String taskExtra) {
        this.taskExtra = taskExtra;
    }

}
