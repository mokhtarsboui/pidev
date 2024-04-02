package edu.esprit.entities;

import java.util.Objects;

public class centre {
    private int id;
    private String nom,adresse,description;
    private int nb_cours,nb_coaches,contact;
    public centre(){

    }

    public centre(String nom, String adresse, String description, int nb_cours, int nb_coaches, int contact) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.nb_cours = nb_cours;
        this.nb_coaches = nb_coaches;
        this.contact = contact;
    }
    public centre(int id, String nom, String adresse, String description, int nb_cours, int nb_coaches, int contact) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.nb_cours = nb_cours;
        this.nb_coaches = nb_coaches;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNb_cours() {
        return nb_cours;
    }

    public void setNb_cours(int nb_cours) {
        this.nb_cours = nb_cours;
    }

    public int getNb_coaches() {
        return nb_coaches;
    }

    public void setNb_coaches(int nb_coaches) {
        this.nb_coaches = nb_coaches;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "centre{" +
                "id = "+id+
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", description='" + description + '\'' +
                ", nb_cours=" + nb_cours +
                ", nb_coaches=" + nb_coaches +
                ", contact=" + contact +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        centre centre = (centre) o;
        return id == centre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
