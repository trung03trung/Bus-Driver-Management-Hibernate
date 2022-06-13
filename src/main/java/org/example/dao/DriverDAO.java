package org.example.dao;

import org.example.entity.Driver;

import java.util.List;

public interface DriverDAO {
    List<Driver> getAll();

    Driver getOneById(int id);

    boolean addNew(Driver driver);

    boolean update(Driver driver);

    boolean delete(Driver driver);
}
