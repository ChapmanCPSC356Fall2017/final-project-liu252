package edu.chapman.cpsc356.restaurants;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantListFragment extends Fragment
    {
        private RestaurantListAdapter adapter;
        private ImageButton search;
        private EditText searchText;

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

            this.search = v.findViewById(R.id.search);
            this.searchText = v.findViewById(R.id.search_text);

            search.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        if(!(searchText.getText().toString().equals("")))
                        {
                            RestaurantCollection.searchedText = searchText.getText().toString().toLowerCase();
                            if(RestaurantCollection.getInstance().searchRestaurants().size()!=0)
                            {
                                Intent intent = new Intent(view.getContext(), SearchActivity.class);
                                startActivity(intent);
                            }
                        }
                    }
                });






            return v;
        }

        public void onResume()
        {
            super.onResume();

            this.adapter.notifyDataSetChanged();
        }

    }
