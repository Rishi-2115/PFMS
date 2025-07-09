package com.example.keshri_rakesh.pfms;

public class Dataprovider_vehicleinsurance {


    private String polnum;
    private String vehiclenumber;
    private String vehicletype;
    private String Sdate;
    private String Edate;
    private String Iamount;
    private String Ddate;

    public String getPolnum() {
        return polnum;
    }

    public void setPolnum(String polnum) {
        this.polnum = polnum;
    }

    public String getVehiclenumber() {
        return vehiclenumber;
    }

    public void setVehiclenumber(String vehiclenumber) {
        this.vehiclenumber = vehiclenumber;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String sdate) {
        Sdate = sdate;
    }

    public String getEdate() {
        return Edate;
    }

    public void setEdate(String edate) {
        Edate = edate;
    }

    public String getIamount() {
        return Iamount;
    }

    public void setIamount(String iamount) {
        Iamount = iamount;
    }

    public String getDdate() {
        return Ddate;
    }

    public void setDdate(String ddate) {
        Ddate = ddate;
    }

    public Dataprovider_vehicleinsurance(String a,String b,String c,String d,String e,String f,String g)
    {
        this.polnum = a;
        this.vehiclenumber = b;
        this.vehicletype = c;
        this.Sdate = d;
        this.Edate = e;
        this.Iamount = f;
        this.Ddate = g;
    }
}
