package com.example.appdev_sheet5_exc2_bottomnavigation.ui.UnitConverter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UnitConverterViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UnitConverterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}