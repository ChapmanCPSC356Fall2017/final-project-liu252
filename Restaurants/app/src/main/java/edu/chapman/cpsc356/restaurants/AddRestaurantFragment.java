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
public class AddRestaurantFragment extends Fragment
    {
        private EditText newName;
        private EditText newRating;
        private EditText newAddress;
        private EditText newDetails;
        private Button create;

        public AddRestaurantFragment()
        {
            // Required empty public constructor
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            View v = inflater.inflate(R.layout.fragment_add_restaurant, container, false);

            newName = v.findViewById(R.id.restaurant_addName);
            newRating = v.findViewById(R.id.restaurant_addRating);
            newAddress = v.findViewById(R.id.restaurant_addAddress);
            newDetails = v.findViewById(R.id.restaurant_addDetails);
            create = v.findViewById(R.id.restaurant_createButton);

            create.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        RestaurantDetails newRestaurant = new RestaurantDetails();
                        newRestaurant.setRestaurantName(newName.getText().toString());
//
                        if(newRating.getText().toString().equals(null))
                        {
                            newRestaurant.setRestaurantRating(0.0);
                        }
                        else
                        {
                        newRestaurant.setRestaurantRating(Double.parseDouble((newRating.getText().toString())));
                        }
                        newRestaurant.setRestaurantLocation(newAddress.getText().toString());
                        newRestaurant.setRestaurantDetails(newDetails.getText().toString());

                        RestaurantCollection.getInstance().addRestaurant(newRestaurant);

                        Intent intent = new Intent(view.getContext(),RestaurantSelectionActivity.class);
                        startActivity(intent);


                    }
                });



            return v;
        }
    }
