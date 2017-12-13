package edu.chapman.cpsc356.restaurants;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;

/**
 * Created by dusti on 12/8/2017.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>
    {
        public static boolean swiped = false;

        @Override
        public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.cell_restaurant, parent, false);

            return new RestaurantViewHolder(v);
        }

        @Override
        public void onBindViewHolder(RestaurantViewHolder holder, int position)
        {
            RestaurantList restaurant = RestaurantCollection.getInstance().getRestaurants().get(position);


            holder.setup(restaurant);
        }



        @Override
        public int getItemCount()
        {
            return RestaurantCollection.getInstance().getRestaurants().size();
        }

        public void removeRestaurants(int position)
        {
            swiped = true;
            RestaurantCollection.getInstance().removeRestaurants(position);
            notifyDataSetChanged();
        }

        public void swap(int firstPosition, int secondPosition)
        {
            Collections.swap(RestaurantCollection.getInstance().getRestaurants(), firstPosition, secondPosition);
            notifyItemMoved(firstPosition, secondPosition);
        }

        public void update()
        {
            if(!swiped)
            {
                notifyDataSetChanged();
            }
            else
            {
                swiped = false;
            }
        }


        public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
            {
                private RestaurantList restaurant;

                private TextView restaurantName;

                public RestaurantViewHolder(View restaurantView)
                {
                    super (restaurantView);

                    restaurantView.setOnClickListener(this);

                    this.restaurantName = restaurantView.findViewById(R.id.tv_RestaurantName_cell);
                }

                public void setup(RestaurantList restaurant)
                {
                    this.restaurant = restaurant;

                    this.restaurantName.setText(restaurant.getListName());

                }


                public void onClick(View view)
                {
                    Intent intent = new Intent(view.getContext(), RestaurantSelectionActivity.class);
                    intent.putExtra(RestaurantSelectionActivity.EXTRA_RESTAURANTS_ID, this.restaurant.getId());

                    RestaurantSelectionAdapter.PREVIOUS_POSITION = getAdapterPosition();

                    view.getContext().startActivity(intent);
                }
            }
    }
