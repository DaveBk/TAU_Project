package repository;

import model.WeddingOffer;

public class ListOfOfferFactory {

    public static WeddingOffer create(long id, String offerName, double offerPrice) {
        return new WeddingOffer(id, offerName, offerPrice);
    }

}
