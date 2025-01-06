package Pojos;

public class PojoHerokuappResponseBody {

    /*

          Response Body // expected data
          {
          "bookingid":24
          "booking"{
              "firstname":"Ahmet",
              "lastname": "Bulut",
              "totalprice":500,
              "depositpaid":false,
              "bookingdates":{
                   "checkin":2021-06-01
                   "checkout":2021-06-10
                   },
              "additionalneeds'in "wi-fi"
           }
           }

     */

    private int bookingid;
    private PojoHerokuappRequestBody booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }

    public PojoHerokuappResponseBody(int bookingid, PojoHerokuappRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public PojoHerokuappResponseBody() {
    }

    @Override
    public String toString() {
        return "PojoHerokuappResponseBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
