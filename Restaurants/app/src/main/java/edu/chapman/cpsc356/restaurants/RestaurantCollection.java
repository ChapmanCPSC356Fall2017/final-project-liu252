package edu.chapman.cpsc356.restaurants;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dusti on 12/8/2017.
 */

public class RestaurantCollection
    {
        public static RestaurantCollection collection;

        public static int restaurantCount = 0;
        public static String searchedText;

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
            l1.setListName("$$");

            RestaurantDetails l1r1 = new RestaurantDetails();
            l1r1.setRestaurantName("Dada Shabu Shabu Buffet");
            l1r1.setRestaurantRating(4.0);
            l1r1.setRestaurantLocation("4960 Irvine Blvd\n" +
                    "Ste 104\n" +
                    "Irvine, CA 92620");
            l1r1.setRestaurantDetails("All you can eat hot pot.\nWeekdays Lunch: 16.99\nWeekdays Dinner: 25.99\nWeekends All Day: 25.99");

            RestaurantDetails l1r2 = new RestaurantDetails();
            l1r2.setRestaurantName("Din Tai Fung");
            l1r2.setRestaurantRating(4.0);
            l1r2.setRestaurantLocation("South Coast Plaza\n" +
                    "3333 Bristol St\n" +
                    "Costa Mesa, CA 92626");

            RestaurantDetails l1r3 = new RestaurantDetails();
            l1r3.setRestaurantName("Stella Italianfare UTC");
            l1r3.setRestaurantRating(4.5);
            l1r3.setRestaurantLocation("8935 Towne Centre Dr\n" +
                    "Ste 113\n" +
                    "San Diego, CA 92122");

            RestaurantDetails l1r4 = new RestaurantDetails();
            l1r4.setRestaurantName("Gen Korean BBQ House");
            l1r4.setRestaurantRating(4.0);
            l1r4.setRestaurantLocation("13741 Newport Ave\n" +
                    "Tustin, CA 92780");

            l1.getRestaurants().add(l1r1);
            l1.getRestaurants().add(l1r2);
            l1.getRestaurants().add(l1r3);
            l1.getRestaurants().add(l1r4);



            RestaurantList l2 = new RestaurantList();
            l2.setListName("$");

            RestaurantDetails l2r1 = new RestaurantDetails();
            l2r1.setRestaurantName("In-N-Out Burger");
            l2r1.setRestaurantRating(4.5);
            l2r1.setRestaurantLocation("3501 E Chapman Ave\n" +
                    "Orange, CA 92869");

            RestaurantDetails l2r2 = new RestaurantDetails();
            l2r2.setRestaurantName("The Pizza Press");
            l2r2.setRestaurantRating(4.5);
            l2r2.setRestaurantLocation("155 N Glassell St\n" +
                    "Orange, CA 92866");


            RestaurantDetails l2r3 = new RestaurantDetails();
            l2r3.setRestaurantName("Curry House CoCo Ichibanya");
            l2r3.setRestaurantRating(3.5);
            l2r3.setRestaurantLocation("2710 Alton Pkwy\n" +
                    "Ste A-115\n" +
                    "Irvine, CA 92606");

            RestaurantDetails l2r4 = new RestaurantDetails();
            l2r4.setRestaurantName("Boiling Point");
            l2r4.setRestaurantRating(4.0);
            l2r4.setRestaurantLocation("Heritage Square\n" +
                    "14140 Culver Dr\n" +
                    "Irvine, CA 92604");

            l2.getRestaurants().add(l2r1);
            l2.getRestaurants().add(l2r2);
            l2.getRestaurants().add(l2r3);
            l2.getRestaurants().add(l2r4);

            RestaurantList l3 = new RestaurantList();
            l3.setListName("Desserts");

            RestaurantDetails l3r1 = new RestaurantDetails();
            l3r1.setRestaurantName("85°C Bakery Cafe");
            l3r1.setRestaurantRating(4.0);
            l3r1.setRestaurantLocation("Diamond Jamboree Shopping Center\n" +
                    "2700 Alton Pkwy\n" +
                    "Irvine, CA 92606");

            RestaurantDetails l3r2 = new RestaurantDetails();
            l3r2.setRestaurantName("Kung Fu Tea");
            l3r2.setRestaurantRating(4.5);
            l3r2.setRestaurantLocation("729 N Placentia Ave\n" +
                    "Fullerton, CA 92831");

            RestaurantDetails l3r3 = new RestaurantDetails();
            l3r3.setRestaurantName("The Loop Handcrafted Churros");
            l3r3.setRestaurantRating(3.5);
            l3r3.setRestaurantLocation("9729 Bolsa Ave\n" +
                    "Westminster, CA 92683");


            RestaurantDetails l3r4 = new RestaurantDetails();
            l3r4.setRestaurantName("7 Leaves Cafe");
            l3r4.setRestaurantRating(4.5);
            l3r4.setRestaurantLocation("13771 Newport Ave\n" +
                    "Ste12\n" +
                    "Tustin, CA 92780");

            l3.getRestaurants().add(l3r1);
            l3.getRestaurants().add(l3r2);
            l3.getRestaurants().add(l3r3);
            l3.getRestaurants().add(l3r4);



            restaurants.add(l1);
            restaurants.add(l2);
            restaurants.add(l3);


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
            return this.restaurants.get(previous).getRestaurant(current);
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

        public List<RestaurantDetails> searchRestaurants()
        {
            List<RestaurantDetails> search = new ArrayList<>();

            for(RestaurantList list : restaurants)
            {
                for(RestaurantDetails details : list.getRestaurants())
                {
                    if(!(details.getRestaurantName().equals("")))
                    {
                       if(details.getRestaurantName().toLowerCase().contains(searchedText))
                       {
                           search.add(details);
                       }
                    }
                }
            }

            return search;



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
