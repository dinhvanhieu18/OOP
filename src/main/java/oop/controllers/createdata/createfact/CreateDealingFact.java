package oop.controllers.createdata.createfact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import oop.controllers.createdata.createentity.CreateAgreementEntity;
import oop.controllers.createdata.createentity.CreateCountryEntity;
import oop.controllers.createdata.createentity.CreateEventEntity;
import oop.controllers.createdata.createentity.CreateOrganizationEntity;
import oop.controllers.createdata.createentity.CreatePersonEntity;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.entity.Entity;
import oop.models.entity.impl.AgreementEntity;
import oop.models.entity.impl.CountryEntity;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.OrganizationEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;
import oop.models.fact.impl.AnnouncingFact;
import oop.models.fact.impl.AttendingFact;
import oop.models.fact.impl.CancellationFact;
import oop.models.fact.impl.DealingFact;

public class CreateDealingFact {

    public ArrayList<DealingFact> createDealingFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<DealingFact> listfact = new ArrayList<DealingFact>();
        List<CountryEntity> listCountry = new ArrayList<CountryEntity>();
        int count = 0;
        for (Entity entity: listEntity){
            if (entity instanceof CountryEntity){
                listCountry.add((CountryEntity) entity);
                count++;
            }
        }
        DealingFact dealingFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            dealingFact = new DealingFact();
            dealingFact.setId(String.valueOf(System.currentTimeMillis()));
            dealingFact.setSubject(listCountry.get(random.nextInt(count)));
            dealingFact.setObject(listCountry.get(random.nextInt(count)));
            //dealingFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(dealingFact);
        }
        /*try {
            factDao.insert((Fact<CountryEntity,CountryEntity>) listfact);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return listfact;
    }
}
