package com.example.kutaykerem.computerinformaton.Models;




public class KesfetAnlıkDusuncelerDetails {
    public KesfetAnlıkDusuncelerDetails(String parcaAdi, String aciklama, String puan, String gonderiId, String gonderenId, String tarih, String parcaModeli, String ayrıParca) {
        this.parcaAdi = parcaAdi;
        this.aciklama = aciklama;
        this.puan = puan;
        this.gonderiId = gonderiId;
        this.gonderenId = gonderenId;
        this.tarih = tarih;
        this.parcaModeli = parcaModeli;
        this.ayrıParca = ayrıParca;
    }

    public String parcaAdi,aciklama,puan,kullanıcıAdı,profile,gonderiId,gonderenId,tarih,parcaModeli,ayrıParca;


    public String getParcaAdi() {
        return parcaAdi;
    }

    public void setParcaAdi(String parcaAdi) {
        this.parcaAdi = parcaAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getPuan() {
        return puan;
    }

    public void setPuan(String puan) {
        this.puan = puan;
    }

    public String getGonderiId() {
        return gonderiId;
    }

    public void setGonderiId(String gonderiId) {
        this.gonderiId = gonderiId;
    }

    public String getGonderenId() {
        return gonderenId;
    }

    public void setGonderenId(String gonderenId) {
        this.gonderenId = gonderenId;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getParcaModeli() {
        return parcaModeli;
    }

    public void setParcaModeli(String parcaModeli) {
        this.parcaModeli = parcaModeli;
    }

    public String getAyrıParca() {
        return ayrıParca;
    }

    public void setAyrıParca(String ayrıParca) {
        this.ayrıParca = ayrıParca;
    }

    public KesfetAnlıkDusuncelerDetails() {
    }
}
