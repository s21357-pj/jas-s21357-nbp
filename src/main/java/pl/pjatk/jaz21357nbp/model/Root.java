package pl.pjatk.jaz21357nbp.model;

import java.util.ArrayList;
import java.util.List;

public class Root {
    public String table;
    public String currency;
    public String code;
    public ArrayList<Rate> rates;
    public Root(){

    }
    public Root(String table, String currency, String code, ArrayList<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }
    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getAverage() {
        return rates.stream().mapToDouble(d -> d.getMid()).average().orElse(0.0);
    }

    public String getCode() {
        return code;
    }


    public void setTable(String table) {
        this.table = table;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
