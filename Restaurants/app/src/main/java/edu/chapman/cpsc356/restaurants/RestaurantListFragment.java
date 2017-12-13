package edu.chapman.cpsc356.restaurants;


import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantListFragment extends Fragment
    {
        private RestaurantListAdapter adapter;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            View v = inflater.inflate(R.layout.fragment_restaurant_list, container,false);

            RecyclerView restaurantsListView = v.findViewById(R.id.rv_restaurants);

            this.adapter = new RestaurantListAdapter();
            restaurantsListView.setAdapter(adapter);

            restaurantsListView.setLayoutManager(new LinearLayoutManager(getActivity()));

            ItemTouchHelper.Callback callback = new ListTouchHelper(adapter);
            ItemTouchHelper helper = new ItemTouchHelper(callback);

            helper.attachToRecyclerView(restaurantsListView);




            return v;
        }

        public void onResume()
        {
            super.onResume();

            this.adapter.notifyDataSetChanged();
        }
    }
