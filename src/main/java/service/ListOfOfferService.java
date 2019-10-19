package service;


import model.WeddingOffer;
import repository.ListOfOfferRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ListOfOfferService {

    public ListOfOfferService() {
    }


    public boolean addOfferToList(WeddingOffer offer) {
        if (offer == null) throw new IllegalArgumentException("Object is null");

        ListOfOfferRepo.getInstance().collectionAccess().add(offer);
        return true;
    }

    public WeddingOffer getOfferById(long id) {
        if (ListOfOfferRepo.getInstance().isPressentInRepoById(id)) {

            Optional<WeddingOffer> optionalWeddingOffer = ListOfOfferRepo.getInstance().getObjectById(id);
            if (optionalWeddingOffer.isPresent()) {
                return optionalWeddingOffer.get();
            }
        }

        throw new NoSuchElementException("Element with pointed id doesnt exist");
    }

    public boolean deleteOfferById(long id) {
        if (ListOfOfferRepo.getInstance().isPressentInRepoById(id)) {
            ListOfOfferRepo.getInstance().collectionAccess().remove(getOfferById(id));
            return true;
        }
        return false;
    }

    public List<WeddingOffer> getAllWeddingOffers() { return new ArrayList<>(ListOfOfferRepo.getInstance().collectionAccess()); }

    public WeddingOffer updateWeddingOffer(long id, WeddingOffer offer){
        if (ListOfOfferRepo.getInstance().isPressentInRepoById(id)) {
            WeddingOffer offerToUpdate = getOfferById(id);

            offerToUpdate.setOfferName(offer.getOfferName());
            offerToUpdate.setPrepared(offer.isPrepared());
            offerToUpdate.setOfferPrice(offer.getOfferPrice());
            offerToUpdate.setYoungCouple(offer.getYoungCouple());

            ListOfOfferRepo.getInstance().collectionAccess().remove(getOfferById(id));
            ListOfOfferRepo.getInstance().collectionAccess().add(offerToUpdate);

            return offerToUpdate;
        }

        throw new NoSuchElementException("Element with pointed id doesnt exist");
    }
}
