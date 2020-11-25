package com.example.myapplication;

public class Service extends Item {
    private String nom_service,Chef_service,Description;

    public Service(int id,String nom_service, String chef_service, String description) {
        super(id,nom_service,"aa");
        this.nom_service = nom_service;
        Chef_service = chef_service;
        Description = description;
    }



    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }

    public String getChef_service() {
        return Chef_service;
    }

    public void setChef_service(String chef_service) {
        Chef_service = chef_service;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Service{" +
                "nom_service='" + nom_service + '\'' +
                ", Chef_service='" + Chef_service + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
