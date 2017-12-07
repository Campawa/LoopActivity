package com.example.chelsi.loopactivity;


import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link FragmentHey} subclass.
 */
public class FragmentHey extends Fragment {


    View rootView;
    public FragmentHey() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_, container, false);
        // We're going to be referring to this several times




        text = (EditText) rootView.findViewById(R.id.editText1);
        button = (Button) rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NextFragment nextFragment = new NextFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.firstFragmentContainer, nextFragment);
                fragmentTransaction.commit();

                Bundle bundle = new Bundle();
                bundle.putString("text", text.toString());
                nextFragment.setArguments(bundle);
            }
        });

        return rootView;
    }

}
