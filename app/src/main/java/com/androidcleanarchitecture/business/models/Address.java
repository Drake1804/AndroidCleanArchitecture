package com.androidcleanarchitecture.business.models;

import com.google.auto.value.AutoValue;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */
@AutoValue
public abstract class Address {

    public abstract String street();

    public abstract String suite();

    public abstract String city();

    public abstract String zipcode();

    public abstract Geo geo();

    public static Builder builder() {
        return new AutoValue_Address.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setStreet(String value);

        public abstract Builder setSuite(String value);

        public abstract Builder setCity(String value);

        public abstract Builder setZipcode(String value);

        public abstract Builder setGeo(Geo value);

        public abstract Address build();
    }
}
