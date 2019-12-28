package oop.controllers.createdata.createentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import oop.models.entity.impl.OrganizationEntity;
import oop.controllers.dao.EntityDao;
import oop.models.entity.Entity;

public class CreateOrganizationEntity {

    public ArrayList<OrganizationEntity> createOrganization(int n) {
        ArrayList<OrganizationEntity> list = new ArrayList<OrganizationEntity>();
        EntityDao entityDao = EntityDao.getInstance();
        OrganizationEntity organization;
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            organization = new OrganizationEntity();
            organization.setId(String.valueOf(rd.nextLong()));
            organization.setLabel(RandomStringUtils.randomAlphanumeric(10));
            organization.setContent(RandomStringUtils.randomAlphanumeric(50));
            organization.setField(RandomStringUtils.randomAlphanumeric(20));
            organization.setBaseOfOperation(RandomStringUtils.randomAlphanumeric(20));
            //entityDao.insert(organization);
            list.add(organization);
        }
        return list;
    }

}
