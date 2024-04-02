package edu.esprit.service;

import edu.esprit.entities.centre;
import edu.esprit.utils.DataSource;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class servicecentre implements Iservice<centre>{
    Connection cnx= DataSource.getInstance().getCnx();

    @Override
    public void ajouter(centre centre) {
        String req="INSERT INTO `centre`( `nom`, `adresse`, `contact`, `nb_cours`, `nb_coaches`, `description`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, centre.getNom());
            ps.setString(2, centre.getAdresse());
            ps.setInt(3, centre.getContact());

            ps.setInt(4, centre.getNb_cours());
            ps.setInt(5, centre.getNb_coaches());
            ps.setString(6, centre.getDescription());
            ps.executeUpdate();
            System.out.println("centre ajoute avec succes");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       /* try {
            Statement st= cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("centre added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
    }

    @Override
    public void modifier(centre centre) {
          String req="UPDATE `centre` SET`nom`=?,`adresse`=?,`contact`=?,`nb_cours`=?,`nb_coaches`=?,`description`=? WHERE `id`=?";
        try {
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, centre.getNom());
            ps.setString(2, centre.getAdresse());
            ps.setInt(3, centre.getContact());

            ps.setInt(4, centre.getNb_cours());
            ps.setInt(5, centre.getNb_coaches());
            ps.setString(6, centre.getDescription());
            ps.setInt(7, centre.getId());
            ps.executeUpdate();
            System.out.println("centre modifié avec succes");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String req="DELETE FROM `centre` WHERE `id`=?";
        try {
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("centre supprime avec succes");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Set<centre> getall() {
       Set<centre> centres = new HashSet<>();

       String req="Select * from centre";
        try {
            Statement st= cnx.createStatement();
           ResultSet rs= st.executeQuery(req);
           while (rs.next())
           {
               int id=rs.getInt("id");
               String nom=rs.getString(2);
               String adresse=rs.getString(3);
               int contact=rs.getInt(4);
               int nbcr=rs.getInt(5);
               int nbch=rs.getInt(6);
               String desc=rs.getString("description");
               centre centre=new centre(id,nom,adresse,desc,nbcr,nbch,contact);
               centres.add(centre);
           }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return centres;
    }

    @Override
    public centre getOneById(int id) {
        String req="SELECT * FROM `centre` WHERE `id`="+id;
        try {
            Statement s= cnx.createStatement();
           ResultSet res= s.executeQuery(req);
//           int id, String nom, String adresse, String description, int nb_cours, int nb_coaches, int contact
            while (res.next()) {
                centre c = new centre(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(7),
                        res.getInt(5),
                        res.getInt(6),
                        res.getInt(4)
                );
                return c;
            }
            System.out.println("centre récupéré avec succes");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

