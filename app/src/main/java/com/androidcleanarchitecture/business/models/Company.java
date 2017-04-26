package com.androidcleanarchitecture.business.models;

import com.google.auto.value.AutoValue;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */
@AutoValue
public abstract class Company {

    abstract String name();
    abstract String catchPhrase();
    abstract String bs();

    public static Builder builder() {
        return new AutoValue_Company.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setName(String value);
        public abstract Builder setCatchPhrase(String value);
        public abstract Builder setBs(String value);
        public abstract Company build();
    }


}
