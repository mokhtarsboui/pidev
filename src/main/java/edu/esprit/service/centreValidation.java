package edu.esprit.service;

import edu.esprit.entities.centre;

public class centreValidation {
    public boolean verifnotblank(centre c)
    {
        if(c.getNom().isBlank()||c.getNom().isEmpty()||c.getAdresse().isEmpty()||c.getAdresse().isBlank()||c.getDescription().isEmpty()||c.getDescription().isBlank()) {
            System.out.println("Tous les champs sont obligatoires");
            return false;
        }
        return true;
    }
   public boolean verifnom(String n)
   {

       if(n.length()<4 ||!(n.matches("^[A-Za-z]+$")))
       {
           System.out.println("Le Nom doit etre 4 characteres alphabetiques ou plus");
           return false;
       }
       return true;
   }
    public boolean verifadrese(String n)
    {

        for(int i=0;i<n.length();i++)
        {
            if ((((int)n.charAt(i)) >=33 && ((int)n.charAt(i))<=47)||(((int)n.charAt(i)) >=58 && ((int)n.charAt(i))<=64)||(((int)n.charAt(i)) >=91 && ((int)n.charAt(i))<=96))
            {
                System.out.println("adresse ne contient pas des caracteres speciaux");
                return false;
            }

        }
        return true;
    }
    public boolean verifnotnegatif(int n)
    {
        if(n<0)
        {
            System.out.println("Vaeur negatif pour nb_coach et nb_cours ne sont pas autorises");
            return false;
        }
        return true;
    }
    public boolean verifcontact(int n)
    {
        try
        {
            if (Integer.toString(n).length()!=8)
            {
                System.out.println("Contact est 8 nombres");
                return false;
            }
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
