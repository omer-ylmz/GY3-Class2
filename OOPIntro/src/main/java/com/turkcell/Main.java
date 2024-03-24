package com.turkcell;


import com.turkcell.business.BrandManager;
import com.turkcell.dataAccess.JdbcBrandDao;
import com.turkcell.entities.BaseEntity;
import com.turkcell.entities.Brand;
import com.turkcell.entities.Model;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Brand brand1 = new Brand();
        brand1.setName("BMW");
        brand1.setId(1);
        Brand brand2 = new Brand();
        brand2.setName("Mercedes");
        brand2.setId(2);

        Model model1 = new Model();
        model1.setName("Series 1");
        model1.setId(3);

        BaseEntity[] entities = {brand1,brand2,model1};



        BrandManager brandManager = new BrandManager(new JdbcBrandDao());
        brandManager.add(brand1);
        brandManager.add(brand2);
        List<Brand> brands =  brandManager.getAll();

        for ( Brand brand : brands){
            System.out.println(brand.getName());
        }


    }
}

//bu e ticaret sisteminde metotlar( loglanmak istiyor. Loglama alternatifi ise file, db, elasticsearch kullanılıyor
//sistemde hiç log kullanılmaya da bilir. Tüm loggerlar da kullanıblabilir

//output

//ekleme operasyonu file ve
//ekleme operasyonu file üzerinde eklendi
// elasticsearche loglandı