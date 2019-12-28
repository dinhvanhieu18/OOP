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
import oop.models.entity.impl.AgreementEntity;
import oop.models.entity.impl.CountryEntity;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;
import oop.models.fact.impl.AnnouncingFact;
import oop.models.fact.impl.HostingFact;

public class CreateHostingFact {

    public ArrayList<HostingFact> createHostingFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<HostingFact> listfact = new ArrayList<HostingFact>();
        List<CountryEntity> listCountry = new ArrayList<CountryEntity>();
        List<EventEntity> listEvent = new ArrayList<EventEntity>();
        int count1 = 0, count2 = 0;
        for (Entity entity : listEntity) {
            if (entity instanceof CountryEntity) {
                listCountry.add((CountryEntity) entity);
                count1++;
            } else if (entity instanceof EventEntity) {
                listEvent.add((EventEntity) entity);
                count2++;
            }
        }
        HostingFact hostingFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            hostingFact = new HostingFact();
            hostingFact.setId(String.valueOf(System.currentTimeMillis()));
            hostingFact.setSubject(listEvent.get(random.nextInt(count1)));
            hostingFact.setObject(listCountry.get(random.nextInt(count2)));
            //hostingFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(hostingFact);
        }
        /*try {
         factDao.insert((Fact<EventEntity,CountryEntity>) listfact);
         } catch (Exception e) {
         e.printStackTrace();
         }*/
        return listfact;
    }
}
