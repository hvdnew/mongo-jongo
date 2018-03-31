package data.model;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class Address {

    @MongoObjectId
    private String _id;
    private String line1;
    private String line2;
    private String line3;

    private String zipcode;
    private State state;

    public Address() {
    }

    public Address(String line1, String line2, String zipcode) {
        this.line1 = line1;
        this.line2 = line2;
        this.zipcode = zipcode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
