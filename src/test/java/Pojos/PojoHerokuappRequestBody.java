package Pojos;

public class PojoHerokuappRequestBody {

    /*
    {
         "firstname":"Ahmet"
         "lastname":"Bulut"
         "totalprice":500,
         "depositpaid":false,
         "bookingdates":{
             "checkin":"2023-01-10",
             "checkout":"2023-01-20"
             },
          "additionalneeds":"wi-fi"
          }
     */

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private PojoHerokuappBookingDates bookingDates;
    private String additionalneeds;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public PojoHerokuappBookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(PojoHerokuappBookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public PojoHerokuappRequestBody(String firstname, String lastname, int totalprice, boolean depositpaid,
                                    PojoHerokuappBookingDates bookingDates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingDates = bookingDates;
        this.additionalneeds = additionalneeds;
    }


    public PojoHerokuappRequestBody() {
    }

    @Override
    public String toString() {
        return "PojoHerokuappRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingDates=" + bookingDates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
