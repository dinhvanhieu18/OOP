package oop.controllers.createdata.createfact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import oop.controllers.createdata.createentity.CreateCountryEntity;
import oop.controllers.createdata.createentity.CreateEventEntity;
import oop.controllers.createdata.createentity.CreateOrganizationEntity;
import oop.controllers.createdata.createentity.CreatePersonEntity;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.entity.Entity;
import oop.models.entity.impl.CountryEntity;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.OrganizationEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;
import oop.models.fact.impl.AnnouncingFact;
import oop.models.fact.impl.AttendingFact;

public class CreateAttendingFact {

    public ArrayList<AttendingFact> createAttendingFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<AttendingFact> listfact = new ArrayList<AttendingFact>();
        List<OrganizationEntity> listOrganization = new ArrayList<OrganizationEntity>();
        int count = 0;
        for (Entity entity : listEntity){
            if (entity instanceof OrganizationEntity){
                listOrganization.add((OrganizationEntity) entity);
                count++;
            }
        }
        AttendingFact attendingFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            attendingFact = new AttendingFact();
            attendingFact.setId(String.valueOf(System.currentTimeMillis()));
            attendingFact.setSubject(listOrganization.get(random.nextInt(count)));
            attendingFact.setObject(listOrganization.get(random.nextInt(count)));
            //attendingFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(attendingFact);
        }
        /*try {
            factDao.insert((Fact<OrganizationEntity,OrganizationEntity>) listfact);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return listfact;
    }
}
