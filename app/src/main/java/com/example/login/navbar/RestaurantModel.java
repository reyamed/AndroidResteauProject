package com.example.login.navbar;

public class RestaurantModel {
    private int mRestaurantPic;
    private String mRestaurantName;
    private String mLocalisation;
    private String mRate;

    public RestaurantModel(int mRestaurantPic , String mRestaurantName, String mLocalisation, String mRate) {
        this.mRestaurantPic = mRestaurantPic;
        this.mRestaurantName = mRestaurantName;
        this.mLocalisation = mLocalisation;
        this.mRate = mRate;
    }

    public int getmRestaurantPic() {
        return mRestaurantPic;}

    public String getmRestaurantName() {
        return mRestaurantName;
    }

    public String getmLocalisation() {
        return mLocalisation;
    }

    public String getmRate() {
        return mRate;
    }
}
