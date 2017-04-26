package com.androidcleanarchitecture.business.models;

import com.google.auto.value.AutoValue;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */
@AutoValue
public abstract class Address {

    abstract String street();

    abstract String suite();

    abstract String city();

    abstract String zipcode();

    abstract Geo geo();

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
