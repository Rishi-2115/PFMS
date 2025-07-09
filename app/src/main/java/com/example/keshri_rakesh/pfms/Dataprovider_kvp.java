package com.example.keshri_rakesh.pfms;

public class Dataprovider_kvp {

    private String knum,hnamekvp,amt_kvp,mamt_kvp,stdatekvp,endatekvp,postaddkvp;

    public String getKnum() {
        return knum;
    }

    public void setKnum(String knum) {
        this.knum = knum;
    }

    public String getHnamekvp() {
        return hnamekvp;
    }

    public void setHnamekvp(String hnamekvp) {
        this.hnamekvp = hnamekvp;
    }

    public String getAmt_kvp() {
        return amt_kvp;
    }

    public void setAmt_kvp(String amt_kvp) {
        this.amt_kvp = amt_kvp;
    }

    public String getMamt_kvp() {
        return mamt_kvp;
    }

    public void setMamt_kvp(String mamt_kvp) {
        this.mamt_kvp = mamt_kvp;
    }

    public String getStdatekvp() {
        return stdatekvp;
    }

    public void setStdatekvp(String stdatekvp) {
        this.stdatekvp = stdatekvp;
    }

    public String getEndatekvp() {
        return endatekvp;
    }

    public void setEndatekvp(String endatekvp) {
        this.endatekvp = endatekvp;
    }

    public String getPostaddkvp() {
        return postaddkvp;
    }

    public void setPostaddkvp(String postaddkvp) {
        this.postaddkvp = postaddkvp;
    }

    public Dataprovider_kvp(String A, String B, String C, String D, String E, String F, String G)
    {
        this.knum = A;
        this.hnamekvp = B;
        this.amt_kvp = C;
        this.mamt_kvp = D;
        this.stdatekvp = E;
        this.endatekvp = F;
        this.postaddkvp = G;
    }
}
