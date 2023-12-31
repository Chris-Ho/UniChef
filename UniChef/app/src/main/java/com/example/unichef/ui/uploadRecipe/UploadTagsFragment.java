package com.example.unichef.ui.uploadRecipe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.unichef.R;
import com.example.unichef.adapters.UploadTagsAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UploadTagsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UploadTagsFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button next;
    NavController navController;
    String tags[];
    RecyclerView recyclerView;

    public UploadTagsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment uploadRecipe4.
     */
    // TODO: Rename and change types and number of parameters
    public static UploadTagsFragment newInstance(String param1, String param2) {
        UploadTagsFragment fragment = new UploadTagsFragment();
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
        View view = inflater.inflate(R.layout.fragment_upload_tags,
                container, false);


        recyclerView = view.findViewById(R.id.tags_recycler_view);
        tags = getResources().getStringArray(R.array.tags);

        UploadTagsAdapter uploadTagsAdapter = new UploadTagsAdapter(this.getContext(), tags);
        recyclerView.setAdapter(uploadTagsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        navController = NavHostFragment.findNavController(this);
        next = (Button) view.findViewById(R.id.button);
        next.setOnClickListener(this);

        return view;
        //return inflater.inflate(R.layout.fragment_upload_recipe4, container, false);
    }

    @Override
    public void onClick(View view) {
        //navController.navigate(new ActionOnlyNavDirections(R.id.action_navigation_uploadTags_to_navigation_submitRecipe));
    }
}