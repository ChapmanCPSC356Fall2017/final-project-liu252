package edu.chapman.cpsc356.restaurants;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment
    {
        private SearchAdapter adapter;

        public SearchFragment()
        {
            // Required empty public constructor
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
        {
            View v = inflater.inflate(R.layout.fragment_search, container, false);

            RecyclerView searchView = v.findViewById(R.id.rv_restaurants_search);

            this.adapter = new SearchAdapter();
            searchView.setAdapter(adapter);

            searchView.setLayoutManager(new LinearLayoutManager(getActivity()));



            return v;
        }

    }
