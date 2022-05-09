package com.example.appdev_sheet5_exc2_bottomnavigation.ui.CurrencyConverter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrencyConverterViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CurrencyConverterViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}