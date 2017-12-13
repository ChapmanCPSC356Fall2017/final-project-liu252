package edu.chapman.cpsc356.restaurants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dusti on 12/8/2017.
 */

public class RestaurantCollection
    {
        public static RestaurantCollection collection;

        public static RestaurantCollection getInstance()
        {
            if (collection == null)
            {
                collection = new RestaurantCollection();
            }
            return collection;

        }

        private List<RestaurantList> restaurants;

        public RestaurantCollection()
        {
            this.restaurants = new ArrayList<>();

            RestaurantList l1 = new RestaurantList();
            l1.setListName("List 1");
            RestaurantDetails r1 = new RestaurantDetails();
            r1.setRestaurantName("Jimmy Johns");
            r1.setRestaurantRating(4.0);
            r1.setRestaurantLocation("Somewhere on Chapman Avenue");
            r1.setRestaurantDetails("Its pretty good");

            l1.getRestaurants().add(r1);

            RestaurantDetails r2 = new RestaurantDetails();
            r2.setRestaurantName("Class 302");
            r2.setRestaurantRating(4.5);
            r2.setRestaurantLocation("Somewhere on 17th Street");
            r2.setRestaurantDetails("Self Serve Boba");

            l1.getRestaurants().add(r2);

            restaurants.add(l1);


            RestaurantList List = new RestaurantList();
            List.setListName("Please work");
            RestaurantDetails Restaurant = new RestaurantDetails();
            Restaurant.setRestaurantDetails("I wish this wont replace the first list");

            List.getRestaurants().add(Restaurant);


            restaurants.add(List);


        }


        public List<RestaurantList> getRestaurants()
        {
            return this.restaurants;
        }

        public List<RestaurantDetails> getRestaurant(int previousPosition)
        {
            return this.restaurants.get(previousPosition).getRestaurants();
        }

        public void addRestaurants(RestaurantList restaurants)
        {
            this.restaurants.add(restaurants);
        }

        public void addRestaurant(RestaurantDetails restaurant)
        {
            this.restaurants.get(RestaurantSelectionAdapter.PREVIOUS_POSITION).getRestaurants().add(restaurant);
        }

        public void removeItem(int position)
        {
            this.restaurants.remove(position);
        }


        public RestaurantDetails getRestaurant(int previous, int current)
        {
            return this.restaurants.get(previous).getRetauarnt(current);
        }

        public RestaurantList getRestaurants(String id)
        {
            for (RestaurantList restaurants: this.restaurants)
            {
                if(restaurants.getId().equals(id))
                {
                    return restaurants;
                }
            }

            return null;
        }

        public void removeRestaurants(int position)
        {
            this.restaurants.remove(position);
        }

        public void removeRestaurants(int oldPosition, int currentPosition)
        {
            this.restaurants.get(oldPosition).getRestaurants().remove(currentPosition);
        }


        public RestaurantDetails getRestaurant(String id1, String id2)
        {
            for (RestaurantList restaurants: this.restaurants)
                if(restaurants.getId().equals(id1))
                {
                    for(RestaurantDetails restaurant: restaurants.getRestaurants())
                    {
                        if(restaurant.getId().equals(id2))
                        {
                            return restaurant;
                        }
                    }
                }
            return null;
        }


    }
