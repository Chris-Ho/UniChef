package com.example.unichef.ui.uploadRecipe;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.unichef.MainActivity;
import com.example.unichef.R;
import com.example.unichef.adapters.IngredientAdapter;
import com.example.unichef.adapters.UploadIngredientsAdapter;
import com.example.unichef.adapters.UploadTagsAdapter;
import com.example.unichef.database.Ingredient;
import com.example.unichef.database.Recipe;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UploadIngredientsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UploadIngredientsFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static  String[] INGREDIENTS = new String[]{
            "Apple", "Avocado", "Banana", "Bay Leaves", "Beef Stock", "Black Beans", "Brown Rice", "Butter", "Carrot", "Caster Sugar", "Cayenne", "Celery", "Cheddar Cheese",
            "Chicken Stock", "Chicken breast", "Chicken Drumstick", "Chicken Thigh", "Chicken Wing", "Chilli Powder", "Cinnamon", "Crushed Red Pepper Flakes", "Cumin",
            "Curry Powder", "Curry Sauce", "Dried Basil", "Dried Parsley", "Duck", "Egg", "Garlic", "Garlic Powder", "Ginger", "Granulated Sugar", "Green Pepper", "Ground coriander",
            "Ground cumin", "Hot Sauce", "Kidney Beans", "Lasagne Sheets", "Lemon", "Lime", "Minced Beef", "Minced Lamb", "Minced Pork", "Olive Oil", "Onion", "Onion Powder", "Oregano",
            "Pancetta", "Paprika", "Parmesan", "Pepper", "Potato", "Red Onion", "Red Pepper", "Red Chilli", "Salt", "Salted Butter", "Seasoned Salt", "Smoked Paprika", "Spaghetti",
            "Sugar", "Sweet Potato", "Tabasco", "Tinned Tomatoes", "Tomato", "Tomato Purée", "Tortilla", "Tuna", "Unsalted Butter", "Vegetable Oil", "White Rice", "Yellow Pepper"
    };
    NavController navController;
    Button addIngredient;
    Button next;
    Recipe recipe;
    ArrayList<Ingredient> ingredients;
    RecyclerView recyclerView;
    ArrayAdapter<String> chooseAdapter;
    UploadIngredientsAdapter uploadIngredientsAdapter;



    public UploadIngredientsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment uploadRecipe2.
     */
    // TODO: Rename and change types and number of parameters
    public static UploadIngredientsFragment newInstance(String param1, String param2) {
        UploadIngredientsFragment fragment = new UploadIngredientsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_upload_ingredients,
                container, false);

        assert getArguments() != null;
        this.recipe = UploadIngredientsFragmentArgs.fromBundle(getArguments()).getRecipeArg();
        this.ingredients = recipe.getIngredients();

        AutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.ingredient_autoCompleteTextView);
        this.chooseAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, INGREDIENTS);
        autoCompleteTextView.setAdapter(chooseAdapter);


        recyclerView = view.findViewById(R.id.recyclerView);
        this.uploadIngredientsAdapter = new UploadIngredientsAdapter(this.getContext(), ingredients);
        recyclerView.setAdapter(uploadIngredientsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        uploadIngredientsAdapter.setOnItemClickListener(new UploadIngredientsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //can add new functionality probably idk
                //edit the ingredients?
                return;
            }

            @Override
            public void onDeleteClick(int position) {
                ingredients.remove(position);
                uploadIngredientsAdapter.notifyDataSetChanged();
            }
        });


        navController = NavHostFragment.findNavController(this);



        addIngredient = (Button) view.findViewById(R.id.addIngredient_button);
        addIngredient.setOnClickListener(this);


        next = (Button) view.findViewById(R.id.button);
        next.setOnClickListener(this);

        return view;
        //return inflater.inflate(R.layout.fragment_upload_recipe2, container, false);
    }

    public void buildRecyclerView() {

    }

    @Override
    public void onClick(View view) {
        EditText amountTextView = (EditText) getView().findViewById(R.id.ingredientAmount_autoCompleteTextView);
        EditText ingredientTextView = (EditText) getView().findViewById(R.id.ingredient_autoCompleteTextView);
        switch (view.getId()) {
            case R.id.addIngredient_button:

                String amountString = amountTextView.getText().toString();
                String ingredientString = ingredientTextView.getText().toString();
                if (amountString.trim().length() == 0 || ingredientString.trim().length() == 0) {
                    amountTextView.setError("Please enter an amount");
                    ingredientTextView.setError("Please enter an ingredient");
                } else {
                    String ingredient = amountString + " " + ingredientString;
                    recipe.addIngredient(new Ingredient(ingredient));
                    amountTextView.getText().clear();
                    ingredientTextView.getText().clear();
                    this.uploadIngredientsAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.button:
                if (uploadIngredientsAdapter.getItemCount() == 0) {
                    amountTextView.setError("Please add an amount");
                    ingredientTextView.setError("Please add an ingredient");
                } else {
                    UploadIngredientsFragmentDirections.ActionUploadIngredientsFragmentToUploadEquipmentFragment action2 = UploadIngredientsFragmentDirections.actionUploadIngredientsFragmentToUploadEquipmentFragment();
                    action2.setRecipeArg(recipe);
                    Navigation.findNavController(view).navigate(action2);
                    //navController.navigate(new ActionOnlyNavDirections(R.id.action_navigation_uploadIngredients_to_navigation_uploadInstructions));
                }
                break;
            default:
                break;
        }
    }
}