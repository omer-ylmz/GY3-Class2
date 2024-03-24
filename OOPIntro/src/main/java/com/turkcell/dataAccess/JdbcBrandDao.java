package com.turkcell.dataAccess;

import com.turkcell.entities.Brand;

import java.util.ArrayList;
import java.util.List;

public class JdbcBrandDao implements BrandDao{
    List<Brand> brandsDb = new ArrayList<>(); //normalde db olacak. Şuan yok diye böyle in memory


    public void add(Brand brand){
        System.out.println("JDBC kullanarak ekledi");
        brandsDb.add(brand);
    }

    public List<Brand> getAll(){
        System.out.println("JDBC kullanarak listeledi");

        return brandsDb;
    }
}
