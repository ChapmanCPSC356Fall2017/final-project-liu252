package edu.chapman.cpsc356.restaurants;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by dusti on 12/11/2017.
 */

public class ListTouchHelper extends ItemTouchHelper.SimpleCallback
    {
        private RestaurantListAdapter listAdapter;

        public ListTouchHelper(RestaurantListAdapter adapter)
        {
            super(ItemTouchHelper.UP|ItemTouchHelper.DOWN, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT);
            this.listAdapter = adapter;
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target)
        {
            listAdapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());

            return true;
        }

        @Override
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder)
        {
            super.clearView(recyclerView, viewHolder);
            listAdapter.update();

        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
        {
            listAdapter.removeRestaurants(viewHolder.getAdapterPosition());
        }
    }
