package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CityList {
    private List<City> cities = new ArrayList<>();
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    public List<City> getCities(int f) {
        List<City> cityList = cities;
        if(f==1){
            Collections.sort(cityList);
        }
        else {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City c) {
                    return city.getProvinceName().compareTo(c.getProvinceName());
                }
            });
        }

        return cityList;
    }

    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        else {
            cities.remove(city);
        }
    }
    public int count(){
        return cities.size();
    }
}
