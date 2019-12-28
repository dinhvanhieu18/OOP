package oop.controllers.query;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import oop.models.*;
import oop.models.article.Article;
import oop.models.entity.Entity;
import oop.models.entity.impl.EventEntity;
import oop.controllers.query.*;

public class ReadQuery {

    private static final String SOURCE = "query.txt";
    private static Scanner sc;
    private static int count = 0;
    public static void Read() {
        // TODO Auto-generated method stub
        try {
            sc = new Scanner(new File(SOURCE));
            while (sc.hasNextLine()) {
                count++;
                System.out.print("Query" + count + ":");
//                System.out.print("Query:");
                String s = sc.nextLine();
                s = s.trim();
                String p[] = s.split(" ");
//                System.out.println(s.replaceAll(" ", ""));
                // System.out.println(Arrays.toString(p));

                if (p[0].contains("SHOW_ARTICLE")) {
//                    System.out.println("ok");
                    if (p[1].contains("YEAR")) {
                        System.out.println(Query.publishedYear(p[2].replaceAll(" ", "")));//Cau 1
                    } else if (p[1].contains("SUBJECT")) {//Cau 5
                        showEntity(Query.getSubject(p[2].replaceAll(" ", "")));
                    } else if (p[1].contains("URL")) {
                        showArticle(Query.getArticleWithUrl(s));
                    } else if (p[1].contains("MOSTFACTS")) {
                        showArticle(Query.mostFactsArticle());
                    } else if (p[1].contains("LEASTFACTS")) {
                        showArticle(Query.leastFactsArticle());
                    } else if (p[1].contains("FACTGREATER")) {
                        List<Article> articles = Query.ArticleFactsSizeGreater(Integer.parseInt(p[2].replaceAll(" ", "")));
                        for (Article a : articles) {
                            showArticle(a);
                        }
                    } else if (p[1].contains("FACTSMALLER")) {
                        List<Article> articles = Query.ArticleFactsSizeGreater(Integer.parseInt(p[2].replaceAll(" ", "")));
                        for (Article a : articles) {
                            showArticle(a);
                        }
                    }
                } else if (p[0].contains("SHOW_ENTITY")) {
                    if (p[1].contains("LABEL")) {
                        System.out.println(Query.getLabel(p[2].replaceAll(" ", "")));
                    } else if (p[1].contains("CONTENT")) {
                        System.out.println(Query.getContent(p[2].replaceAll(" ", "")));//Cau3
                    } else if (p[1].contains("LOCATION")) {
                        System.out.println(Query.getLocation(p[2].replaceAll(" ", "")));
                    } else {
                        if (p[1].contains("TENSION")) {//1
                            List<Entity> entitys = Query.tensionWith(p[2].replace(" ", ""));
                            for (Entity e : entitys) {
                                showEntity(e);
                            }
                        } else if (p[1].contains("EVENT")) {//2
                            List<Entity> entitys = Query.eventAt(p[2].replace(" ", ""));
                            for (Entity e : entitys) {
                                showEntity(e);
                            }
                        } else if (p[1].contains("LONGESTLABEL")) {//3
                            System.out.println(Query.longestLabel());
                        } else if (p[1].contains("LONGESTCONTENT")) {
                            System.out.println(Query.longestContentEntity());
                        }
                        if (p[1].contains("MEETING")) {
                            List<Entity> entitys = Query.meetingWith(p[2].replaceAll(" ", ""));
                            for (Entity e : entitys) {
                                showEntity(e);
                            }
                        } else if (p[1].contains("SUPPORTER")) {//4
                            List<Entity> entitys = Query.supporterOf(p[2].replace(" ", ""));
                            for (Entity e : entitys) {
                                showEntity(e);
                            }
                        } else if (p[1].contains("ORGANIZE")) {//3
                            List<Entity> entitys = Query.organizerOf(p[2].replace(" ", ""));
                            for (Entity e : entitys) {
                                showEntity(e);
                            }
                        } else if (p[1].contains("LABELS")) {
                            List<Entity> entitys = Query.getEntityWithLable(p[2].replaceAll(" ", ""));
                            for (Entity e : entitys) {
                                showEntity(e);
                            }
                        } else if (p[1].contains("DEAL")) {
                            List<Entity> entitys = Query.DealingWith(p[2].replaceAll(" ", ""));
                            for (Entity e : entitys) {
                                showEntity(e);
                            }
                        } else if (p[1].contains("CANCEL")) {
                            List<Entity> entitys = Query.CancelledEntity();
                            for (Entity e : entitys) {
                                showEntity(e);
                            }
                        }

                    }
                } else {
                    System.out.println("Unknown query");
                    continue;
                }
                break;
            }
        } catch (Exception e) {
        }
    }

    public static void Read(String s) {
        // TODO Auto-generated method stub
        try {

            count++;
            System.out.print("Query" + count + ":");
//                System.out.print("Query:");
            s = s.trim();
            String p[] = s.split(" ");
//                System.out.println(s.replaceAll(" ", ""));
            // System.out.println(Arrays.toString(p));

            if (p[0].contains("SHOW_ARTICLE")) {
//                    System.out.println("ok");
                if (p[1].contains("YEAR")) {
                    System.out.println(Query.publishedYear(p[2].replaceAll(" ", "")));//Cau 1
                } else if (p[1].contains("SUBJECT")) {//Cau 5
                    showEntity(Query.getSubject(p[2].replaceAll(" ", "")));
                } else if (p[1].contains("URL")) {
                    showArticle(Query.getArticleWithUrl(s));
                } else if (p[1].contains("MOSTFACTS")) {
                    showArticle(Query.mostFactsArticle());
                } else if (p[1].contains("LEASTFACTS")) {
                    showArticle(Query.leastFactsArticle());
                } else if (p[1].contains("FACTGREATER")) {
                    List<Article> articles = Query.ArticleFactsSizeGreater(Integer.parseInt(p[2].replaceAll(" ", "")));
                    for (Article a : articles) {
                        showArticle(a);
                    }
                } else if (p[1].contains("FACTSMALLER")) {
                    List<Article> articles = Query.ArticleFactsSizeGreater(Integer.parseInt(p[2].replaceAll(" ", "")));
                    for (Article a : articles) {
                        showArticle(a);
                    }
                }
            } else if (p[0].contains("SHOW_ENTITY")) {
                if (p[1].contains("LABEL")) {
                    System.out.println(Query.getLabel(p[2].replaceAll(" ", "")));
                } else if (p[1].contains("CONTENT")) {
                    System.out.println(Query.getContent(p[2].replaceAll(" ", "")));//Cau3
                } else if (p[1].contains("LOCATION")) {
                    System.out.println(Query.getLocation(p[2].replaceAll(" ", "")));
                } else {
                    if (p[1].contains("TENSION")) {//1
                        List<Entity> entitys = Query.tensionWith(p[2].replace(" ", ""));
                        for (Entity e : entitys) {
                            showEntity(e);
                        }
                    } else if (p[1].contains("EVENT")) {//2
                        List<Entity> entitys = Query.eventAt(p[2].replace(" ", ""));
                        for (Entity e : entitys) {
                            showEntity(e);
                        }
                    } else if (p[1].contains("LONGESTLABEL")) {//3
                        System.out.println(Query.longestLabel());
                    } else if (p[1].contains("LONGESTCONTENT")) {
                        System.out.println(Query.longestContentEntity());
                    }
                    if (p[1].contains("MEETING")) {
                        List<Entity> entitys = Query.meetingWith(p[2].replaceAll(" ", ""));
                        for (Entity e : entitys) {
                            showEntity(e);
                        }
                    } else if (p[1].contains("SUPPORTER")) {//4
                        List<Entity> entitys = Query.supporterOf(p[2].replace(" ", ""));
                        for (Entity e : entitys) {
                            showEntity(e);
                        }
                    } else if (p[1].contains("ORGANIZE")) {//3
                        List<Entity> entitys = Query.organizerOf(p[2].replace(" ", ""));
                        for (Entity e : entitys) {
                            showEntity(e);
                        }
                    } else if (p[1].contains("LABELS")) {
                        List<Entity> entitys = Query.getEntityWithLable(p[2].replaceAll(" ", ""));
                        for (Entity e : entitys) {
                            showEntity(e);
                        }
                    } else if (p[1].contains("DEAL")) {
                        List<Entity> entitys = Query.DealingWith(p[2].replaceAll(" ", ""));
                        for (Entity e : entitys) {
                            showEntity(e);
                        }
                    } else if (p[1].contains("CANCELL")) {
                        List<Entity> entitys = Query.CancelledEntity();
                        for (Entity e : entitys) {
                            showEntity(e);
                        }
                    }

                }
            } else {
                System.out.println("Unknown query");
                JOptionPane.showMessageDialog(null, "Unknown query");
            }

        } catch (Exception e) {
        }
    }

    private static void showEntity(Entity e) {
        JOptionPane.showMessageDialog(null, e.getId()
                + "\n" + e.getLabel()
                + "\n" + e.getContent());
        System.out.println(e.getId());
        System.out.println(e.getLabel());
        System.out.println(e.getContent());
    }

    private static void showArticle(Article a) {
        JOptionPane.showMessageDialog(null, a.getId()
                + "\n" + a.getPublishedDate()
                + "\n" + a.getUrl());
        System.out.println(a.getId());
        System.out.println(a.getPublishedDate());
        System.out.println(a.getUrl());
    }
}
