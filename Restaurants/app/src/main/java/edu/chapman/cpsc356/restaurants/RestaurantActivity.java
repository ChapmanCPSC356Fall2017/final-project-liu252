package edu.chapman.cpsc356.restaurants;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by dusti on 12/8/2017.
 */

public class RestaurantActivity extends MainActivity
    {
        public static final String EXTRA_RESTAURANT_ID = "crime_id";


        protected Fragment getFragment()
        {

            Bundle extras = getIntent().getExtras();

            RestaurantFragment fragment = new RestaurantFragment();
            fragment.setArguments(extras);

            return fragment;
        }

    }
