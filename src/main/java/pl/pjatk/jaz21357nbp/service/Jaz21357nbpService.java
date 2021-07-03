package pl.pjatk.jaz21357nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jaz21357nbp.model.Root;

@Service
public class Jaz21357nbpService {
    private final RestTemplate restTemplate;

    public Jaz21357nbpService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double getAvg(String from, String to, String currency) {
        String endpoint = "http://api.nbp.pl/api/exchangerates/rates/a/"+ currency + "/"+ from + "/" + to +
                "/?format=json";
        return this.restTemplate.getForObject(endpoint, Root.class).getAverage();
    }
}
