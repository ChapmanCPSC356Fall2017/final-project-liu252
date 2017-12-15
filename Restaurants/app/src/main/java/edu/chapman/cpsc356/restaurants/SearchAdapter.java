package edu.chapman.cpsc356.restaurants;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dusti on 12/14/2017.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>
    {
        public static int SEARCH_POSITION;

        @Override
        public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.cell_restaurant, parent, false);

            return new SearchViewHolder(v);
        }

        @Override
        public void onBindViewHolder(SearchViewHolder holder, int position)
        {
            RestaurantDetails restaurant = RestaurantCollection.getInstance().searchRestaurants().get(position);

            holder.setup(restaurant);
        }

        @Override
        public int getItemCount()
        {
            return RestaurantCollection.getInstance().searchRestaurants().size();
        }

        public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
            {
                private RestaurantDetails restaurant;
                private TextView name;

                public SearchViewHolder (View searchView)
                {
                    super(searchView);

                    searchView.setOnClickListener(this);

                    this.name = searchView.findViewById(R.id.tv_RestaurantName_cell);
                }

                public void setup(RestaurantDetails restaurant)
                {
                    this.restaurant = restaurant;

                    this.name.setText(restaurant.getRestaurantName());
                }

                public void onClick(View view)
                {
                    Intent intent = new Intent(view.getContext(), RestaurantActivity.class);

                    SEARCH_POSITION = getAdapterPosition();
                    RestaurantFragment.searchMode = true;

                    view.getContext().startActivity(intent);



                }
            }
    }
