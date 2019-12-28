package oop.controllers.createdata.createarticle;

import java.time.Instant;
import java.util.AbstractList;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import oop.controllers.createdata.createfact.CreateAgreementFact;
import oop.controllers.createdata.createfact.CreateAnnouncingFact;
import oop.controllers.createdata.createfact.CreateAttendingFact;
import oop.controllers.createdata.createfact.CreateCancellationFact;
import oop.controllers.createdata.createfact.CreateDealingFact;
import oop.controllers.createdata.createfact.CreateHostingFact;
import oop.controllers.createdata.createfact.CreateMeetingFact;
import oop.controllers.createdata.createfact.CreateObjectionFact;
import oop.controllers.createdata.createfact.CreateOrganizingFact;
import oop.controllers.createdata.createfact.CreateSupportFact;
import oop.controllers.createdata.createfact.CreateTensionFact;
import oop.controllers.dao.FactDao;
import oop.models.article.Article;
import oop.models.entity.Entity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;

public class CreateArticle {

    public Article createArticle(int n) { //  Tạo 1 bài báo vs n facts
        FactDao factDao = FactDao.getInstance();
        List<Fact<? extends Entity, ? extends Entity>> facts = factDao.getAll();
        List<Fact<? extends Entity, ? extends Entity>> extractedFacts = new ArrayList<Fact<? extends Entity, ? extends Entity>>();
        Article article = new Article();
        article.setId(String.valueOf(System.currentTimeMillis()));
        article.setUrl(RandomStringUtils.randomAlphanumeric(10));
        article.setPublishedDate(Instant.now());
        Random random = new Random();
        /*CreateAgreementFact createAgreementFact = new CreateAgreementFact();
         CreateAnnouncingFact createAnnouncingFact = new CreateAnnouncingFact();
         CreateAttendingFact createAttendingFact = new CreateAttendingFact();
         CreateCancellationFact createCancellationFact = new CreateCancellationFact();
         CreateDealingFact createDealingFact = new CreateDealingFact();
         CreateHostingFact createHostingFact = new CreateHostingFact();
         CreateMeetingFact createMeetingFact = new CreateMeetingFact();
         CreateObjectionFact createObjectionFact = new CreateObjectionFact();
         CreateOrganizingFact createOrganizingFact = new CreateOrganizingFact();
         CreateSupportFact createSupportFact = new CreateSupportFact();
         CreateTensionFact createTensionFact = new CreateTensionFact();
         facts.add((Fact<? extends Entity, ? extends Entity>) createAgreementFact.createAgreementFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createAnnouncingFact.createAnnouncingFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createAttendingFact.createAttendingFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createCancellationFact.createCancellationFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createDealingFact.createDealingFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createHostingFact.createHostingFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createMeetingFact.createMeetingFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createObjectionFact.createObjectionFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createOrganizingFact.createOrganizingFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createSupportFact.createSupportFact(5));
         facts.add((Fact<? extends Entity, ? extends Entity>) createTensionFact.createTensionFact(5));*/
        for (int i = 0; i < n; i++) {
            extractedFacts.add(facts.get(random.nextInt(extractedFacts.size())));
        }
        for (Fact<? extends Entity, ? extends Entity> fact : extractedFacts) {
            fact.setOriginId(article.getId());
        }
        article.setExtractedFacts(extractedFacts);
        return article ;
    }
}
