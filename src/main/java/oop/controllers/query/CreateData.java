/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.controllers.query;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import oop.controllers.createdata.createarticle.CreateArticle;
import oop.controllers.createdata.createentity.CreateAgreementEntity;
import oop.controllers.createdata.createentity.CreateCountryEntity;
import oop.controllers.createdata.createentity.CreateEventEntity;
import oop.controllers.createdata.createentity.CreateLocationEntity;
import oop.controllers.createdata.createentity.CreateOrganizationEntity;
import oop.controllers.createdata.createentity.CreatePersonEntity;
import oop.controllers.createdata.createfact.CreateAgreementFact;
import oop.controllers.createdata.createfact.CreateAnnouncingFact;
import oop.controllers.createdata.createfact.CreateAttendingFact;
import oop.controllers.createdata.createfact.CreateCancellationFact;
import oop.controllers.createdata.createfact.CreateDealingFact;
import oop.controllers.createdata.createfact.CreateHostingFact;
import oop.controllers.createdata.createfact.CreateMeetingFact;
import oop.controllers.createdata.createfact.CreateObjectionFact;
import oop.controllers.createdata.createfact.CreateSupportFact;
import oop.controllers.createdata.createfact.CreateTensionFact;
import oop.controllers.dao.ArticleDao;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.entity.Entity;
import oop.models.entity.impl.AgreementEntity;
import oop.models.entity.impl.CountryEntity;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.LocationEntity;
import oop.models.entity.impl.OrganizationEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;

/**
 *
 * @author Admin
 */
public class CreateData {

    public void createEntity(int[] entity) {
        EntityDao entityDao = EntityDao.getInstance();
        CreateAgreementEntity createAgreementEntity = new CreateAgreementEntity();
        List<AgreementEntity> l1;
        l1 = createAgreementEntity.createAgreement(entity[0]);
        entityDao.insert(l1);
       // entityDao.insert((Entity) createCountryEntity.createCountry(entity[1]));
        CreateCountryEntity creatAgreeCountryEntity = new CreateCountryEntity();
        List<CountryEntity> ll ;
        ll = creatAgreeCountryEntity.createCountry(entity[2]);
        entityDao.insert(ll);
        CreateEventEntity createEventEntity = new CreateEventEntity();
        List<EventEntity> l2;
        l2 = createEventEntity.createEvent(entity[1]);
        entityDao.insert(l2);
       //entityDao.insert((Entity) createEventEntity.createEvent(entity[2]));
        CreateLocationEntity createLocationEntity = new CreateLocationEntity();
        List<LocationEntity> l3;
        l3 = createLocationEntity.createLocation(entity[2]);
        entityDao.insert(l3);
        //entityDao.insert((List<LocationEntity>) createLocationEntity.createLocation(entity[3]));
        CreateOrganizationEntity createOrganizationEntity = new CreateOrganizationEntity();
        
        entityDao.insert((List<OrganizationEntity>) createOrganizationEntity.createOrganization(entity[4]));
        CreatePersonEntity createPersonEntity = new CreatePersonEntity();
        entityDao.insert((List<PersonEntity>) createPersonEntity.createPerson(entity[5]));
    }

    public void createFact(int[] fact) {
        FactDao factDao = FactDao.getInstance();
        CreateAgreementFact createAgreementFact = new CreateAgreementFact();
        factDao.insert(createAgreementFact.createAgreementFact(fact[9 - 9]));
        CreateAnnouncingFact createAnnouncingFact = new CreateAnnouncingFact();
        factDao.insert(createAnnouncingFact.createAnnouncingFact(fact[1]));
        CreateAttendingFact createAttendingFact = new CreateAttendingFact();
        factDao.insert(createAttendingFact.createAttendingFact(fact[2]));
        CreateCancellationFact createCancellationFact = new CreateCancellationFact();
        factDao.insert(createCancellationFact.createCancellationFact(fact[3]));
        CreateDealingFact createDealingFact = new CreateDealingFact();
        factDao.insert(createDealingFact.createDealingFact(fact[4]));
        CreateHostingFact createHostingFact = new CreateHostingFact();
        factDao.insert(createHostingFact.createHostingFact(fact[5]));
        CreateMeetingFact createMeetingFact = new CreateMeetingFact();
        factDao.insert(createMeetingFact.createMeetingFact(fact[6]));
        CreateObjectionFact createObjectionFact = new CreateObjectionFact();
        factDao.insert(createObjectionFact.createObjectionFact(fact[7]));
        CreateSupportFact createSupportFact = new CreateSupportFact();
        factDao.insert(createSupportFact.createSupportFact(fact[9]));
        CreateTensionFact createTensionFact = new CreateTensionFact();
        factDao.insert(createTensionFact.createTensionFact(fact[19 - 9]));
    }

    public void createArticle() {
        ArticleDao articleDao = ArticleDao.getInstance();
        CreateArticle createArticle = new CreateArticle();
        articleDao.insert(createArticle.createArticle(9));
    }
}
