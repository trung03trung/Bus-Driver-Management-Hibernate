package org.example.dao;

import org.example.entity.Division;
import org.example.entity.DivisionDetail;

import java.util.List;

public interface DivisionDetailDAO {
    List<DivisionDetail> getAll();


    boolean addNew(DivisionDetail divisionDetail);

}
