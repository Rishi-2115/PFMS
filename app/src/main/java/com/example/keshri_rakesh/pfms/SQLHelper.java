package com.example.keshri_rakesh.pfms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.keshri_rakesh.pfms.records.rec.c_name;

class SQLHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME="project_ica.db";
    static final int DATABASE_VERSION=1;
    public static final String name="name";
    public static final String id="id";
    public static final String pass="pass";
    //public  static final String TRANSACTION = "TRANSACTION";
    //static final String TABLE_NAME="registration";


    public SQLHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String query = "create table "+records.rec.TABLE_NAME_BANK+ "("+records.rec.IFSC+ " varchar(20),"+records.rec.MICR+" varchar(20),"+records.rec.acc_no+" varchar(20),"+records.rec.h_name+" varchar(20),"+records.rec.b_id+" varchar(20),"+records.rec.b_name+" varchar(20),"+records.rec.Bal+" varchar(20));";
        //db.execSQL(query);

        String query1="create table registration(name varchar,id varchar PRIMARY KEY,pass varchar)";
        db.execSQL(query1);

        String query2="create table "+records.rec.LIFE_INSURANCE+ "("+records.rec.POLICY_NO+ " varchar(20),"+records.rec.HOLDERL+ " varchar(20),"+records.rec.POLICY_NAME+ " varchar(20),"+records.rec.COM_NAME+ " varchar(20),"+records.rec.START_DATE+ " varchar(20),"+records.rec.DUE_DATE+ " varchar(20),"+records.rec.PERIOD+ " varchar(20),"+records.rec.PREMIUM_AMOUNT+ " varchar(20),"+records.rec.SUM_ASSURED+ " varchar(20));";
        db.execSQL(query2);

        String query3="create table "+records.rec.VEHICLE_INSURANCE+ "("+records.rec.Policy_Num+ " varchar(20),"+records.rec.Vehicle_Num+ " varchar(20),"+records.rec.Vehicle_Type+ " varchar(20),"+records.rec.S_Date+ " varchar(20),"+records.rec.E_Date+ " varchar(20),"+records.rec.I_Amt+ " varchar(20),"+records.rec.D_Date+ " varchar(20));";
        db.execSQL(query3);

        String query4="create table "+records.rec.OFFICE_INSURANCE+ "("+records.rec.p_no+ " varchar(20),"+records.rec.branch_office+ " varchar(20),"+records.rec.s_date+ " varchar(20),"+records.rec.d_date+ " varchar(20),"+records.rec.i_amt+ " varchar(20));";
        db.execSQL(query4);

        String query5="create table "+records.rec.ELECTRONIC_INSURANCE+ "("+records.rec.pol_no+ " varchar(20),"+records.rec.electronic_type+ " varchar(20),"+records.rec.sd+ " varchar(20),"+records.rec.ed+ " varchar(20),"+records.rec.iamt+ " varchar(20),"+records.rec.ddate+ " varchar(20));";
        db.execSQL(query5);

        String query6="create table "+records.rec.NSC+ "("+records.rec.nsc_no+ " varchar(20),"+records.rec.h_name+ " varchar(20),"+records.rec.start_date+ " varchar(20),"+records.rec.end_date+ " varchar(20),"+records.rec.amnt+ " varchar(20),"+records.rec.rroi+ " varchar(20),"+records.rec.m_amt+ " varchar(20),"+records.rec.p_add+ " varchar(20));";
        db.execSQL(query6);

        String query7="create table "+records.rec.TD+ "("+records.rec.name_holder+ " varchar(20),"+records.rec.date_start+ " varchar(20),"+records.rec.date_due+ " varchar(20),"+records.rec.am+ " varchar(20),"+records.rec.rois+ " varchar(20),"+records.rec.maturity_am+ " varchar(20));";
        db.execSQL(query7);

        //String query8= "create table "+records.rec.TRANSACTION_BANK+ "("+records.rec.tid+ " TEXT,"+records.rec.bankname+" TEXT,"+records.rec.branch+" TEXT,"+records.rec.Accno+" TEXT,"+records.rec.tratype+" TEXT,"+records.rec.recname+" TEXT,"+records.rec.Amount+" TEXT,"+records.rec.Chqno+" TEXT,"+records.rec.Remark+"TEXT);";
        //db.execSQL(query8);

        String query9="create table "+records.rec.sharess+ "("+records.rec.sharesid+ " varchar(20),"+c_name+" varchar(20),"+records.rec.holdername+" varchar(20),"+records.rec.p_date+" varchar(20),"+records.rec.noofshares+" varchar(20),"+records.rec.total_amt+" varchar(20),"+records.rec.bank_name+" varchar(20));";
        db.execSQL(query9);

        String query10="create table "+records.rec.RD+ "("+records.rec.accno+ " varchar(20),"+records.rec.name_h+ " varchar(20),"+records.rec.ri+ " varchar(20),"+records.rec.monthly_amt+ " varchar(20),"+records.rec.st_date+ " varchar(20),"+records.rec.e_date+ " varchar(20),"+records.rec.post_add+ " varchar(20));";
        db.execSQL(query10);

        String query15="create table "+records.rec.KVP+ "("+records.rec.kvpno+ " varchar(20),"+records.rec.ho+ " varchar(20),"+records.rec.amot+ " varchar(20),"+records.rec.M_amt+ " varchar(20),"+records.rec.date_s+ " varchar(20),"+records.rec.date_e+ " varchar(20),"+records.rec.Post+ " varchar(20));";
        db.execSQL(query15);

        //String query11="create table fd (g varchar(20),ab varchar(20),a varchar(20),b varchar(20),c varchar(20),d varchar(50),e varchar(20),bc varchar(20),f varchar(20))";
        //db.execSQL(query11);

        String query11="create table "+records.rec.TABLE_NAME+ "("+records.rec.fid+ " varchar(20),"+records.rec.bname+" varchar(20),"+records.rec.hname+" varchar(20),"+records.rec.scheme+" varchar(20),"+records.rec.amount+" varchar(20),"+records.rec.sdate+" varchar(20),"+records.rec.roi+" varchar(20),"+records.rec.itype+" varchar(20),"+records.rec.mtime+" varchar(20));";
        db.execSQL(query11);

        String query12 = "create table "+records.rec.LUMSUM+ "("+records.rec.COMPANYNAME+ " varchar(20),"+records.rec.FOLIO_NO+ " varchar(20),"+records.rec.AMOUNT+ " varchar(20));";
        db.execSQL(query12);

        String query13 = "create table "+records.rec.SIPS+ "("+records.rec.NAMEOFCOMPANY+ " varchar(20),"+records.rec.FOLIONUMBER+ " varchar(20),"+records.rec.STARTDATE+ " varchar(20),"+records.rec.TODATE+ " varchar(20),"+records.rec.AMT+ " varchar(20),"+records.rec.FREQUENCY+ " varchar(20),"+records.rec.HOLDER+ " varchar(20),"+records.rec.BANKNAME+ " varchar(20),"+records.rec.NOOFUNITS+ " varchar(20),"+records.rec.ADDRESS+ " varchar(30),"+records.rec.PLANNAME+ " varchar(20),"+records.rec.ET12+ " varchar(20),"+records.rec.ET13+ " varchar(20));";
        db.execSQL(query13);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
    public boolean insert(String name,String id,String pass)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("id",id);
        contentValues.put("pass",pass);

        long ins = sqLiteDatabase.insert("registration",null,contentValues);
        if(ins==-1)
        {
            return false;
        }
        else return true;
    }

    public boolean chkemail(String id)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from registration where id=?",new String[]{id});
        if(cursor.getCount()>0)
        {
            return false;

        }
        else return true;

    }
    public boolean check(String id, String pass)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from registration where id=? and pass=?", new String[]{id,pass});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else return false;
    }


    //bank chalu
    /*public boolean ca(String ifsc,String micr,String accno,String holdername,String bankid,String bankname,String balance)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.IFSC,ifsc);
        contentValues.put(records.rec.MICR,micr);
        contentValues.put(records.rec.acc_no,accno);
        contentValues.put(records.rec.h_name,holdername);
        contentValues.put(records.rec.b_id,bankid);
        contentValues.put(records.rec.b_name,bankname);
        contentValues.put(records.rec.Bal,balance);

        long ins = sqLiteDatabase.insert(records.rec.TABLE_NAME_BANK,null,contentValues);
        if(ins==-1)
        {
            return false;
        }
        else return true;
    }*/
    /*public Cursor getDataBank(SQLiteDatabase db)
    {
        Cursor cursor;
        String bank[]= {
                records.rec.IFSC,
                records.rec.MICR,
                records.rec.acc_no,
                records.rec.h_name,
                records.rec.b_id,
                records.rec.b_name,
                records.rec.Bal
        };
        cursor=db.query(records.rec.TABLE_NAME_BANK,bank,null,null,null,null,null);
        return cursor;
    }*/
    /*public int updatebank(String b_id, String h_name,String b_name, String Bal, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.h_name,h_name);
        contentValues.put(records.rec.b_name,b_name);
        contentValues.put(records.rec.Bal,Bal);

        int i = db.update(records.rec.TABLE_NAME_BANK,contentValues,records.rec.b_id + " = "+b_id,null);
        return i;
    }
    public void deletebank(String b_id,SQLiteDatabase db)
    {
        db.delete(records.rec.TABLE_NAME_BANK,records.rec.b_id+ "=" +b_id,null);

    }*/
    //bank khatam

    //transaction chalu
    /*public void trans(String a, String ab, String b, String bc, String rad1, String c, String d, String e, String f,SQLiteDatabase db)
    {
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.tid,a);
        contentValues.put(records.rec.bankname,ab);
        contentValues.put(records.rec.branch,b);
        contentValues.put(records.rec.Accno,bc);
        contentValues.put(records.rec.tratype,rad1);
        contentValues.put(records.rec.recname,c);
        contentValues.put(records.rec.Amount,d);
        contentValues.put(records.rec.Chqno,e);
        contentValues.put(records.rec.Remark,f);

         db.insert(records.rec.TRANSACTION_BANK,null,contentValues);

    }*/

    /*public Cursor getDataTrans(SQLiteDatabase db)
    {
        Cursor cursor;
        String tran[]= {
                records.rec.tid,
                records.rec.bankname,
                records.rec.branch,
                records.rec.Accno,
                records.rec.tratype,
                records.rec.recname,
                records.rec.Amount,
                records.rec.Chqno,
                records.rec.Remark
        };
        cursor=db.query(records.rec.TRANSACTION_BANK,tran,null,null,null,null,null);
        return cursor;
    }

    public int updateTrans(String tid, String bname,String branch, String accno,String receiver,String amount,String chqno,String remark, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.bankname,bname);
        contentValues.put(records.rec.branch,branch);
        contentValues.put(records.rec.Accno,accno);
        contentValues.put(records.rec.recname,receiver);
        contentValues.put(records.rec.Amount,amount);
        contentValues.put(records.rec.Chqno,chqno);
        contentValues.put(records.rec.Remark,remark);

        int i = db.update(records.rec.TRANSACTION_BANK,contentValues,records.rec.tid + " = "+tid,null);
        return i;
    }

    public void deleteTrans(String tid,SQLiteDatabase db)
    {
        db.delete(records.rec.TRANSACTION_BANK,records.rec.tid+ "=" +tid,null);

    }*/




    //LIFE INSURANCE

    public void lifeinsurance(String plno,String hlname,String plname,String cmname,String stdate,String ddate,String per,String premamt,String sumassu,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.POLICY_NO,plno);
        contentValues.put(records.rec.HOLDERL,hlname);
        contentValues.put(records.rec.POLICY_NAME,plname);
        contentValues.put(records.rec.COM_NAME,cmname);
        contentValues.put(records.rec.START_DATE,stdate);
        contentValues.put(records.rec.DUE_DATE,ddate);
        contentValues.put(records.rec.PERIOD,per);
        contentValues.put(records.rec.PREMIUM_AMOUNT,premamt);
        contentValues.put(records.rec.SUM_ASSURED,sumassu);

        db.insert(records.rec.LIFE_INSURANCE,null,contentValues);



    }

    public Cursor getdllife(SQLiteDatabase db)
    {
        Cursor q;
        String l[] = {
                records.rec.POLICY_NO,
                records.rec.HOLDERL,
                records.rec.POLICY_NAME,
                records.rec.COM_NAME,
                records.rec.START_DATE,
                records.rec.DUE_DATE,
                records.rec.PERIOD,
                records.rec.PREMIUM_AMOUNT,
                records.rec.SUM_ASSURED
        };

        q = db.query(records.rec.LIFE_INSURANCE,l,null,null,null,null,null);
        return q;
    }

    public void updatelife(String polno,String hol,String polname,String comnam,String stadate,String dudate,String peri,String prem,String sumas,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(records.rec.HOLDERL,hol);
        contentValues.put(records.rec.POLICY_NAME,polname);
        contentValues.put(records.rec.COM_NAME,comnam);
        contentValues.put(records.rec.START_DATE,stadate);
        contentValues.put(records.rec.DUE_DATE,dudate);
        contentValues.put(records.rec.PERIOD,peri);
        contentValues.put(records.rec.PREMIUM_AMOUNT,prem);
        contentValues.put(records.rec.SUM_ASSURED,sumas);

        db.update(records.rec.LIFE_INSURANCE,contentValues,records.rec.POLICY_NO+ " = "+polno,null);


    }

    public void deletelife(String pono,SQLiteDatabase db)

    {
        db.delete(records.rec.LIFE_INSURANCE,records.rec.POLICY_NO+ " = "+pono,null);
    }

    //LUMSUM

    public void lumsum_add(String cname,String foliono,String amt,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.COMPANYNAME,cname);
        contentValues.put(records.rec.FOLIO_NO,foliono);
        contentValues.put(records.rec.AMOUNT,amt);

        db.insert(records.rec.LUMSUM,null,contentValues);



    }

    public Cursor getDatalumsum(SQLiteDatabase db)
    {
        Cursor clumsum;
         String d[] = {
                 records.rec.COMPANYNAME,
                 records.rec.FOLIO_NO,
                 records.rec.AMOUNT
         };

         clumsum = db.query(records.rec.LUMSUM,d,null,null,null,null,null);
         return clumsum;
    }

    public int updatelumsum(String cname,String foliono,String amt,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.COMPANYNAME,cname);
        contentValues.put(records.rec.AMOUNT,amt);

        int i = db.update(records.rec.LUMSUM,contentValues,records.rec.FOLIO_NO + " = "+foliono,null);
        return i;

    }

    public void deletelumsum(String foliono,SQLiteDatabase db)
    {
        db.delete(records.rec.LUMSUM,records.rec.FOLIO_NO+ " = "+foliono,null);
    }

    //lumsum over


    //sip chalu

    public void sip_add(String nameofcompany,String folionumber,String startdate,String todate,String amt,String frequency,String holder,String bankname,String noofunits,String address,String planname,String et12,String et13,SQLiteDatabase db)

    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.NAMEOFCOMPANY,nameofcompany);
        contentValues.put(records.rec.FOLIONUMBER,folionumber);
        contentValues.put(records.rec.STARTDATE,startdate);
        contentValues.put(records.rec.TODATE,todate);
        contentValues.put(records.rec.AMT,amt);
        contentValues.put(records.rec.FREQUENCY,frequency);
        contentValues.put(records.rec.HOLDER,holder);
        contentValues.put(records.rec.BANKNAME,bankname);
        contentValues.put(records.rec.NOOFUNITS,noofunits);
        contentValues.put(records.rec.ADDRESS,address);
        contentValues.put(records.rec.PLANNAME,planname);
        contentValues.put(records.rec.ET12,et12);
        contentValues.put(records.rec.ET13,et13);

        db.insert(records.rec.SIPS,null,contentValues);


    }

    public Cursor getDatasip(SQLiteDatabase db)
    {
        Cursor csip;
        String sip[] = {
                records.rec.NAMEOFCOMPANY,
                records.rec.FOLIONUMBER,
                records.rec.STARTDATE,
                records.rec.TODATE,
                records.rec.AMT,
                records.rec.FREQUENCY,
                records.rec.HOLDER,
                records.rec.BANKNAME,
                records.rec.NOOFUNITS,
                records.rec.ADDRESS,
                records.rec.PLANNAME,
                records.rec.ET12,
                records.rec.ET13

        };

        csip = db.query(records.rec.SIPS,sip,null,null,null,null,null);
        return csip;
    }

    public void updatesip(String companyname,String folionum,String amt,String frequency,String holder,String bankname,String noofunits,String address,String et12,String et13,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(records.rec.NAMEOFCOMPANY,companyname);
        contentValues.put(records.rec.AMT,amt);
        contentValues.put(records.rec.FREQUENCY,frequency);
        contentValues.put(records.rec.HOLDER,holder);
        contentValues.put(records.rec.BANKNAME,bankname);
        contentValues.put(records.rec.NOOFUNITS,noofunits);
        contentValues.put(records.rec.ADDRESS,address);
        contentValues.put(records.rec.ET12,et12);
        contentValues.put(records.rec.ET13,et13);

        db.update(records.rec.SIPS,contentValues,records.rec.FOLIONUMBER+ " = "+folionum,null);



    }
    public void deletesip(String folionum,SQLiteDatabase db)
    {
        db.delete(records.rec.SIPS,records.rec.FOLIONUMBER+ " = "+folionum,null);
    }














    public void vi(String policy_num, String vehicle_num, String vehicle_type, String s_date, String e_date, String i_amt, String d_date,SQLiteDatabase db)
    {
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.Policy_Num,policy_num);
        contentValues.put(records.rec.Vehicle_Num,vehicle_num);
        contentValues.put(records.rec.Vehicle_Type,vehicle_type);
        contentValues.put(records.rec.S_Date,s_date);
        contentValues.put(records.rec.E_Date,e_date);
        contentValues.put(records.rec.I_Amt,i_amt);
        contentValues.put(records.rec.D_Date,d_date);

         db.insert(records.rec.VEHICLE_INSURANCE,null,contentValues);

    }

    public Cursor getDvehicleinsurance(SQLiteDatabase db)
    {
        Cursor cvehi;
        String vehicle[] = {
                records.rec.Policy_Num,
                records.rec.Vehicle_Num,
                records.rec.Vehicle_Type,
                records.rec.S_Date,
                records.rec.E_Date,
                records.rec.I_Amt,
                records.rec.D_Date

        };
        cvehi = db.query(records.rec.VEHICLE_INSURANCE,vehicle,null,null,null,null,null);
        return cvehi;
    }

    public void updatevehicle(String po,String vehinum,String vehitype,String amount,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.Vehicle_Num,vehinum);
        contentValues.put(records.rec.Vehicle_Type,vehitype);
        contentValues.put(records.rec.I_Amt,amount);

        db.update(records.rec.VEHICLE_INSURANCE,contentValues,records.rec.Policy_Num+ " = "+po,null);
    }

    public void deletevehicle(String po,SQLiteDatabase db)
    {
        db.delete(records.rec.VEHICLE_INSURANCE,records.rec.Policy_Num+ " = "+po,null);
    }
    //vehicle khatam



    //Office insurance

    public void oi(String p_no, String branch, String s_date, String d_date, String i_amt,SQLiteDatabase db)
    {
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.p_no,p_no);
        contentValues.put(records.rec.branch_office,branch);
        contentValues.put(records.rec.s_date,s_date);
        contentValues.put(records.rec.d_date,d_date);
        contentValues.put(records.rec.i_amt,i_amt);

        db.insert(records.rec.OFFICE_INSURANCE,null,contentValues);

    }

    public Cursor getDofficeinsurance(SQLiteDatabase db)
    {
        Cursor coff;

        String office[] = {
                records.rec.p_no,
                records.rec.branch_office,
                records.rec.s_date,
                records.rec.d_date,
                records.rec.i_amt

        };
        coff = db.query(records.rec.OFFICE_INSURANCE,office,null,null,null,null,null);
        return coff;


    }

    public void updateofficeinsurance(String pnum,String b,String i,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.branch_office,b);
        contentValues.put(records.rec.i_amt,i);

        db.update(records.rec.OFFICE_INSURANCE,contentValues,records.rec.p_no+ " = "+pnum,null);

    }

    public void deleteofficeinsurance(String pnum,SQLiteDatabase db)
    {
        db.delete(records.rec.OFFICE_INSURANCE,records.rec.p_no+ " = "+pnum,null);
    }

    public void ei(String policy_num, String electronic_type, String s_date, String e_date, String i_amt, String d_date,SQLiteDatabase db)
    {
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.pol_no,policy_num);
        contentValues.put(records.rec.electronic_type,electronic_type);
        contentValues.put(records.rec.sd,s_date);
        contentValues.put(records.rec.ed,e_date);
        contentValues.put(records.rec.iamt,i_amt);
        contentValues.put(records.rec.ddate,d_date);

        db.insert(records.rec.ELECTRONIC_INSURANCE,null,contentValues);

    }


    public Cursor getDelectronicinsurance(SQLiteDatabase db)
    {
        Cursor celec;
        String elec[]={

                records.rec.pol_no,
                records.rec.electronic_type,
                records.rec.sd,
                records.rec.ed,
                records.rec.iamt,
                records.rec.ddate

        };

        celec = db.query(records.rec.ELECTRONIC_INSURANCE,elec,null,null,null,null,null);
        return celec;
    }

    public void updateelectronic(String polno,String electype,String sdae,String edae,String amt,String ddate,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.electronic_type,electype);
        contentValues.put(records.rec.sd,sdae);
        contentValues.put(records.rec.ed,edae);
        contentValues.put(records.rec.iamt,amt);
        contentValues.put(records.rec.ddate,ddate);

        db.update(records.rec.ELECTRONIC_INSURANCE,contentValues,records.rec.pol_no+ " = "+polno,null);

        }


        public void deleteelectronic(String polno,SQLiteDatabase db)
        {
            db.delete(records.rec.ELECTRONIC_INSURANCE,records.rec.pol_no+" = "+polno,null);
        }



    public void nsc(String nsc_no, String h_name, String s_date, String e_date, String amt, String roi, String m_amt, String p_add,SQLiteDatabase db)
    {
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.nsc_no,nsc_no);
        contentValues.put(records.rec.h_name,h_name);
        contentValues.put(records.rec.start_date,s_date);
        contentValues.put(records.rec.end_date,e_date);
        contentValues.put(records.rec.amnt,amt);
        contentValues.put(records.rec.rroi,roi);
        contentValues.put(records.rec.m_amt,m_amt);
        contentValues.put(records.rec.p_add,p_add);

        db.insert(records.rec.NSC,null,contentValues);

    }


    public Cursor getDnsc(SQLiteDatabase db)
    {
        Cursor ch;
        String z[] = {
                records.rec.nsc_no,
                records.rec.h_name,
                records.rec.start_date,
                records.rec.end_date,
                records.rec.amnt,
                records.rec.rroi,
                records.rec.m_amt,
                records.rec.p_add
        };

        ch = db.query(records.rec.NSC,z,null,null,null,null,null);
        return ch;


    }

    public void updatensc(String nscno,String hname,String amnt,String rroi,String mamt,String padd,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();


        contentValues.put(records.rec.h_name,hname);
        contentValues.put(records.rec.amnt,amnt);
        contentValues.put(records.rec.rroi,rroi);
        contentValues.put(records.rec.m_amt,mamt);
        contentValues.put(records.rec.p_add,padd);

        db.update(records.rec.NSC,contentValues,records.rec.nsc_no+ " = "+nscno,null);


    }

    public void deletensc(String nscno,SQLiteDatabase db)
    {
        db.delete(records.rec.NSC,records.rec.nsc_no+ " = "+nscno,null);
    }

    public void td(String name, String s_date, String d_date, String amt, String roi, String m_amt,SQLiteDatabase db)
    {
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.name_holder,name);
        contentValues.put(records.rec.date_start,s_date);
        contentValues.put(records.rec.date_due,d_date);
        contentValues.put(records.rec.am,amt);
        contentValues.put(records.rec.rois,roi);
        contentValues.put(records.rec.maturity_am,m_amt);

         db.insert(records.rec.TD,null,contentValues);

    }

   public Cursor getdtd(SQLiteDatabase db)
   {
       Cursor cr;

       String a[] =  {

               records.rec.name_holder,
               records.rec.date_start,
               records.rec.date_due,
               records.rec.am,
               records.rec.rois,
               records.rec.maturity_am


       };
       cr = db.query(records.rec.TD,a,null,null,null,null,null);
       return cr;
   }
   public void updatedtd(String name, String date, String datedue, String amt, String roi, String maturityamt, SQLiteDatabase db)
   {
       ContentValues contentValues = new ContentValues();

       contentValues.put(records.rec.date_start, date);
       contentValues.put(records.rec.date_due, datedue);
       contentValues.put(records.rec.am,amt);
       contentValues.put(records.rec.rois,roi);
       contentValues.put(records.rec.maturity_am,maturityamt);

       db.update(records.rec.TD,contentValues,records.rec.name_holder+ " = "+name,null);
   }


   public void deletetd(String name,SQLiteDatabase db)
   {
       db.delete(records.rec.TD,records.rec.name_holder+ " = "+name,null);
   }







    public void shares(String id, String cname, String h_name, String p_date, String no_of_shares, String total_amt, String bank_name ,SQLiteDatabase db)
    {
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.sharesid,id);
        contentValues.put(records.rec.c_name,cname);
        contentValues.put(records.rec.holdername,h_name);
        contentValues.put(records.rec.p_date,p_date);
        contentValues.put(records.rec.noofshares,no_of_shares);
        contentValues.put(records.rec.total_amt,total_amt);
        contentValues.put(records.rec.bank_name,bank_name);

      db.insert(records.rec.sharess,null,contentValues);


    }
    public Cursor getDatashares(SQLiteDatabase db)
    {
        Cursor c;
        String sha[] = {

                records.rec.sharesid,
                records.rec.c_name,
                records.rec.holdername,
                records.rec.p_date,
                records.rec.noofshares,
                records.rec.total_amt,
                records.rec.bank_name

        };
        c = db.query(records.rec.sharess,sha,null,null,null,null,null);
        return c;



    }

    public void updateshares(String sid, String cname,String hname, String noofshares, String totalamt, String bname, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(c_name,cname);
        contentValues.put(records.rec.holdername,hname);
        //contentValues.put(records.rec.p_date,pdate);
        contentValues.put(records.rec.noofshares,noofshares);
        contentValues.put(records.rec.total_amt,totalamt);
        contentValues.put(records.rec.bank_name,bname);
         db.update(records.rec.sharess,contentValues,records.rec.sharesid + " = "+sid,null);

    }

    public void deleteshares(String sid,SQLiteDatabase db)
    {
        db.delete(records.rec.sharess,records.rec.sharesid+ "=" +sid,null);

    }
    public void rd(String a, String b, String c, String d, String e, String f, String g,SQLiteDatabase db)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.accno,a);
        contentValues.put(records.rec.name_h,b);
        contentValues.put(records.rec.ri,c);
        contentValues.put(records.rec.monthly_amt,d);
        contentValues.put(records.rec.st_date,e);
        contentValues.put(records.rec.e_date,f);
        contentValues.put(records.rec.post_add,g);

        db.insert(records.rec.RD,null,contentValues);

    }

    public Cursor getdrd(SQLiteDatabase db)
    {
        Cursor xr;
        String rd[] = {
                records.rec.accno,
                records.rec.name_h,
                records.rec.ri,
                records.rec.monthly_amt,
                records.rec.st_date,
                records.rec.e_date,
                records.rec.post_add
        };

        xr = db.query(records.rec.RD,rd,null,null,null,null,null);
        return xr;
    }


    public void updaterd(String accno,String name,String roi,String monthly,String sdate,String ed,String pa,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.name_h,name);
        contentValues.put(records.rec.ri,roi);
        contentValues.put(records.rec.monthly_amt,monthly);
        contentValues.put(records.rec.st_date,sdate);
        contentValues.put(records.rec.e_date,ed);
        contentValues.put(records.rec.post_add,pa);

        db.update(records.rec.RD,contentValues,records.rec.accno+ " = "+accno,null);


    }


    public void deleterd(String accno,SQLiteDatabase db)
    {
        db.delete(records.rec.RD,records.rec.accno+ " = "+accno,null);
    }


    public void kvps(String a,String b,String c,String d,String e,String f,String g,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(records.rec.kvpno,a);
        contentValues.put(records.rec.ho,b);
        contentValues.put(records.rec.amot,c);
        contentValues.put(records.rec.M_amt,d);
        contentValues.put(records.rec.date_s,e);
        contentValues.put(records.rec.date_e,f);
        contentValues.put(records.rec.Post,g);

        db.insert(records.rec.KVP,null,contentValues);
    }

    public Cursor getdkvp(SQLiteDatabase db)
    {
        Cursor cs;
        String a[] = {
                records.rec.kvpno,
                records.rec.ho,
                records.rec.amot,
                records.rec.M_amt,
                records.rec.date_s,
                records.rec.date_e,
                records.rec.Post

        };
        cs = db.query(records.rec.KVP,a,null,null,null,null,null);
        return cs;
    }

    public void updatekvp(String a,String b,String c,String d,String e,String f,String g,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.ho,b);
        contentValues.put(records.rec.amot,c);
        contentValues.put(records.rec.M_amt,d);
        contentValues.put(records.rec.date_s,e);
        contentValues.put(records.rec.date_e,f);
        contentValues.put(records.rec.Post,g);

        db.update(records.rec.KVP,contentValues,records.rec.kvpno+ " = "+a,null);


    }

    public void deletekvp(String a,SQLiteDatabase db)
    {
        db.delete(records.rec.KVP,records.rec.kvpno+ " = "+a,null);
    }




    public void fd(String g, String ab, String a, String b, String c, String d, String e, String bc, String f,SQLiteDatabase db)
    {
        //SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(records.rec.fid,g);
        contentValues.put(records.rec.bname,ab);
        contentValues.put(records.rec.hname,a);
        contentValues.put(records.rec.scheme,b);
        contentValues.put(records.rec.amount,c);
        contentValues.put(records.rec.sdate,d);
        contentValues.put(records.rec.roi,e);
        contentValues.put(records.rec.itype,bc);
        contentValues.put(records.rec.mtime,f);

        db.insert(records.rec.TABLE_NAME,null,contentValues);


        /*long ins = sqLiteDatabase.insert("fd",null,contentValues);
        if(ins==-1)
        {
            return false;
        }
        else return true;*/
    }
    public Cursor getData(SQLiteDatabase db)
    {
        //SQLiteDatabase db = this.getReadableDatabase();
        /*String q = "Select * from fd";
        Cursor data = db.rawQuery(q,null);
        return data;*/
        Cursor cursor;
        String a[]= {
                records.rec.fid,
                records.rec.bname,
                records.rec.hname,
                records.rec.scheme,
                records.rec.amount,
                records.rec.sdate,
                records.rec.roi,
                records.rec.itype,
                records.rec.mtime
        };
        cursor=db.query(records.rec.TABLE_NAME,a,null,null,null,null,null);
        return cursor;
    }
    public int updatefd(String fid, String scheme,String amount, String sdate, String itype, String roi, String mtime, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(records.rec.scheme,scheme);
        contentValues.put(records.rec.amount,amount);
        contentValues.put(records.rec.sdate,sdate);
        contentValues.put(records.rec.itype,itype);
        contentValues.put(records.rec.roi,roi);
        contentValues.put(records.rec.mtime,mtime);
        int i = db.update(records.rec.TABLE_NAME,contentValues,records.rec.fid + " = "+fid,null);
        return i;
    }
    public void delete(String id,SQLiteDatabase db)
    {
        db.delete(records.rec.TABLE_NAME,records.rec.fid+ "=" +id,null);

    }
}
