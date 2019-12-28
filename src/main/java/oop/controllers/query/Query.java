package oop.controllers.query;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import oop.controllers.dao.ArticleDao;
import oop.controllers.dao.Dao;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.article.Article;
import oop.models.entity.Entity;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.*;


public class Query {
    //Co ban
    //1. Dua ra nam xuat ban cua mot Article SHOWARTICLE
    public static int publishedYear(String articleId) {
        ArticleDao articleDao = ArticleDao.getInstance();
        Article article = articleDao.get(articleId);
        Instant time = article.getPublishedDate();
        LocalDateTime dateTime = LocalDateTime.ofInstant(time, ZoneId.systemDefault());
        return dateTime.getYear();
    }

    //2. Lay label cua mot entity dua vao id
    public static String getLabel(String id) {
        EntityDao entitydao = EntityDao.getInstance();
        try {
            Entity entity = entitydao.get(id);
            return entity.getLabel();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //3. Lay content cua mot entity dua vao id
    public static String getContent(String id) {
        EntityDao entitydao = EntityDao.getInstance();
        try {
            Entity entity = entitydao.get(id);
            return entity.getContent();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //4. Lay dia diem cua mot Event
    public static Entity getLocation(String factId) {
        FactDao factDao = FactDao.getInstance();
        Fact eventFact = factDao.get(factId);
        return eventFact.getSubject();
    }

    //5. Lay subject cua mot fact
    public static Entity getSubject(String factId) {
        FactDao factDao = FactDao.getInstance();
        try {
            Fact fact =  factDao.get(factId);
            return fact.getSubject();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //6. Dua ra bai bao dua theo URL
    public static Article getArticleWithUrl(String url) {
        ArticleDao articleDao = ArticleDao.getInstance();
        List<Article> list = new ArrayList<>();
        list = articleDao.getAll();
        for (Article article : list) {
            if (article.getUrl().equals(url)) {
                return article;
            }
        }
        return null;
    }

    //7. Dua ra mot Article co nhieu fact nhat
    public static Article mostFactsArticle() {
        ArticleDao articleDao = ArticleDao.getInstance();
        List<Article> list = new ArrayList<>();
        list = articleDao.getAll();
        Article answer = null;
        int mostFacts = 0;
        for (Article article : list) {
            List<Fact<? extends Entity, ? extends Entity>> extractedFacts = article.getExtractedFacts();
            if (extractedFacts.size() > mostFacts) {
                mostFacts = extractedFacts.size();
                answer = article;
            }
        }
        return answer;
    }

    //8. Dua ra label dai nhat cua cac Entity
    public static String longestLabel() {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> list = entityDao.getAll();
        String answer = "";
        for (Entity entity : list) {
            if (entity.getLabel().length() > answer.length()) {
                answer = entity.getLabel();
            }
        }
        return answer;
    }

    //9. Dua ra Entity co content dai nhat
    public static Entity longestContentEntity() {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> list = entityDao.getAll();
        int longestContent = 0;
        Entity answer = null;
        for (Entity entity : list) {
            if (entity.getContent().length() > longestContent) {
                answer = entity;
                longestContent = answer.getContent().length();
            }
        }
        return answer;
    }

    //10. Dua ra Article co it fact nhat
    public static Article leastFactsArticle() {
        ArticleDao articleDao = ArticleDao.getInstance();
        List<Article> list = new ArrayList<>();
        list = articleDao.getAll();
        Article answer = null;
        int mostFacts = Integer.MAX_VALUE;
        for (Article article : list) {
            List<Fact<? extends Entity, ? extends Entity>> extractedFacts = article.getExtractedFacts();
            if (extractedFacts.size() < mostFacts) {
                mostFacts = extractedFacts.size();
                answer = article;
            }
        }
        return answer;
    }

    //Nang cao
    //1. Lay cac entity cang thang voi entity A
    public static List<Entity> tensionWith(String entityID) {
        Entity entity= EntityDao.getInstance().get(entityID);
        FactDao factDao = FactDao.getInstance();
        List<Fact<? extends Entity, ? extends Entity>> list = factDao.getAll();
        List<Entity> answer = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : list) {
            if (!(fact instanceof TensionFact)) continue;
            Entity subjectOfFact = fact.getSubject();
            if (subjectOfFact.getId().equals(entity.getId())) {
                answer.add(fact.getObject());
            }
        }
        return answer;
    }

    //2. Liet ke cac EventEntity duoc dien ra tai Location A
    public static List<Entity> eventAt(String entityID) {
        Entity entity= EntityDao.getInstance().get(entityID);
        FactDao factDao = FactDao.getInstance();
        List<Fact<? extends Entity, ? extends Entity>> list = factDao.getAll();
        List<Entity> answer = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : list) {
            if (!(fact instanceof HostingFact)) continue;
            Entity subjectOfFact = fact.getSubject();
            if (subjectOfFact.getId().equals(entity.getId())) {
                answer.add(fact.getObject());
            }
        }
        return answer;
    }

    //3.  Liet ke cac entity da meeting entity A
    public static List<Entity> meetingWith(String entityId) {
        EntityDao entityDao = EntityDao.getInstance();
        Entity entity = entityDao.get(entityId);
        FactDao factDao = FactDao.getInstance();
        List<Fact<? extends Entity, ? extends Entity>> list = factDao.getAll();
        List<Entity> answer = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : list) {
            if (!(fact instanceof MeetingFact)) continue;
            Entity subjectOfFact = fact.getSubject();
            Entity objectOfFact = fact.getObject();
            if (subjectOfFact.getId().equals(entity.getId())) {
                answer.add(fact.getObject());
            }
            if (objectOfFact.getId().equals(entity.getId())) {
                answer.add(fact.getSubject());
            }
        }
        return answer;
    }

    //4. Liet ke cac entity ung ho entity A
    public static List<Entity> supporterOf(String entityId) {
        EntityDao entityDao = EntityDao.getInstance();
        Entity entity = entityDao.get(entityId);
        FactDao factDao = FactDao.getInstance();
        List<Fact<? extends Entity, ? extends Entity>> list = factDao.getAll();
        List<Entity> answer = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : list) {
            if (!(fact instanceof SupportFact)) continue;
            Entity subjectOfFact = fact.getSubject();
            if (subjectOfFact.getId().equals(entity.getId())) {
                answer.add(fact.getObject());
            }
        }
        return answer;
    }

    //5. Liet ke cac Event duoc to chuc boi entity A
    public static List<Entity> organizerOf(String entityId) {
        EntityDao entityDao = EntityDao.getInstance();
        Entity entity = entityDao.get(entityId);
        FactDao factDao = FactDao.getInstance();
        List<Fact<? extends Entity, ? extends Entity>> list = factDao.getAll();
        List<Entity> answer = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : list) {
            if (!(fact instanceof OrganizingFact)) continue;
            Entity subjectOfFact = fact.getSubject();
            if (subjectOfFact.getId().equals(entity.getId())) {
                answer.add(fact.getObject());
            }
        }
        return answer;
    }

    //6. Dua ra cac Enitity co label la String string
    public static List<Entity> getEntityWithLable(String label) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> list = entityDao.getAll();
        List<Entity> answer = new ArrayList<>();
        for (Entity entity : list) {
            if (entity.getLabel().equals(label)) {
                answer.add(entity);
            }
        }
        return answer;
    }

    //7. Dua ra cac Entity Dealing voi Entity entity
    public static List<Entity> DealingWith(String entityId) {
        EntityDao entityDao = EntityDao.getInstance();
        Entity entity = entityDao.get(entityId);
        FactDao factDao = FactDao.getInstance();
        List<Fact<? extends Entity, ? extends Entity>> list = factDao.getAll();
        List<Entity> answer = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : list) {
            if (!(fact instanceof DealingFact)) continue;
            Entity subjectOfFact = fact.getSubject();
            if (subjectOfFact.getId().equals(entity.getId())) {
                answer.add(fact.getObject());
            }
        }
        return answer;
    }

    //8. Dua ra cac article co so fact >= x
    public static List<Article> ArticleFactsSizeGreater(int x) {
        ArticleDao articleDao = ArticleDao.getInstance();
        List<Article> list = articleDao.getAll();
        List<Article> answer = new ArrayList<>();
        for (Article article : list) {
            if (article.getExtractedFacts().size() >= x) {
                answer.add(article);
            }
        }
        return answer;
    }
    //9. Dua ra cac article co so fact < x  
    public static List<Article> ArticleFactsSizeSmaller(int x) {
        ArticleDao articleDao = ArticleDao.getInstance();
        List<Article> list = articleDao.getAll();
        List<Article> answer = new ArrayList<>();
        for (Article article : list) {
            if (article.getExtractedFacts().size() < x) {
                answer.add(article);
            }
        }
        return answer;
    }

    //10. Dua ra cac Entity da bi huy bo
    public static List<Entity> CancelledEntity() {
        FactDao factDao = FactDao.getInstance();
        List<Fact<? extends Entity, ? extends Entity>> list = factDao.getAll();
        List<Entity> answer = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : list) {
            if (!(fact instanceof CancellationFact)) continue;
            answer.add(fact.getSubject());
        }
        return answer;
    }

}
