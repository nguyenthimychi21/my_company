package com.example.demo.controller.request;

public class UpdateDomainRequest {
    private Long domainId;
    private String name;

    public UpdateDomainRequest(Long domainId, String name) {
        this.domainId = domainId;
        this.name = name;
    }

    public UpdateDomainRequest() {
    }


    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

