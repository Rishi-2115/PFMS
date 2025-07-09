package com.example.keshri_rakesh.pfms;

public class Dataprovider_td {

    private String name_holder;
    private String date_start;
    private String date_due;
    private String amnt_t;
    private String roiss;
    private String maturityamt;

    public String getName_holder() {
        return name_holder;
    }

    public void setName_holder(String name_holder) {
        this.name_holder = name_holder;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_due() {
        return date_due;
    }

    public void setDate_due(String date_due) {
        this.date_due = date_due;
    }

    public String getAmnt_t() {
        return amnt_t;
    }

    public void setAmnt_t(String amnt_t) {
        this.amnt_t = amnt_t;
    }

    public String getRoiss() {
        return roiss;
    }

    public void setRoiss(String roiss) {
        this.roiss = roiss;
    }

    public String getMaturityamt() {
        return maturityamt;
    }

    public void setMaturityamt(String maturityamt) {
        this.maturityamt = maturityamt;
    }

    public Dataprovider_td(String a,String b,String c,String d,String e,String f)
    {
        this.name_holder = a;
        this.date_start = b;
        this.date_due = c;
        this.amnt_t = d;
        this.roiss = e;
        this.maturityamt = f;
    }
}
