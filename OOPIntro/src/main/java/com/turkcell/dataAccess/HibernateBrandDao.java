package com.turkcell.dataAccess;

import com.turkcell.entities.Brand;

import java.util.ArrayList;
import java.util.List;

public class HibernateBrandDao implements BrandDao{
    List<Brand> brandsDb = new ArrayList<>(); //normalde db olacak. Şuan yok diye böyle in memory


    public void add(Brand brand){
        System.out.println("Hibernate kullanarak ekledi");
        brandsDb.add(brand);
    }

    public List<Brand> getAll(){
        System.out.println("Hibernate kullanarak listeledi");


        return brandsDb;
    }
}

//bir eticaret projesi oluşturunuz
//Product--> id,name,unitPrice nesnesi için tüm işlemleri tekrarlayınız