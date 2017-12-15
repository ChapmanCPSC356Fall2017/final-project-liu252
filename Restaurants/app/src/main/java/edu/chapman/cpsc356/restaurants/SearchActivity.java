package edu.chapman.cpsc356.restaurants;

import android.support.v4.app.Fragment;

/**
 * Created by dusti on 12/14/2017.
 */

public class SearchActivity extends MainActivity
    {
        protected Fragment getFragment()
        {
            return new SearchFragment();
        }

    }