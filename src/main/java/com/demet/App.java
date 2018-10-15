package com.demet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{



    public static void main(String[] args)throws Exception {
        // TODO Auto-generated method stub

        String searchText = "asd";// endpoint ten gelecek arama parametresi

        Document doc = Jsoup.connect("https://www.cimri.com/arama?q=" + searchText).get();

        List<Product> products = new ArrayList<>();


        Elements content = doc.getElementsByClass("s1cegxbo-1 cACjAF");
        if (content != null && !content.isEmpty()) {
            Element element = content.first();
            Elements cards = element.getElementsByClass("z7ntrt-0 fSAyVn s1a29zcm-4 kqGDay");
            for (Element card : cards) {
                System.out.println("Title : " + card.getElementsByClass("z7ntrt-5 iIaBXu").text());

                Product product = new Product();
                product.setTitle(card.getElementsByClass("z7ntrt-5 iIaBXu").text());

                List<Offer> offers = new ArrayList<>();
                for (Element offer : card.getElementsByClass("s14oa9nh-0 cblYEW")) {
                    Offer offerModel = new Offer();
                    offerModel.setLink( offer.attr("href"));
                    offers.add(offerModel);
                    System.out.println("Offer : " + offer.attr("href"));
                }

                product.setOffers(offers);
                products.add(product);
            }

        } else {
            System.out.println("Sonuç bulunamadı");
        }


        System.out.println(products);
    }
}
