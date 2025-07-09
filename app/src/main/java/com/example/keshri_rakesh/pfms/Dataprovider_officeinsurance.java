package com.example.keshri_rakesh.pfms;

public class Dataprovider_officeinsurance {

    private String pol_no;
    private String branch;
    private String S;
    private String D;
    private String I;

    public String getPol_no() {
        return pol_no;
    }

    public void setPol_no(String pol_no) {
        this.pol_no = pol_no;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getS() {
        return S;
    }

    public void setS(String s) {
        S = s;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    public Dataprovider_officeinsurance(String h,String i,String j,String k,String l)
    {
        this.pol_no = h;
        this.branch = i;
        this.S = j;
        this.D = k;
        this.I = l;
    }
}
