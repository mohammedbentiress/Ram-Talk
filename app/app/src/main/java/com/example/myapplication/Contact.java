package com.example.myapplication;

import java.io.Serializable;

public class Contact extends Item implements Serializable {
    private String nom,prenom,Email,Username,service;
    private Boolean statut;

    public Contact(int id,String title, String nom, String prenom, String Email, String Username, String service, Boolean staut) {
        super(id,nom+"  "+prenom,"aa");
        this.nom = nom;
        this.prenom = prenom;
        this.Email = Email;
        this.Username = Username;
        this.service = service;
        this.statut = staut;

    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Boolean getState() {
        return statut;
    }

    public void setState(Boolean statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id="+getId()+
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", Email='" + Email + '\'' +
                ", Username='" + Username + '\'' +
                ", service='" + service + '\'' +
                ", state=" + statut +
                '}';
    }
}
