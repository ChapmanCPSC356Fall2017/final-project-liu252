package edu.chapman.cpsc356.restaurants;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

                default:
                    return false;
            }

        }
    }
