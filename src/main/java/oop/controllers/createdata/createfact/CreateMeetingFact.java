package oop.controllers.createdata.createfact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import oop.controllers.createdata.createentity.CreateCountryEntity;
import oop.controllers.createdata.createentity.CreatePersonEntity;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.entity.Entity;
import oop.models.entity.impl.CountryEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;
import oop.models.fact.impl.MeetingFact;

public class CreateMeetingFact {

    public ArrayList<MeetingFact> createMeetingFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<MeetingFact> listfact = new ArrayList<MeetingFact>();
        List<PersonEntity> listPerson = new ArrayList<PersonEntity>();
        int count = 0;
        for (Entity entity : listEntity){
            if (entity instanceof PersonEntity){
                listPerson.add((PersonEntity) entity);
                count++;
            }
        }
        MeetingFact meetingFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            meetingFact = new MeetingFact();
            meetingFact.setId(String.valueOf(System.currentTimeMillis()));
            meetingFact.setSubject(listPerson.get(random.nextInt(count)));
            meetingFact.setObject(listPerson.get(random.nextInt(count)));
            //meetingFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(meetingFact);
        }
        /*try {
            factDao.insert((Fact<PersonEntity,PersonEntity>) listfact);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return listfact;
    }
}
