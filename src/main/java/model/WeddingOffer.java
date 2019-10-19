package model;

import java.math.BigDecimal;

public class WeddingOffer {

    private Long id;

    private String offerName;

    private double offerPrice;

    private boolean isPrepared;

    private YoungCouple youngCouple;

    public WeddingOffer() {
    }

    public WeddingOffer(long id, String offerName, double offerPrice) {

        this.id = id;

        this.offerName = offerName;

        this.offerPrice = offerPrice;

        this.isPrepared = false;

        this.youngCouple = new YoungCouple();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public boolean isPrepared() {
        return isPrepared;
    }

    public void setPrepared(boolean prepared) {
        isPrepared = prepared;
    }

    public YoungCouple getYoungCouple() {
        return youngCouple;
    }

    public void setYoungCouple(YoungCouple youngCouple) {
        this.youngCouple = youngCouple;
    }
}
