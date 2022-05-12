package com.example.appdev_sheet5_exc2_bottomnavigation.ui.UnitConverter;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appdev_sheet5_exc2_bottomnavigation.R;
import com.example.appdev_sheet5_exc2_bottomnavigation.databinding.FragmentUnitConverterBinding;
import com.google.android.material.navigation.NavigationBarView;

public class UnitConverterFragment extends Fragment {

    private FragmentUnitConverterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UnitConverterViewModel unitConverterViewModel =
                new ViewModelProvider(this).get(UnitConverterViewModel.class);

        binding = FragmentUnitConverterBinding.inflate(inflater, container, false);

        TransitionInflater transitionInflater = TransitionInflater.from(requireContext());
        setExitTransition(transitionInflater.inflateTransition(R.transition.fade));
        setEnterTransition(transitionInflater.inflateTransition(R.transition.fade));

        //TextSwitcher textSwitcher = binding.textSwitcherFrom;
        Animation fade_in = AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_in);
        Animation fade_out = AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_out);

        binding.textSwitcherFrom.setInAnimation(fade_in);
        binding.textSwitcherFrom.setOutAnimation(fade_out);

        binding.textSwitcherFrom.setFactory(
                new ViewSwitcher.ViewFactory() {
                    @Override
                    public View makeView()
                    {
                        TextView textView = new TextView(getActivity());
                        return textView;
                    }
                });

        binding.textSwitcherTo.setInAnimation(fade_in);
        binding.textSwitcherTo.setOutAnimation(fade_out);

        binding.textSwitcherTo.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView()
            {
                TextView textView2 = new TextView(getActivity());
                return textView2;
            }
        });

        /*
        binding.textView.setOnClickListener(e->{
            binding.textView.setText("Test");
        });

         */

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String conversion_mode = binding.spinner.getSelectedItem().toString();

                switch (conversion_mode) {
                    case ("meter to inch"):
                        binding.textSwitcherFrom.setText("Meter");
                        binding.textSwitcherTo.setText("Inch");
                        break;
                    case ("inch to meter"):
                        binding.textSwitcherFrom.setText("Inch");
                        binding.textSwitcherTo.setText("Meter");
                        break;
                    case ("celsius to fahrenheit"):
                        binding.textSwitcherFrom.setText("Celsius");
                        binding.textSwitcherTo.setText("Fahrenheit");
                        break;
                    case ("fahrenheit to celcius"):
                        binding.textSwitcherFrom.setText("Fahrenheit");
                        binding.textSwitcherTo.setText("Celsius");
                        break;
                    case ("kilometers to miles"):
                        binding.textSwitcherFrom.setText("Kilometers");
                        binding.textSwitcherTo.setText("Miles");
                        break;
                    case ("miles to kilometers"):
                        binding.textSwitcherFrom.setText("Miles");
                        binding.textSwitcherTo.setText("Kilometers");
                        break;
                    case ("knots to meter per second"):
                        binding.textSwitcherFrom.setText("Knots");
                        binding.textSwitcherTo.setText("Meter");
                        break;
                    case ("meter per second to knots"):
                        binding.textSwitcherFrom.setText("Meter per Second");
                        binding.textSwitcherTo.setText("Knots");
                        break;
                    default:
                        ;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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