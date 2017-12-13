package edu.chapman.cpsc356.restaurants;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddRestaurantsFragment extends Fragment
    {
        private EditText newListName;
        private Button confirm;

        public AddRestaurantsFragment()
        {
            // Required empty public constructor
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            View v = inflater.inflate(R.layout.fragment_add_restaurants, container, false);

            this.newListName = v.findViewById(R.id.list_addName);
            this.confirm = v.findViewById(R.id.list_createButton);

            this.confirm.setOnClickListener(new View.OnClickListener()
                {

                    @Override
                    public void onClick(View view)
                    {
                        RestaurantList newList = new RestaurantList();
                        newList.setListName(newListName.getText().toString());
                        RestaurantCollection.getInstance().addRestaurants(newList);

                        returnToMainScreen(view);
                    }
                });


            return v;
        }

        private void returnToMainScreen(View view)
        {
            Intent intent = new Intent(view.getContext(), RestaurantListActivity.class);

            startActivity(intent);
        }


    }
