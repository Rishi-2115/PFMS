package com.example.keshri_rakesh.pfms;

public class Dataprovider_electronicinsurance {

    private String pn;
    private String electype;
    private String se;
    private String ee;
    private String it;
    private String de;

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getElectype() {
        return electype;
    }

    public void setElectype(String electype) {
        this.electype = electype;
    }

    public String getSe() {
        return se;
    }

    public void setSe(String se) {
        this.se = se;
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public Dataprovider_electronicinsurance(String a,String b,String c,String d,String e,String f)
    {
        this.pn = a;
        this.electype = b;
        this.se = c;
        this.ee = d;
        this.it = e;
        this.de = f;
    }
}
