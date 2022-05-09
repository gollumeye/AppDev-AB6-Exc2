package com.example.appdev_sheet5_exc2_bottomnavigation.ui.UnitConverter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appdev_sheet5_exc2_bottomnavigation.databinding.FragmentUnitConverterBinding;

public class UnitConverterFragment extends Fragment {

    private FragmentUnitConverterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UnitConverterViewModel unitConverterViewModel =
                new ViewModelProvider(this).get(UnitConverterViewModel.class);

        binding = FragmentUnitConverterBinding.inflate(inflater, container, false);

        binding.button.setOnClickListener(e->{
            String conversion_mode = binding.spinner.getSelectedItem().toString();
            Double to_value = 0.0;
            if(!binding.frominput.getText().toString().equals("")){
                Double from_value = Double.parseDouble(binding.frominput.getText().toString());

                switch (conversion_mode) {
                    case ("meter to inch"):
                        to_value = from_value * 39.3701;
                        break;
                    case ("inch to meter"):
                        to_value = from_value * 0.0254;
                        break;
                    case ("celsius to fahrenheit"):
                        to_value = from_value * (9 / 5) + 32;
                        break;
                    case ("fahrenheit to celcius"):
                        to_value = (from_value - 32) * (5 / 9);
                        break;
                    case ("kilometers to miles"):
                        to_value = from_value * 0.621371;
                        break;
                    case ("miles to kilometers"):
                        to_value = from_value * 1.609;
                        break;
                    case ("knots to meter per second"):
                        to_value = from_value * 0.51;
                        break;
                    case ("meter per second to knots"):
                        to_value = from_value * 1.94384;
                        break;
                    default:
                        ;
                }

                binding.toinput.setText(to_value.toString());
            }
            else{
                binding.toinput.setText("");
            }
        });


        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}