package com.example.keshri_rakesh.pfms;

public class Dataprovider_shares {

    private String sid;
    private String companyname;
    private String holdname;
    private String purchasedate;
    private String no_of_shares;
    private String totalamount;
    private String B_name;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getHoldname() {
        return holdname;
    }

    public void setHoldname(String holdname) {
        this.holdname = holdname;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        this.purchasedate = purchasedate;
    }

    public String getNo_of_shares() {
        return no_of_shares;
    }

    public void setNo_of_shares(String no_of_shares) {
        this.no_of_shares = no_of_shares;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getB_name() {
        return B_name;
    }

    public void setB_name(String b_name) {
        B_name = b_name;
    }

    public Dataprovider_shares(String sid,String cname,String hname,String pdate,String noofshares,String total,String bankname)
    {
        this.sid = sid;
        this.companyname = cname;
        this.holdname = hname;
        this.purchasedate = pdate;
        this.no_of_shares = noofshares;
        this.totalamount = total;
        this.B_name = bankname;
    }
}
