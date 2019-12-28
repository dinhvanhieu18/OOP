package oop.controllers.createdata.createentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import oop.models.entity.impl.LocationEntity;
import oop.controllers.dao.EntityDao;
import oop.models.entity.Entity;

public class CreateLocationEntity {
    public CreateLocationEntity(){
        createLocation(100);
    }
    public ArrayList<LocationEntity> createLocation(int n) {
        ArrayList<LocationEntity> list = new ArrayList<LocationEntity>();
        EntityDao entityDao = EntityDao.getInstance();
        Random random = new Random();
        LocationEntity location = null;
        for (int i = 0; i < n; i++) {
            location = new LocationEntity();
            location.setId(String.valueOf(random.nextLong()));
            location.setLabel(RandomStringUtils.randomAlphanumeric(10));
            location.setContent(RandomStringUtils.randomAlphanumeric(50));
            location.setLongitude(random.nextDouble());
            location.setLatitude(random.nextDouble());
            //entityDao.insert(location);
            list.add(location);

        }
        return list;
    }
}
