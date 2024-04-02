package edu.esprit.tests;

import edu.esprit.entities.centre;
import edu.esprit.service.centreValidation;
import edu.esprit.service.servicecentre;
import edu.esprit.utils.DataSource;

import java.util.Set;

public class maintest {
    public static void main(String[] args) {
        /*DataSource.getInstance();*/

        servicecentre sc= new servicecentre();
        centreValidation cv=new centreValidation();
        centre c = new centre("hhhhh","nn","centre a tester",2,3,22222222);
//        sc.supprimer(6);
     /*   if(cv.verifnotblank(c) && cv.verifnom(c.getNom()) && cv.verifadrese(c.getAdresse()) && cv.verifcontact(c.getContact()) && cv.verifnotnegatif(c.getNb_cours()) && cv.verifnotnegatif(c.getNb_coaches()))
        {sc.ajouter(c);}
        else {
            System.out.println(" ajout echoue:verifier controle saisie\n");
        }*/
       // System.out.println(sc.getall());
        centre camodif=sc.getOneById(7);
        camodif.setContact(29855583);
        camodif.setNb_coaches(5);
        camodif.setNom("sbou");
        if(cv.verifnotblank(camodif) && cv.verifnom(camodif.getNom()) && cv.verifadrese(camodif.getAdresse()) && cv.verifcontact(camodif.getContact()) && cv.verifnotnegatif(camodif.getNb_cours()) && cv.verifnotnegatif(camodif.getNb_coaches()))
        {
            sc.modifier(camodif);
    }else {
        System.out.println(" modification  echoue:verifier controle saisie\n");
    }
        System.out.println(sc.getOneById(7));


    }
}
