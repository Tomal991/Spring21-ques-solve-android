package com.example.quessolve;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends Fragment {

    TextView tv1;
    EditText et1, et2;
    String sid;
    Button button;
    float w, m2,i;
    double body_mass,m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b_m_i, container, false);

        tv1 = v.findViewById(R.id.tv1);
        et1 = v.findViewById(R.id.et1);
        et2 = v.findViewById(R.id.et2);

        Bundle b = getArguments();
        sid = b.getString("sid");
        tv1.setText(sid);

        button = v.findViewById(R.id.bmi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w = Float.valueOf(et1.getText().toString());
                i = Float.valueOf(et2.getText().toString());
                m=i/39.37;
                m2 = (float) Math.pow(m, 2);
                body_mass = (w/m2);
                if(body_mass > 25){
                    Toast.makeText(getActivity(), "OverWeight : "+body_mass, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Not OverWeight : "+body_mass, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}