package com.example.login.navbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView imageViewRestaurant ;
        public TextView TextViewRestaurantName;
        public TextView textViewLocalisation;
        public TextView textViewRate;
        //public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewRestaurantName = (TextView) itemView.findViewById(R.id.restaurantName);
            textViewLocalisation= (TextView) itemView.findViewById(R.id.localisation);
            textViewRate= (TextView) itemView.findViewById(R.id.rate);
            imageViewRestaurant = itemView.findViewById(R.id.restaurantPic);;
        }
    }
    private Context context;
    private List<RestaurantModel> mRestaurants;
    public RestaurantAdapter(Context c, List<RestaurantModel> postist){
        this.context = c;
        this.mRestaurants = postist;
    }

    @NonNull
    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_restau, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        RestaurantModel restaurant = mRestaurants.get(position);

        // Set item views based on your views and data model
        TextView textViewRestaurantName = holder.TextViewRestaurantName;
        textViewRestaurantName.setText(restaurant.getmRestaurantName());

        TextView textViewMLocalisation = holder.textViewLocalisation;
        textViewMLocalisation.setText(restaurant.getmLocalisation());

        TextView textViewMRate = holder.textViewRate;
        textViewMRate.setText(restaurant.getmRate());

        /*ImageView ImageViewRestaurant = holder.imageViewRestaurant;
        ImageViewRestaurant.setText(restaurant.getmRestaurantPic());
*/
        holder.imageViewRestaurant.setImageResource(restaurant.getmRestaurantPic());
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }
}
