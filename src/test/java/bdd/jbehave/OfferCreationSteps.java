package bdd.jbehave;

import org.junit.Assert;
import pl.pjwstk.model.WeddingOffer;
import pl.pjwstk.model.YoungCouple;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pl.pjwstk.repository.ListOfOfferRepo;
import pl.pjwstk.service.ListOfOfferService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class OfferCreationSteps {

    private WeddingOffer weddingOffer;
    private ListOfOfferService listOfOfferService = new ListOfOfferService();
    private ListOfOfferRepo repository = ListOfOfferRepo.getInstance();

    private List<WeddingOffer> WeddingOffers = new ArrayList<>();
    private boolean isDeleted;

    @Given("a new offer")
    public void offerIsCreated() {
        weddingOffer = new WeddingOffer();
    }

    @When("Offer get own title - $name")
    public void setOfferName(String name) {
        weddingOffer.setOfferName(name);
    }

    @Then("user can show offer $name name")
    public void offerNameIsCorrect(String name) {
        MatcherAssert.assertThat(weddingOffer.getOfferName(), equalTo(name));
    }

    @When("user set youngCouple to offer")
    public void setWeddingOfferToDone(YoungCouple youngCouple) {
        weddingOffer.setYoungCouple(youngCouple);
    }

    @Then("offer get new youngCouple")
    public void youngCoupleIsPresent(YoungCouple youngCouple) {
        MatcherAssert.assertThat(weddingOffer.getYoungCouple(), equalTo(youngCouple));
    }

    @When("user wanna change offer state")
    public void setOfferPrepareState(boolean isPrepared) {
        weddingOffer.setPrepared(isPrepared);
    }

    @Then("offer state will update")
    public void offerStateChanged(boolean isPrepared) {
        MatcherAssert.assertThat(weddingOffer.isPrepared(), equalTo(isPrepared));
    }

    @Given("init offer list")
    public void initOfferList() {
        repository.collectionAccess().add(new WeddingOffer(1, "Karoca z konmi", 600));
        repository.collectionAccess().add(new WeddingOffer(2, "Dzik w sosie wlasnym", 3000));
    }

    @When("user wanna offers with $regex")
    public void getOffersByRegex(String regex) {
        WeddingOffers = listOfOfferService.getOffersByRegex(regex);
    }

    @Then("user get all offers with $regex ")
    public void offersByRegexCorrect(String regex) {
        MatcherAssert.assertThat(WeddingOffers.size(), equalTo(1));
        Assert.assertTrue(WeddingOffers.get(1).getOfferName().contains(regex));
    }

    @Given("inits offers list")
    public void initsOfferList() {
        repository.collectionAccess().add(new WeddingOffer(1, "Karoca z konmi", 600));
        repository.collectionAccess().add(new WeddingOffer(2, "Dzik w sosie wlasnym", 3000));
    }

    @When("user wanna delete offers with $regex")
    public void removeOffersByRegex(String regex) {
        isDeleted = listOfOfferService.deleteOffersByRegex(regex);
    }

    @Then("user will remove all offers contains $regex")
    public void offersByRegexRemovedCorrect(String regex) {
        MatcherAssert.assertThat(isDeleted, equalTo(true) );
        MatcherAssert.assertThat(WeddingOffers.size(), equalTo(1));
    }

}
