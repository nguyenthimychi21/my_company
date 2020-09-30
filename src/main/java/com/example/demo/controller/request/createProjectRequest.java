package com.example.demo.controller.request;

public class createProjectRequest {
    private Long projectId;

    private String name;

    private String status;

    private String descriptions;

    public createProjectRequest() {
    }

    public createProjectRequest(Long projectId, String name, String status, String descriptions) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.descriptions = descriptions;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
