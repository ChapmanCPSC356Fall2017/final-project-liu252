package edu.chapman.cpsc356.restaurants;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by dusti on 12/9/2017.
 */

public class RestaurantSelectionActivity extends MainActivity
    {
        public static final String EXTRA_RESTAURANTS_ID = "crime_id";

        @Override
        protected Fragment getFragment()
        {
            Bundle extras = getIntent().getExtras();

            RestaurantSelectionFragment fragment = new RestaurantSelectionFragment();
            fragment.setArguments(extras);

            return fragment;
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.add_menu,menu);

            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            switch(item.getItemId())
            {
                case R.id.menu_add_restaurant:
                    Intent intent = new Intent(this, AddRestaurantActivity.class);
                    startActivity(intent);

                default:
                    return false;
            }
        }
    }
