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
import oop.models.fact.impl.TensionFact;

public class CreateTensionFact {

    public ArrayList<TensionFact> createTensionFact(int n) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> listEntity = entityDao.getAll();
        ArrayList<TensionFact> listfact = new ArrayList<TensionFact>();
        List<CountryEntity> listCountry = new ArrayList<CountryEntity>();
        int count = 0;
        for (Entity entity : listEntity){
            if (entity instanceof CountryEntity){
                listCountry.add((CountryEntity) entity);
                count++;
            }
        }
        TensionFact tensionFact;
        FactDao factDao = FactDao.getInstance();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            tensionFact = new TensionFact();
            tensionFact.setId(String.valueOf(System.currentTimeMillis()));
            tensionFact.setSubject(listCountry.get(random.nextInt(count)));
            tensionFact.setObject(listCountry.get(random.nextInt(count)));
            //tensionFact.setOriginId(String.valueOf(System.currentTimeMillis()));
            listfact.add(tensionFact);
        }
        /*try {
            factDao.insert((Fact<CountryEntity,CountryEntity>) listfact);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return listfact;
    }
}
