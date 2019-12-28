package oop.controllers.createdata.createentity;

import org.apache.commons.lang3.RandomStringUtils;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.models.entity.impl.PersonEntity;
import oop.controllers.dao.EntityDao;
import oop.models.entity.Entity;

public class CreatePersonEntity {

    public ArrayList<PersonEntity> createPerson(int n) {
        ArrayList<PersonEntity> list = new ArrayList<PersonEntity>();
        EntityDao entityDao = EntityDao.getInstance();
        PersonEntity person;
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            person = new PersonEntity();
            person.setId(String.valueOf(rd.nextLong()));
            person.setLabel(RandomStringUtils.randomAlphanumeric(10));
            person.setContent(RandomStringUtils.randomAlphanumeric(50));
            person.setBirthday(Instant.now());
            person.setDateOfDeath(Instant.now());
            person.setOccupation(RandomStringUtils.randomAlphanumeric(10));
            //entityDao.insert(person);
            list.add(person);
        }
       
        return list;
    }
}
