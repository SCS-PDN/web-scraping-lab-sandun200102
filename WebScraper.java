import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.bbc.com").get();

            
            System.out.println("title : " + doc.title());

            for (int i = 1; i <= 6; i++) {
                Elements headings = doc.select("h" + i);
                for (Element heading : headings) {
                    System.out.println("H" + i + ": " + heading.text());
                }
            }

            Elements links = doc.select("a[href]");
            for (Element link : links) {
                System.out.println("link : " + link.absUrl("href") + " | Text: " + link.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class NewsArticle {
    String headline;
    String date;
    String author;

    public NewsArticle(String headline, String date, String author) {
        this.headline = headline;
        this.date = date;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Headline: " + headline + "\nDate: " + date + "\nAuthor: " + author + "\n";
    }
}

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WebScraper {
//    public static void main(String[] args) {
//        List<NewsArticle> articles = new ArrayList<>();
//
//        try {
//            Document doc = Jsoup.connect("https://www.bbc.com").get();
//
//            Elements newsItems = doc.select("a:has(h3)");
//
//            for (Element item : newsItems) {
//                String headline = item.text();
//                String link = item.absUrl("href");
//
//                String date = "N/A";
//                String author = "N/A";
//
//                try {
//                    Document articleDoc = Jsoup.connect(link).get();
//                    Element dateElem = articleDoc.selectFirst("time");
//                    Element authorElem = articleDoc.selectFirst("[rel=author]");
//
//                    if (dateElem != null) date = dateElem.text();
//                    if (authorElem != null) author = authorElem.text();
//
//                } catch (Exception ignored) {}
//
//                articles.add(new NewsArticle(headline, date, author));
//            }
//
//            for (NewsArticle article : articles) {
//                System.out.println(article);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

