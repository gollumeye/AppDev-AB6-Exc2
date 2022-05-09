package com.example.appdev_sheet5_exc2_bottomnavigation.ui.CurrencyConverter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appdev_sheet5_exc2_bottomnavigation.databinding.FragmentCurrencyConverterBinding;

public class CurrencyConverterFragment extends Fragment {

    private FragmentCurrencyConverterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CurrencyConverterViewModel currencyConverterViewModel =
                new ViewModelProvider(this).get(CurrencyConverterViewModel.class);

        binding = FragmentCurrencyConverterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button calculateButton = binding.button2;
        calculateButton.setOnClickListener(e->{

            String national_currency_input = binding.nationalCurrencyInput.getText().toString();
            String conversion_factor = binding.factorInput.getText().toString();
            String foreign_currency_input = binding.foreignCurrencyInput.getText().toString();

            if(!national_currency_input.equals("") && !conversion_factor.equals("")){
                Double nac = Double.valueOf(national_currency_input);
                Double factor = Double.valueOf(conversion_factor);

                Double foc = nac * factor;
                binding.foreignCurrencyInput.setText(foc.toString());
            }

            else if(!foreign_currency_input.equals("") && !conversion_factor.equals("")){
                Double foc = Double.valueOf(foreign_currency_input);
                Double factor = Double.valueOf(conversion_factor);

                Double nac = foc * (1/factor);
                binding.nationalCurrencyInput.setText(nac.toString());
            }
            else{
                Toast.makeText(getContext(),"Please enter one amount of currency and the conversion factor!",Toast.LENGTH_LONG).show();
            }

        });




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}