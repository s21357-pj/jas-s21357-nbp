package pl.pjatk.jaz21357nbp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private String fromDate;
    private String toDate;
    private Double average;
    private Date timestamp;

    public Request() {

    }
    public Request(String currency, String fromDate, String toDate, Double average) {
        this.currency = currency;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.timestamp = new Date();
        this.average = average;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
