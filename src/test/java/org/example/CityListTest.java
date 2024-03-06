package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "AB");
    }
    @Test
    public void testdelete(){
        CityList cityList = new CityList();
        City city = new City("Faridpur","Rajshahi");
        City city2 = new City("Dhaka","Khulna");
        cityList.add(city);
        cityList.add(city2);

        cityList.delete(city);
        assertFalse(cityList.getCities(1).contains(city));
        assertEquals(1,cityList.getCities(1).size());
    }
    @Test
    public void testdeleteexception(){
        CityList cityList = new CityList();
        City city = new City("Chittagong","Tungipara");
        City city2 = new City("Sylhet","Dhaka");
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
        City city = new City("dummy1","hudai1");
        City city2 = new City("dummy2","hudai2");
        cityList.add(city);
        cityList.add(city2);

        cityList.count();
        assertEquals(2,cityList.getCities(1).size());
    }
    @Test
    public void testSortCities() {
        CityList cityList = new CityList();
        City city = new City("dumdum" , "Dubai");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));

        City city1 = new City("Abratown", "LaLaLand");
        cityList.add(city1);

        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city.compareTo(cityList.getCities(1).get(1)));
    }
}