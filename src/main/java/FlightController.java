import develhope.co.Exercise18.Flight;
import develhope.co.Exercise18.FlightRepository;
import develhope.co.Exercise18.STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @PostMapping
    public List<Flight> createFlights(@RequestParam(required = false) Integer numberFlights){
        if(numberFlights == null){
            numberFlights = 100;
        }
        List<Flight> flightList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i< numberFlights;i++){
            Flight flight = new Flight();
            flight.setDescription("descrizione" + random.nextInt(100));
            flight.setFromAirport("airport" + random.nextInt(100));
            flight.setToAirport("airport" + random.nextInt());
            flight.setStatus(STATUS.ONTIME);
            flightList.add(flight);
        }
        return flightRepository.saveAll(flightList);
    }
    @GetMapping("")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

}