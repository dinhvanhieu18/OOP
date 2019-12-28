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

public class CreateCancellationFact {

    public ArrayList<CancellationFact> createCancellationFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<CancellationFact> listfact = new ArrayList<CancellationFact>();
        List<CountryEntity> listCountry = new ArrayList<CountryEntity>();
        List<AgreementEntity> listAgreement = new ArrayList<AgreementEntity>();
        int count1 = 0, count2 = 0;
        for (Entity entity : listEntity){
            if (entity instanceof CountryEntity){
                listCountry.add((CountryEntity) entity);
                count1++;
            }
            else if (entity instanceof AgreementEntity){
                listAgreement.add((AgreementEntity) entity);
                count2++;
            }
        }
        CancellationFact cancellationFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            cancellationFact = new CancellationFact();
            cancellationFact.setId(String.valueOf(System.currentTimeMillis()));
            cancellationFact.setSubject(listCountry.get(random.nextInt(count1)));
            cancellationFact.setObject(listAgreement.get(random.nextInt(count2)));
            //cancellationFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(cancellationFact);
        }
        /*try {
            factDao.insert((Fact<CountryEntity,AgreementEntity>) listfact);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return listfact;
    }
}
