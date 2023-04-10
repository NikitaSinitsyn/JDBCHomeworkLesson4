package DAO;

import Application.City;

import java.util.List;


public interface CityDAO {
     City addCity(City city);

     City getCityById(int id);

     List<City> getAllCities();

     City updateCity(City city);

     void deleteCity(City city);
}
