package edu.chapman.cpsc356.restaurants;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dusti on 12/9/2017.
 */

public class RestaurantList
    {
        private String id;
        private String listName;
        private List<RestaurantDetails> restaurants = new ArrayList<>();

        public RestaurantList() {this.id = UUID.randomUUID().toString();}


        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public List<RestaurantDetails> getRestaurants()
        {
            return restaurants;
        }

        public RestaurantDetails getRestaurant(int position)
        {
            return this.restaurants.get(position);
        }

        public void setRestaurants(List<RestaurantDetails> restaurants)
        {
            this.restaurants = restaurants;
        }

        public String getListName()
        {
            return listName;
        }

        public void setListName(String listName)
        {
            this.listName = listName;
        }
    }
