package com.example.demo.controller.request;

public class CreateCompanyRequest {

    private Long companyId;

    private Long domainId;

    private String url;

    private int phone;

    public CreateCompanyRequest() {
    }

    public CreateCompanyRequest(Long companyId, Long domainId, String url, int phone) {
        this.companyId = companyId;
        this.domainId = domainId;
        this.url = url;
        this.phone = phone;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
