package edu.chapman.cpsc356.restaurants;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment
    {
        private EditText restaurantName;
        private EditText restaurantRating;
        private EditText restaurantAddress;
        private EditText restaurantDetails;

        public static boolean searchMode;

        private RestaurantDetails restaurant;

        public RestaurantFragment()
        {
            // Required empty public constructor
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            if (!searchMode)
            {
                this.restaurant = RestaurantCollection.getInstance().getRestaurant(RestaurantSelectionAdapter.PREVIOUS_POSITION, RestaurantSelectionAdapter.CURRENT_POSITION);

            }
            else
            {
                this.restaurant = RestaurantCollection.getInstance().searchRestaurants().get(SearchAdapter.SEARCH_POSITION);
                searchMode = false;
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
            View v = inflater.inflate(R.layout.fragment_restaurant, container, false);

            this.restaurantName = v.findViewById(R.id.et_Name);
            this.restaurantName.setText(this.restaurant.getRestaurantName());

            this.restaurantRating = v.findViewById(R.id.et_Rating);
            this.restaurantRating.setText(Double.toString(this.restaurant.getRestaurantRating()));

            this.restaurantAddress = v.findViewById(R.id.et_Address);
            this.restaurantAddress.setText(this.restaurant.getRestaurantLocation());

            this.restaurantDetails = v.findViewById(R.id.et_Details);
            this.restaurantDetails.setText(this.restaurant.getRestaurantDetails());

            this.restaurantName.addTextChangedListener(new TextWatcher()
                {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void afterTextChanged(Editable editable)
                    {
                        restaurant.setRestaurantName(editable.toString());
                    }
                });

            this.restaurantRating.addTextChangedListener(new TextWatcher()
                {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void afterTextChanged(Editable editable)
                    {
                        restaurant.setRestaurantRating(Double.parseDouble(editable.toString()));
                    }
                });

            this.restaurantAddress.addTextChangedListener(new TextWatcher()
                {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void afterTextChanged(Editable editable)
                    {
                        restaurant.setRestaurantLocation(editable.toString());
                    }
                });

            this.restaurantDetails.addTextChangedListener(new TextWatcher()
                {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void afterTextChanged(Editable editable)
                    {
                        restaurant.setRestaurantDetails(editable.toString());
                    }
                });

            // Inflate the layout for this fragment
            return v;
        }

    }
