package edu.chapman.cpsc356.restaurants;

import java.util.UUID;

/**
 * Created by dusti on 12/7/2017.
 */

public class RestaurantDetails
    {
        private String id;
        private String restaurantName = "";
        private double restaurantRating;
        private String restaurantLocation;
        private String restaurantDetails;

        public RestaurantDetails() {this.id = UUID.randomUUID().toString();}


        public String getRestaurantName()
        {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName)
        {
            this.restaurantName = restaurantName;
        }

        public double getRestaurantRating()
        {
            return restaurantRating;
        }

        public void setRestaurantRating(double restaurantRating)
        {
            this.restaurantRating = restaurantRating;
        }

        public String getRestaurantLocation()
        {
            return restaurantLocation;
        }

        public void setRestaurantLocation(String restaurantLocation)
        {
            this.restaurantLocation = restaurantLocation;
        }

        public String getRestaurantDetails()
        {
            return restaurantDetails;
        }

        public void setRestaurantDetails(String restaurantDetails)
        {
            this.restaurantDetails = restaurantDetails;
        }

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }
    }
