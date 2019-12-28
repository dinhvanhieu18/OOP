package oop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import oop.controllers.createdata.createentity.CreateAgreementEntity;

import oop.controllers.dao.ArticleDao;
import oop.controllers.dao.Dao;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.controllers.query.CreateData;
import oop.controllers.query.ReadQuery;
import oop.models.article.Article;
import oop.models.entity.Entity;
import oop.models.entity.impl.AgreementEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;
import oop.models.fact.impl.MeetingFact;
import org.apache.commons.lang3.RandomStringUtils;
import static org.apache.commons.lang3.RandomStringUtils.random;

/**
 * Hello world!
 *
 */
public class App {

    private static final String ARANGO_USERNAME = "root";
    private static final String ARANGO_PASSWORD = "admin";
    private static Object listCountry;

    public static void main(String[] args) {
        Dao.connect(ARANGO_USERNAME, ARANGO_PASSWORD);
        EntityDao entityDao = EntityDao.getInstance();
        FactDao factDao = FactDao.getInstance();
        ArticleDao articleDao = ArticleDao.getInstance();
        AgreementEntity agreement = new AgreementEntity();
        agreement.setId("aaaaaaaaa");
        agreement.setLabel(RandomStringUtils.randomAlphanumeric(10));
        agreement.setContent(RandomStringUtils.randomAlphanumeric(50));
        //    entityDao.insert(agreement);
        CreateData cr = new CreateData();
        int[] a = {100, 200, 300, 100, 500, 100, 700, 100, 100, 100, 110, 100, 103};
        int[] b = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        cr.createEntity(a);
        cr.createFact(b);
        //cr.createEntity(a);

        JFrame f = new JFrame("TextField Example");
        final JTextField t2;
        JLabel t1 = new JLabel("Your query:");
        t1.setBounds(50, 100, 200, 30);
        t2 = new JTextField();
        t2.setFocusTraversalPolicyProvider(true);
        t2.setBounds(50, 150, 200, 30);

        JButton but = new JButton("Execute");
        but.setBounds(150, 200, 80, 25);
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = t2.getText();
                ReadQuery.Read(query);
            }
        });

        f.add(but);
        f.add(t1);
        f.add(t2);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocation(400, 250);
        f.setSize(350, 350);
        f.setLayout(null);
        f.setVisible(true);
        String qaa = t2.getText();
        System.out.println("q");
        Dao.closeConnection();
    }
}
