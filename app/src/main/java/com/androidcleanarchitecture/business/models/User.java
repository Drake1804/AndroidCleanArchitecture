package com.androidcleanarchitecture.business.models;

import com.google.auto.value.AutoValue;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */
@AutoValue
public abstract class User {

    abstract short id();
    abstract String name();
    abstract String username();
    abstract String email();
    abstract Address address();
    abstract String phone();
    abstract String website();
    abstract Company company();

    public static Builder builder() {
        return new AutoValue_User.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setId(short value);
        public abstract Builder setName(String value);
        public abstract Builder setUsername(String value);
        public abstract Builder setEmail(String value);
        public abstract Builder setAddress(Address value);
        public abstract Builder setPhone(String value);
        public abstract Builder setWebsite(String value);
        public abstract Builder setCompany(Company value);
        public abstract User build();
    }

}
