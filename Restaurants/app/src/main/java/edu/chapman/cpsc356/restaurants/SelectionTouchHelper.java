package edu.chapman.cpsc356.restaurants;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by dusti on 12/11/2017.
 */

public class SelectionTouchHelper extends ItemTouchHelper.SimpleCallback
    {
        private RestaurantSelectionAdapter selectionAdapter;

        public SelectionTouchHelper(RestaurantSelectionAdapter adapter)
        {
            super(ItemTouchHelper.UP|ItemTouchHelper.DOWN, ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT);
            this.selectionAdapter = adapter;
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target)
        {
            selectionAdapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());

            return true;
        }


        @Override
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder)
        {
            super.clearView(recyclerView, viewHolder);
            selectionAdapter.update();


        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
        {
            selectionAdapter.removeRestaurant(viewHolder.getAdapterPosition());
        }
    }
