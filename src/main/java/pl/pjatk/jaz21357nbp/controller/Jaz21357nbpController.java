package pl.pjatk.jaz21357nbp.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.jaz21357nbp.service.Jaz21357nbpService;

@RestController
@RequestMapping("/")
public class Jaz21357nbpController {
    private final Jaz21357nbpService jaz21357nbpService;
    public Jaz21357nbpController(Jaz21357nbpService jaz21357nbpService) {
        this.jaz21357nbpService = jaz21357nbpService;
    }
    @ApiOperation(value = "calculate average currency rate for the time period",
            response = Double.class,
            notes = "This method will return average currency rate for the time period or error code"
    )
    @GetMapping("/avg/{currency}/{from}/{to}")
    public ResponseEntity<Double> getAvg(@PathVariable String currency, @PathVariable String from, @PathVariable String to) {
        return new ResponseEntity<>(jaz21357nbpService.getAvg(from, to, currency), HttpStatus.OK);
    }
}
