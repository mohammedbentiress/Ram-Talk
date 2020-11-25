package com.example.myapplication;

public class Conversation extends Item {
    private Contact emetteur;
    private Contact recepteur;
    //private String lastmsg;
    //private  boolean statut;

    public Conversation(int id, String title, String subtitle, Contact emetteur, Contact recepteur) {
        super(id, title, subtitle);
        this.emetteur = emetteur;
        this.recepteur = recepteur;
    }

    public Contact getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Contact emetteur) {
        this.emetteur = emetteur;
    }

    public Contact getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Contact recepteur) {
        this.recepteur = recepteur;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "id="+super.getId()+
                "emetteur=" + emetteur +
                ", recepteur=" + recepteur +
                '}';
    }
}
