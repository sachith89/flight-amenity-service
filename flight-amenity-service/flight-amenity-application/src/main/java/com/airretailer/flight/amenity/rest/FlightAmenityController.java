package com.airretailer.flight.amenity.rest;


import com.airretailer.flight.amenity.domain.dto.FlightAmenityRequest;
import com.airretailer.flight.amenity.domain.dto.CommonResponse;
import com.airretailer.flight.amenity.application.service.FlightAmenityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/flight-amenity")
public class FlightAmenityController {
        private final FlightAmenityService flightAmenityService;

        public FlightAmenityController(FlightAmenityService flightAmenityService) {
            this.flightAmenityService = flightAmenityService;
        }

        @PostMapping()
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<CommonResponse> createFlight(@RequestBody FlightAmenityRequest flight) {
            return new ResponseEntity<>(flightAmenityService.createFlight(flight), HttpStatus.OK);
        }

        @PutMapping("/")
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<CommonResponse> updateFlight(@RequestBody FlightAmenityRequest flight) {
            return new ResponseEntity<>(flightAmenityService.updateFlight(flight), HttpStatus.OK);
        }

        @DeleteMapping("/")
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<CommonResponse> deleteFlight(@RequestParam("flightId") String flightId) {
            return new ResponseEntity<>(flightAmenityService.deleteFlight(flightId), HttpStatus.OK);
        }

        @GetMapping("/flightId")
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<CommonResponse> getFlightById(@RequestParam String flightId) {
            return new ResponseEntity<>(flightAmenityService.getFlightById(flightId), HttpStatus.OK);
        }

        @GetMapping("/flightNumber")
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<CommonResponse> getFlightByNumber(@RequestParam String flightNumber) {
            return new ResponseEntity<>(flightAmenityService.getFlightByNumber(flightNumber), HttpStatus.OK);
        }

        @GetMapping("/")
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<CommonResponse> getAllFlight(@RequestParam(required = false, defaultValue = "0") int page,
                                                           @RequestParam(required = false, defaultValue = "5") int size) {
            return new ResponseEntity<>(flightAmenityService.getAllFlight(page, size), HttpStatus.OK);
        }
    }