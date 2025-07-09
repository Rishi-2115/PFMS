package com.example.keshri_rakesh.pfms;

public class Dataprovider_nsc {

    private String nscno,hname,startdate,enddate,amnt,rroi,mamt,padd;

    public String getNscno() {
        return nscno;
    }

    public void setNscno(String nscno) {
        this.nscno = nscno;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getAmnt() {
        return amnt;
    }

    public void setAmnt(String amnt) {
        this.amnt = amnt;
    }

    public String getRroi() {
        return rroi;
    }

    public void setRroi(String rroi) {
        this.rroi = rroi;
    }

    public String getMamt() {
        return mamt;
    }

    public void setMamt(String mamt) {
        this.mamt = mamt;
    }

    public String getPadd() {
        return padd;
    }

    public void setPadd(String padd) {
        this.padd = padd;
    }

    public Dataprovider_nsc(String a,String b,String c,String d,String e,String f,String g,String h)
    {
        this.nscno = a;
        this.hname = b;
        this.startdate = c;
        this.enddate = d;
        this.amnt = e;
        this.rroi = f;
        this.mamt = g;
        this.padd = h;
    }
}
