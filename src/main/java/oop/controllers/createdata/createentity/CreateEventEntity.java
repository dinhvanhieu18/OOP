package oop.controllers.createdata.createentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import oop.models.entity.impl.EventEntity;
import oop.controllers.dao.EntityDao;
import oop.models.entity.Entity;

public class CreateEventEntity {

    public ArrayList<EventEntity> createEvent(int n) {
        ArrayList<EventEntity> list = new ArrayList<EventEntity>();
        EntityDao entityDao = EntityDao.getInstance();
        EventEntity event = null;
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            event = new EventEntity();
            event.setId(String.valueOf(rd.nextLong()));
            event.setLabel(RandomStringUtils.randomAlphanumeric(10));
            event.setContent(RandomStringUtils.randomAlphanumeric(50));
            //entityDao.insert(event);
            list.add(event);
        }
        return list;
    }
}
