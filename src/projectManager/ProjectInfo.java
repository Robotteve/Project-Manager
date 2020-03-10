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
public class ProjectInfo {

    private int projectID;
    private String projectName;
    private String projectClient;
    private String projectAddress;
    private String projectDetails;
    private String projectPrior;
    private String projectExtra;

    public ProjectInfo(int projectID, String projectName, String projectClient, String projectAddress, String projectDetails, String projectPrior, String projectExtra) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectClient = projectClient;
        this.projectAddress = projectAddress;
        this.projectDetails = projectDetails;
        this.projectPrior = projectPrior;
        this.projectExtra = projectExtra;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectClient() {
        return projectClient;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public String getProjectPrior() {
        return projectPrior;
    }

    public String getProjectExtra() {
        return projectExtra;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectClient(String projectClient) {
        this.projectClient = projectClient;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public void setProjectPrior(String projectPrior) {
        this.projectPrior = projectPrior;
    }

    public void setProjectExtra(String projectExtra) {
        this.projectExtra = projectExtra;
    }

}
