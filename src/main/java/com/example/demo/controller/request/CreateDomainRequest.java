package com.example.demo.controller.request;

public class CreateDomainRequest {
    private Long domainId;
    private String name;

    public CreateDomainRequest(Long domainId, String name) {
        this.domainId = domainId;
        this.name = name;
    }

    public CreateDomainRequest() {
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
