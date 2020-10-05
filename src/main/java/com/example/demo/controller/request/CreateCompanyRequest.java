package com.example.demo.controller.request;


import com.example.demo.entity.Domain;

public class CreateCompanyRequest {

    public CreateCompanyRequest(Domain domain) {
        this.setDomain(domain);
    }

    private Domain domain;


    private String url;

    private int phone;


    public CreateCompanyRequest(Long companyId, String url, int phone) {


        this.setUrl(url);
        this.setPhone(phone);
    }

    public CreateCompanyRequest() {
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

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
