package pl.pjwstk.repository;

import pl.pjwstk.model.WeddingOffer;

public class ListOfOfferFactory {

    public static WeddingOffer create(long id, String offerName, double offerPrice) {
        return new WeddingOffer(id, offerName, offerPrice);
    }

}
