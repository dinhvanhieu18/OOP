package oop.controllers.createdata.createentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import oop.models.entity.impl.CountryEntity;
import oop.controllers.dao.EntityDao;
import oop.models.entity.Entity;

/**
 *
 * @author MamXanhLapLanh
 */
public class CreateCountryEntity {

    public ArrayList<CountryEntity> createCountry(int n) {
        ArrayList<CountryEntity> list = new ArrayList<CountryEntity>();
        EntityDao entityDao = EntityDao.getInstance();
        CountryEntity country;
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            country = new CountryEntity();
            country.setId(String.valueOf(rd.nextLong()));
            country.setLabel(RandomStringUtils.randomAlphanumeric(10));
            country.setContent(RandomStringUtils.randomAlphanumeric(50));
            //entityDao.insert(country);
            list.add(country);
        }
        return list;
    }
}
