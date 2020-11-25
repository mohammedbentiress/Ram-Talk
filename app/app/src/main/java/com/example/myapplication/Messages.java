package com.example.myapplication;

import java.util.Date;

public class Messages {
    private int id_emetteur,id_recepteur;
    private int id;
    private Date date;
    private Boolean sent;
    private String side;
    private String text;

    @Override
    public String toString() {
        return "Messages{" +
                "id_emetteur=" + id_emetteur +
                ", id_recepteur=" + id_recepteur +
                ", id=" + id +
                ", date=" + date +
                ", sent=" + sent +
                ", side='" + side + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public Messages(int id_emetteur, int id_recepteur, int id, Date date, Boolean sent, String side, String Text) {
        this.id_emetteur = id_emetteur;
        this.id_recepteur = id_recepteur;
        this.id = id;
        this.date = date;
        this.sent = sent;
        this.side = side;
        this.text=Text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        text = text;
    }

    public int getId_emetteur() {
        return id_emetteur;
    }

    public void setId_emetteur(int id_emetteur) {
        this.id_emetteur = id_emetteur;
    }

    public int getId_recepteur() {
        return id_recepteur;
    }

    public void setId_recepteur(int id_recepteur) {
        this.id_recepteur = id_recepteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}
