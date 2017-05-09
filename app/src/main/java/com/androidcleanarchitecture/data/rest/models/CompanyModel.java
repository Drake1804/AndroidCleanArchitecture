package com.androidcleanarchitecture.data.rest.models;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class CompanyModel {

    public String name;

    public String catchPhrase;

    public String bs;

    public CompanyModel() {
    }

    public CompanyModel(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
}
