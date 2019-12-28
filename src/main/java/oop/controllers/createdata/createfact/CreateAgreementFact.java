package oop.controllers.createdata.createfact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import oop.controllers.createdata.createentity.CreateCountryEntity;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.entity.Entity;
import oop.models.entity.impl.CountryEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;

public class CreateAgreementFact {

    public List<AgreementFact> createAgreementFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<AgreementFact> listfact = new ArrayList<AgreementFact>();
        List<CountryEntity> listCountry = new ArrayList<CountryEntity>();
        int count = 0;
        for (Entity entity : listEntity){
            if (entity instanceof CountryEntity){
                listCountry.add((CountryEntity) entity);
                count++;
            }
        }
        AgreementFact agreementFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            agreementFact = new AgreementFact();
            agreementFact.setId(String.valueOf(System.currentTimeMillis()));
            agreementFact.setSubject(listCountry.get(random.nextInt(count)));
            agreementFact.setObject(listCountry.get(random.nextInt(count)));
            //agreementFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(agreementFact);
        }
        /*try {
            factDao.insert((Fact<CountryEntity,CountryEntity>) listfact);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return listfact;
    }
}
