package com.example.keshri_rakesh.pfms;

public class Dataprovider_mutual_funds_lumsum {

    private String companyname;
    private String foliono;
    private String amount;

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getFoliono() {
        return foliono;
    }

    public void setFoliono(String foliono) {
        this.foliono = foliono;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public  Dataprovider_mutual_funds_lumsum(String cname,String folionumber,String amt)
    {
        this.companyname = cname;
        this.foliono = folionumber;
        this.amount = amt;
    }
}
