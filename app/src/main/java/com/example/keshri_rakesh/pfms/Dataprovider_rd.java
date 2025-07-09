package com.example.keshri_rakesh.pfms;

public class Dataprovider_rd {

    private String accno1;
    private String nameholder1;
    private String roi1;
    private String monthlyamt1;
    private String sdate1;
    private String edate1;
    private String postadd1;

    public String getAccno1() {
        return accno1;
    }

    public void setAccno1(String accno1) {
        this.accno1 = accno1;
    }

    public String getNameholder1() {
        return nameholder1;
    }

    public void setNameholder1(String nameholder1) {
        this.nameholder1 = nameholder1;
    }

    public String getRoi1() {
        return roi1;
    }

    public void setRoi1(String roi1) {
        this.roi1 = roi1;
    }

    public String getMonthlyamt1() {
        return monthlyamt1;
    }

    public void setMonthlyamt1(String monthlyamt1) {
        this.monthlyamt1 = monthlyamt1;
    }

    public String getSdate1() {
        return sdate1;
    }

    public void setSdate1(String sdate1) {
        this.sdate1 = sdate1;
    }

    public String getEdate1() {
        return edate1;
    }

    public void setEdate1(String edate1) {
        this.edate1 = edate1;
    }

    public String getPostadd1() {
        return postadd1;
    }

    public void setPostadd1(String postadd1) {
        this.postadd1 = postadd1;
    }

    public Dataprovider_rd(String accno2,String holder2,String roi2,String ma2,String sdate2,String edate2,String postadd2)
    {
        this.accno1 = accno2;
        this.nameholder1 = holder2;
        this.roi1 = roi2;
        this.monthlyamt1 = ma2;
        this.sdate1 = sdate2;
        this.edate1 = edate2;
        this.postadd1 = postadd2;
    }
}
