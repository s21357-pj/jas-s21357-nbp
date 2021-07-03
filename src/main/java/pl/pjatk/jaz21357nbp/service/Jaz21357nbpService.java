package pl.pjatk.jaz21357nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jaz21357nbp.model.Request;
import pl.pjatk.jaz21357nbp.model.RequestRepository;
import pl.pjatk.jaz21357nbp.model.Root;

@Service
public class Jaz21357nbpService {
    private final RestTemplate restTemplate;
    private final RequestRepository requestRepository;

    public Jaz21357nbpService(RestTemplate restTemplate, RequestRepository requestRepository) {
        this.restTemplate = restTemplate;
        this.requestRepository = requestRepository;
    }

    public Double getAvg(String from, String to, String currency) {
        String endpoint = "http://api.nbp.pl/api/exchangerates/rates/a/"+ currency + "/"+ from + "/" + to +
                "/?format=json";
        Double result = this.restTemplate.getForObject(endpoint, Root.class).getAverage();
        Request newRequest = new Request(currency, from, to, result);
        requestRepository.save(newRequest);
        return result;
    }
}
