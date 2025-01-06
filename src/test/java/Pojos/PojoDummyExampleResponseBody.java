package Pojos;


public class PojoDummyExampleResponseBody {

    private String status;
    private PojoDummyExampleData data;
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public PojoDummyExampleResponseBody() {
    }

    /**
     *
     * @param data
     * @param message
     * @param status
     */
    public PojoDummyExampleResponseBody(String status, PojoDummyExampleData data, String message) {
        super();
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PojoDummyExampleData getData() {
        return data;
    }

    public void setData(PojoDummyExampleData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PojoDummyExampleResponseBody{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
