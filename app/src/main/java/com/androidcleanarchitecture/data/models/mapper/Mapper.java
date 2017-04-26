package com.androidcleanarchitecture.data.models.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public abstract class Mapper<K, T> {

    public abstract K map(T type);

    public List<K> mapList(List<T> typeList){

        List<K> list = new ArrayList<>();

        for( T type : typeList ){

            list.add( map( type ) );

        }

        return list;

    }
}
