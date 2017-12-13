package edu.chapman.cpsc356.restaurants;

import android.support.v4.app.Fragment;

/**
 * Created by dusti on 12/13/2017.
 */

public class AddRestaurantActivity extends MainActivity
    {
        protected Fragment getFragment()
        {
            return new AddRestaurantFragment();
        }
    }
