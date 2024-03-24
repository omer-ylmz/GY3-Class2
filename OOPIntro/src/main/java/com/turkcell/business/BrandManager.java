package com.turkcell.business;

import com.turkcell.dataAccess.BrandDao;
import com.turkcell.dataAccess.JdbcBrandDao;
import com.turkcell.entities.Brand;

import java.util.List;

public class BrandManager {

    BrandDao brandDao;

    public BrandManager(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    public void add(Brand brand){
       // iş kuralları burada koşulur

        brandDao.add(brand);
    }

    public List<Brand> getAll(){

        return brandDao.getAll();
    }
}


//bu e ticaret sisteminde metotlar( loglanmak istiyor. Loglama alternatifi ise file, db, elasticsearch kullanılıyor
//sistemde hiç log kullanılmaya da bilir. Tüm loggerlar da kullanıblabilir

//output

//ekleme operasyonu file ve
//ekleme operasyonu file üzerinde eklendi
// elasticsearche loglandı