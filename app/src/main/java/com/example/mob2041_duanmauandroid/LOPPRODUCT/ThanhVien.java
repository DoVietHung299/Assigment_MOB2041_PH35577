package com.example.mob2041_duanmauandroid.LOPPRODUCT;

public class ThanhVien {
    int IDTV;
    String HoTenTV;
    String NamsinhTV;
    String cccd;
    public ThanhVien() {
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public ThanhVien(String cccd) {
        this.cccd = cccd;
    }

    public ThanhVien(int IDTV, String hoTenTV, String namsinhTV, String cccd) {
        this.IDTV = IDTV;
        HoTenTV = hoTenTV;
        NamsinhTV = namsinhTV;
        cccd = cccd;

    }

    public int getIDTV() {
        return IDTV;
    }

    public void setIDTV(int IDTV) {
        this.IDTV = IDTV;
    }

    public String getHoTenTV() {
        return HoTenTV;
    }

    public void setHoTenTV(String hoTenTV) {
        HoTenTV = hoTenTV;
    }

    public String getNamsinhTV() {
        return NamsinhTV;
    }

    public void setNamsinhTV(String namsinhTV) {
        NamsinhTV = namsinhTV;
    }

    public static final String TB_NAME = "ThanhVien";
    public static final String COL_NAME_ID = "maTV";
    public static final String COL_NAME_HOTEN = "hoTen";
    public static final String COL_NAME_NAMSINH = "namSinh";
    public static final String COL_CCCD = "cccd";
}
