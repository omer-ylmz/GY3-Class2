package com.turkcell.dataAccess;

import com.turkcell.entities.Brand;

import java.util.List;

public interface BrandDao {

     void add(Brand brand);
     List<Brand> getAll();
}
