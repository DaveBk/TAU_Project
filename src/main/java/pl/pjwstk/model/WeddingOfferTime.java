package pl.pjwstk.model;

import java.time.LocalDateTime;

public class WeddingOfferTime {
    private LocalDateTime creationTime;
    private LocalDateTime updatedTime;
    private LocalDateTime lastReadTime;

    public WeddingOfferTime()   {
    }

    public WeddingOfferTime(LocalDateTime creationTime, LocalDateTime updatedTime, LocalDateTime lastReadTime)   {
        this.creationTime = creationTime;
        this.updatedTime = updatedTime;
        this.lastReadTime = lastReadTime;
    }

    public WeddingOfferTime create(WeddingOffer offer)   {
        return new WeddingOfferTime(offer.getCreationTime(), offer.getUpdatedTime(), offer.getLastReadTime());
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public LocalDateTime getLastReadTime() {
        return lastReadTime;
    }

}