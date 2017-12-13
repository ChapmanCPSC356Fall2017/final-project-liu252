package edu.chapman.cpsc356.restaurants;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by dusti on 12/9/2017.
 */

public class RestaurantSelectionAdapter extends RecyclerView.Adapter<RestaurantSelectionAdapter.RestaurantSelectionViewHolder>
    {
        public static int PREVIOUS_POSITION;
        public static int CURRENT_POSITION;

        private static boolean swiped = false;

        @Override
        public RestaurantSelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.cell_restaurant, parent, false);

            return new RestaurantSelectionViewHolder(v);
        }

        @Override
        public void onBindViewHolder(RestaurantSelectionViewHolder holder, int position)
        {
            RestaurantDetails restaurant = RestaurantCollection.getInstance().getRestaurant(PREVIOUS_POSITION).get(position); //POSITIONS MESSED UP FIX AND FIND RIGHT POSITIONS


            holder.setup(restaurant);
        }

        @Override
        public int getItemCount()
        {
            return RestaurantCollection.getInstance().getRestaurant(PREVIOUS_POSITION).size();
        }

        public void removeRestaurant(int position)
        {
            swiped = true;
            RestaurantCollection.getInstance().removeRestaurants(PREVIOUS_POSITION, position);
            notifyDataSetChanged();
        }

        public void swap(int firstPosition, int secondPosition)
        {
            Collections.swap(RestaurantCollection.getInstance().getRestaurant(PREVIOUS_POSITION), firstPosition, secondPosition);
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

        public class RestaurantSelectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
            {
                private RestaurantDetails restaurant;

                private TextView name;

                public RestaurantSelectionViewHolder (View restaurantSelectionView)
                {
                    super(restaurantSelectionView);

                    restaurantSelectionView.setOnClickListener(this);

                    this.name = restaurantSelectionView.findViewById(R.id.tv_RestaurantName_cell);

                }

                public void setup(RestaurantDetails restaurant)
                {
                    this.restaurant = restaurant;

                    this.name.setText(restaurant.getRestaurantName());
                }

                public void onClick(View view)
                {
                    Intent intent = new Intent(view.getContext(), RestaurantActivity.class);
                    intent.putExtra(RestaurantSelectionActivity.EXTRA_RESTAURANTS_ID, RestaurantSelectionActivity.EXTRA_RESTAURANTS_ID);
                    intent.putExtra(RestaurantActivity.EXTRA_RESTAURANT_ID, this.restaurant.getId());

                    CURRENT_POSITION = getAdapterPosition();

                    view.getContext().startActivity(intent);
                }
            }
    }
