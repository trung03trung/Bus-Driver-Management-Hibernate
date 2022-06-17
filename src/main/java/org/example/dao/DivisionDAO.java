package org.example.dao;

import org.example.entity.Division;
import org.example.entity.Driver;

import java.util.List;

public interface DivisionDAO {
    List<Division> getAll();


    boolean addNew(Division division);

    List<Division> orderByNameDriver();

}
