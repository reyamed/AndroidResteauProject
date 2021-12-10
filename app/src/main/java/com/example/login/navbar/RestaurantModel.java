package com.example.login.navbar;

public class RestaurantModel {
    private String Logo;
    private String Nom;
    private String Localisation;
    private String Rate;
    private String Description ;




    /* public RestaurantModel(int mRestaurantPic , String Nom, String Localisation, String Rate) {
        this.mRestaurantPic = mRestaurantPic;
        this.Nom = Nom;
        this.Localisation = Localisation;
        this.Rate = Rate;
    }
    public RestaurantModel() {

    } */

    public  String getLogo() { return Logo;}

    public String getNom() {
        return Nom;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public String getRate() {
        return Rate;
    }

    public String getDescription() {
        return Description;
    }
}
