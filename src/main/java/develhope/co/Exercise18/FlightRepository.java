package develhope.co.Exercise18;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query(value = "SELECT * FROM FLIGHT", nativeQuery = true)
    List<Flight> retrieveAllFlights();
    @Query(value = "SELECT * FROM FLIGHT WHERE STATUS = ?1", nativeQuery = true)
    List<Flight> retrieveFlightsByStatus(STATUS status);
    @Query(value = "SELECT * FROM FLIGHT WHERE FROM_AIRPORT = ?1", nativeQuery = true)
    List<Flight> retrieveFlightsByFromAirport(String fromAirport);
    @Query(value = "SELECT * FROM FLIGHT WHERE TO_AIRPORT = ?1", nativeQuery = true)
    List<Flight> retrieveFlightsByToAirport(String toAirport);
    @Query(value = "SELECT * FROM FLIGHT WHERE FROM_AIRPORT = ?1 AND TO_AIRPORT = ?2", nativeQuery = true)
    List<Flight> retrieveFlightsByFromAirportAndToAirport(String fromAirport, String toAirport);

}
