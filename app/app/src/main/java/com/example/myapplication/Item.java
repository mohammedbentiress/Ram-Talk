package com.example.myapplication;

import java.io.Serializable;

public abstract class Item implements Serializable {

    private int id;
    private String title;
    private String subtitle;

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle() {
        if(this.getClass() == Contact.class) {
            Contact contact = (Contact)this;
            subtitle = "Username: "+contact.getUsername() + ",\nEmail: " + contact.getEmail()+",\nService: "+contact.getService();
        } else if(this.getClass() == Service.class) {
            Service service = (Service)this;
            subtitle = "Chef de service: "+service.getChef_service()+",\n"+service.getDescription();
        }else if(this.getClass() == Conversation.class) {
            Conversation conversation = (Conversation)this;
            subtitle="Click here to send message to " + conversation.getRecepteur().getPrenom();
        }else {
            subtitle = "not found";
        }
}

    public String getTitle() {
        return title;
    }

    public  void setTitle(){
        if(this.getClass() == Contact.class) {
            Contact contact = (Contact)this;
            title = contact.getNom() + " " + contact.getPrenom();
        } else if(this.getClass() == Service.class) {
            Service service = (Service)this;
            title = service.getNom_service();
        }else if(this.getClass() == Conversation.class){
            Conversation conversation = (Conversation)this;
            title=conversation.getRecepteur().getNom()+ " "+ conversation.getRecepteur().getPrenom();
        } else {
            title = "not found";
        }
    }

    public Item(){
        id=0;
        title="";
    }

    public Item(int id, String title,String subtitle) {
        this.id = id;
        this.title = title;
        this.subtitle=subtitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
