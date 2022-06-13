package org.example.dao;

import org.example.entity.Route;

import java.util.List;

public interface RouteDAO {
    List<Route> getAll();

    Route getOneById(int id);

    boolean addNew(Route route);

    boolean update(Route route);

    boolean delete(Route route);
}
