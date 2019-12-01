package pl.pjwstk.model;

import java.util.List;

public class ListOfOffer {

    private Long id;

    private List<WeddingOffer> weddingOffers;

    public ListOfOffer() {
    }

    public ListOfOffer(Long id, List<WeddingOffer> weddingOffers) {

        this.id = id;

        this.weddingOffers = weddingOffers;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public List<WeddingOffer> getWeddingOffers() {
        return weddingOffers;
    }


    public void setWeddingOffers(List<WeddingOffer> weddingOffers) {
        this.weddingOffers = weddingOffers;
    }
}
