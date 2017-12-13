package edu.chapman.cpsc356.restaurants;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Random;

/**
 * Created by dusti on 12/9/2017.
 */

public class RestaurantListActivity extends MainActivity
    {


        @Override
        protected Fragment getFragment()
        {
            return new RestaurantListFragment();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.add_and_randomize_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            switch(item.getItemId())
            {
                case R.id.menu_add_list:
                    Intent intent = new Intent(this, AddRestaurantsActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.menu_randomize:
                    int minusEmptyList = 0;
                    for(RestaurantList list : RestaurantCollection.getInstance().getRestaurants())
                    {
                        if(list.getRestaurants().size() == 0)
                        {
                            minusEmptyList++;
                        }
                    }
                    Random randomListNumber = new Random();
                    int r1 = randomListNumber.nextInt((RestaurantCollection.getInstance().getRestaurants().size()- minusEmptyList));
                    Random randomRestaurantNumber = new Random();
                    int r2  = randomRestaurantNumber.nextInt(RestaurantCollection.getInstance().getRestaurant(r1).size());

                    RestaurantSelectionAdapter.PREVIOUS_POSITION = r1;
                    RestaurantSelectionAdapter.CURRENT_POSITION = r2;

                    Intent randomIntent = new Intent(this, RestaurantActivity.class);
                    startActivity(randomIntent);
                    return true;


                default:
                    return false;
            }

        }
    }
