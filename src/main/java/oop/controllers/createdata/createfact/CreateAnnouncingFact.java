package oop.controllers.createdata.createfact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import oop.controllers.createdata.createentity.CreateCountryEntity;
import oop.controllers.createdata.createentity.CreateEventEntity;
import oop.controllers.createdata.createentity.CreatePersonEntity;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.entity.Entity;
import oop.models.entity.impl.CountryEntity;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;
import oop.models.fact.impl.AnnouncingFact;

public class CreateAnnouncingFact {

    public ArrayList<AnnouncingFact> createAnnouncingFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<AnnouncingFact> listfact = new ArrayList<AnnouncingFact>();
        List<PersonEntity> listPerson = new ArrayList<PersonEntity>();
        List<EventEntity> listEvent = new ArrayList<EventEntity>();
        int count1 = 0,count2 = 0;
        for (Entity entity : listEntity){
            if (entity instanceof PersonEntity){
                listPerson.add((PersonEntity) entity);
                count1++;
            }
            else if (entity instanceof EventEntity){
                listEvent.add((EventEntity) entity);
                count2++;
            }
        }
        AnnouncingFact announcingFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            announcingFact = new AnnouncingFact();
            announcingFact.setId(String.valueOf(System.currentTimeMillis()));
            announcingFact.setSubject(listPerson.get(random.nextInt(count1)));
            announcingFact.setObject(listEvent.get(random.nextInt(count2)));
            //announcingFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(announcingFact);
        }
        /*try {
            factDao.insert((Fact<PersonEntity,EventEntity>) listfact);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return listfact;
    }
}
