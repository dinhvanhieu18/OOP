package oop.controllers.createdata.createentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import oop.models.entity.impl.AgreementEntity;
import oop.controllers.dao.EntityDao;
import oop.models.entity.Entity;

public class CreateAgreementEntity {
    
    public ArrayList<AgreementEntity> createAgreement(int n) {
        ArrayList<AgreementEntity> list = new ArrayList<>();
        EntityDao entityDao = EntityDao.getInstance();
        AgreementEntity agreement;
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            agreement = new AgreementEntity();
            agreement.setId(String.valueOf(rd.nextLong()));
            agreement.setLabel(RandomStringUtils.randomAlphanumeric(10));
            agreement.setContent(RandomStringUtils.randomAlphanumeric(50));
            //entityDao.insert(agreement);
            list.add(agreement);

        }
        return list;
    }
}
