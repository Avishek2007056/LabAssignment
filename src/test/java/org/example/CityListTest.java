package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList dummyCityList() {
        CityList cityList = new CityList();
        cityList.add(dummyCity());
        return cityList;
    }
    private City dummyCity() {
        return new City("London", "Manchester");
    }
    @Test
    public void testdelete(){
        CityList cityList = new CityList();
        City city = new City("Rajbari","Rangpur");
        City city2 = new City("Sylhet","Barisal");
        cityList.add(city);
        cityList.add(city2);

        cityList.delete(city);
        assertFalse(cityList.getCities(1).contains(city));
        assertEquals(1,cityList.getCities(1).size());
    }
    @Test
    public void testdeleteexception(){
        CityList cityList = new CityList();
        City city = new City("Chuadanga","Gopalgonj");
        City city2 = new City("Feni","Bagerhat");
        cityList.add(city);
        cityList.add(city2);

        assertEquals(2,cityList.count());
        cityList.delete(city);

        assertEquals(1,cityList.count());
        assertThrows(IllegalArgumentException.class ,()-> {
            cityList.delete(city);
        });
    }
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("zilla1","state1");
        City city2 = new City("zilla2","state2");
        cityList.add(city);
        cityList.add(city2);

        cityList.count();
        assertEquals(2,cityList.getCities(1).size());
    }
    @Test
    public void testSortCities() {
        CityList cityList = new CityList();
        City city = new City("Derbin" , "Abu Dhabi");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));

        City city1 = new City("DisneyLand", "WonderLand");
        cityList.add(city1);

        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city.compareTo(cityList.getCities(1).get(1)));
    }
}