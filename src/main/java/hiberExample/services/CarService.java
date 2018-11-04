package hiberExample.services;

import hiberExample.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    List<Car> getByCompany(String name);

    Car get(Long id);

    void create(Car car);

    void update(Car car);

    void delete(Long id);
}
