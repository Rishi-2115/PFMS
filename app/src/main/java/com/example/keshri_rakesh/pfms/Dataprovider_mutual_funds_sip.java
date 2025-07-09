package com.example.keshri_rakesh.pfms;

public class Dataprovider_mutual_funds_sip {

private String comnane;
private String folionum;
private String sdate;
private String todate;
private String amt;
private String freq;
private String hold;
private String bname;
private String noofunits;
private String add;
private String plan;
private String nav;
private String rate;


    public String getComnane() {
        return comnane;
    }

    public void setComnane(String comnane) {
        this.comnane = comnane;
    }

    public String getFolionum() {
        return folionum;
    }

    public void setFolionum(String folionum) {
        this.folionum = folionum;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getNoofunits() {
        return noofunits;
    }

    public void setNoofunits(String noofunits) {
        this.noofunits = noofunits;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Dataprovider_mutual_funds_sip(String compname,String folio,String starts,String tdate,String amount,String frequency,String holdername,String bank,String units,String address,String planname,String navv,String ratee)
    {
        this.comnane = compname;
        this.folionum = folio;
        this.sdate = starts;
        this.todate = tdate;
        this.amt = amount;
        this.freq = frequency;
        this.hold = holdername;
        this.bname = bank;
        this.noofunits = units;
        this.add = address;
        this.plan = planname;
        this.nav = navv;
        this.rate = ratee;
    }
}
