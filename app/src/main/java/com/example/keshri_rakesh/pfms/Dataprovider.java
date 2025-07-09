package com.example.keshri_rakesh.pfms;

public class Dataprovider {






    //fd chalu
    private String bankid;
    private String b_name;
    private String h_name;
    private String scheme;
    private String amount;
    private String starts;
    private String intttype;
    private String roi;
    private String mdate;



    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getStarts() {
        return starts;
    }

    public void setStarts(String starts) {
        this.starts = starts;
    }

    public String getIntttype() {
        return intttype;
    }

    public void setIntttype(String intttype) {
        this.intttype = intttype;
    }

    public String getRoi() {
        return roi;
    }

    public void setRoi(String roi) {
        this.roi = roi;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    //fd khtam





    public Dataprovider(String bid, String bank, String name, String scheme, String amount, String starts, String inttype, String roi, String mdate)
    {



        //fd chalu
        this.bankid = bid;
        this.b_name = bank;
        this.h_name = name;
        this.scheme = scheme;
        this.amount = amount;
        this.starts = starts;
        this.intttype = inttype;
        this.roi = roi;
        this.mdate = mdate;
        //fd khatam



    }
}
