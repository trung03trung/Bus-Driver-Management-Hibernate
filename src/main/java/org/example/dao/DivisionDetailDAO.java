package org.example.dao;

import org.example.entity.Division;
import org.example.entity.DivisionDetail;

import java.util.List;

public interface DivisionDetailDAO {
    List<DivisionDetail> getAll();
    List<DivisionDetail> getAllByDivision(Division d);

    boolean addNew(DivisionDetail divisionDetail);

    boolean update(DivisionDetail divisionDetail);

    boolean delete(DivisionDetail divisionDetail);
}
