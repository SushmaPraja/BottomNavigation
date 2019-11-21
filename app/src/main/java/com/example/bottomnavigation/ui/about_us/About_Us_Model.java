package com.example.bottomnavigation.ui.about_us;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class About_Us_Model extends ViewModel {

    private MutableLiveData<String> mText;

    public About_Us_Model() {
        mText = new MutableLiveData<>();
        mText.setValue("This is about us fragment");
    }

    public LiveData<String> getText() {

        return mText;
    }
}
