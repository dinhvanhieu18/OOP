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
import oop.models.fact.impl.MeetingFact;
import oop.models.fact.impl.ObjectionFact;
import oop.models.fact.impl.OrganizingFact;

public class CreateOrganizingFact {

    public ArrayList<OrganizingFact> createOrganizingFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<OrganizingFact> listfact = new ArrayList<OrganizingFact>();
        List<OrganizationEntity> listOrganization = new ArrayList<OrganizationEntity>();
        List<EventEntity> listEvent = new ArrayList<EventEntity>();
        int count1 = 0, count2 = 0;
        for (Entity entity : listEntity) {
            if (entity instanceof OrganizationEntity) {
                listOrganization.add((OrganizationEntity) entity);
                count1++;
            } else if (entity instanceof EventEntity) {
                listEvent.add((EventEntity) entity);
                count2++;
            }
        }
        OrganizingFact organizingFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            organizingFact = new OrganizingFact();
            organizingFact.setId(String.valueOf(System.currentTimeMillis()));
            organizingFact.setSubject(listOrganization.get(random.nextInt(count1)));
            organizingFact.setObject(listEvent.get(random.nextInt(count2)));
            //organizingFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(organizingFact);
        }
        /*try {
            factDao.insert((Fact<OrganizationEntity,EventEntity>) listfact);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return listfact;
    }
}
