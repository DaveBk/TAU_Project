package pl.pjwstk.model;

import java.time.LocalDateTime;

public class WeddingOffer {

    private Long id;

    private String offerName;

    private double offerPrice;

    private boolean isPrepared;

    private YoungCouple youngCouple;

    private LocalDateTime creationTime;
    private LocalDateTime updatedTime;
    private LocalDateTime lastReadTime;

    private boolean saveTimes;

    public WeddingOffer() {
    }

    public WeddingOffer(long id, String offerName, double offerPrice) {

        this.id = id;

        this.offerName = offerName;

        this.offerPrice = offerPrice;

        this.isPrepared = false;

        this.youngCouple = new YoungCouple();

        this.creationTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
        this.saveTimes = true;
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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public LocalDateTime getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(LocalDateTime lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public boolean isSaveTimes() {
        return saveTimes;
    }

    public void setSaveTimes(boolean saveTimes) {
        this.saveTimes = saveTimes;
    }

    @Override
    public String toString() {
        return "TodoTask{" +
                "id=" + id +
                ", offerName='" + offerName + '\'' +
                ", offerPrice='" + offerPrice + '\'' +
                ", isPrepared=" + isPrepared +
                ", creationTime=" + creationTime +
                ", updatedTime=" + updatedTime +
                ", lastReadTime=" + lastReadTime +
                ", youngCouple=" + youngCouple +
                ", saveTimes=" + saveTimes +
                '}';
    }

}
