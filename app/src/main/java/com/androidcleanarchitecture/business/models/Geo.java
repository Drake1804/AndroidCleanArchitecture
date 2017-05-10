package com.androidcleanarchitecture.business.models;

import com.google.auto.value.AutoValue;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */
@AutoValue
public abstract class Geo {

    public abstract double lat();
    public abstract double lng();

    public static Builder builder() {
        return new AutoValue_Geo.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setLat(double value);
        public abstract Builder setLng(double value);
        public abstract Geo build();
    }

}
