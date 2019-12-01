package pl.pjwstk.model;

public class YoungCouple {

    private Long id;

    private String firstNameM;

    private String lastNameM;

    private String firstNameF;

    private String lastNameF;

    private boolean isActive;

    public YoungCouple() {
    }

    public YoungCouple(Long id, String firstNameM, String lastNameM, String firstNameF, String lastNameF, boolean isActive) {

        this.id = id;

        this.firstNameM = firstNameM;

        this.lastNameM = lastNameM;

        this.firstNameF = firstNameF;

        this.lastNameF = lastNameF;

        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNameM() {
        return firstNameM;
    }

    public void setFirstNameM(String firstNameM) {
        this.firstNameM = firstNameM;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public String getFirstNameF() {
        return firstNameF;
    }

    public void setFirstNameF(String firstNameF) {
        this.firstNameF = firstNameF;
    }

    public String getLastNameF() {
        return lastNameF;
    }

    public void setLastNameF(String lastNameF) {
        this.lastNameF = lastNameF;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
