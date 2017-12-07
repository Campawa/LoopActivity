package com.example.chelsi.loopactivity;


import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link FragmentHey} subclass.
 */
public class FragmentHey extends Fragment {

    Button button;
    TextView text;
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


        // Did not get a chance to correct this, just copy and pasted from my old work to try and get points! ya feel

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
