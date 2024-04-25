package com.bookmyshow.platform.controller;

import com.bookmyshow.platform.dto.CinemaDTO;
import com.bookmyshow.platform.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cinemas")
public class CinemaController {
    private CinemaService cinemaService;

    // Add Cinemas API
    @PostMapping("/admin/create")
    public ResponseEntity<CinemaDTO> createCinemas(@RequestBody CinemaDTO cinemaDTO) {
        CinemaDTO savedCinemas = cinemaService.createCinemas(cinemaDTO);
        return new ResponseEntity<>(savedCinemas, HttpStatus.CREATED);
    }

    // Get All Cinemas API
    @GetMapping
    public ResponseEntity<List<CinemaDTO>> getAllCinemas() {
        List<CinemaDTO> cinemas = cinemaService.getAllCinemas();
        return ResponseEntity.ok(cinemas);
    }

    // Get Cinema By ID API
    @GetMapping("{name}")
    public ResponseEntity<CinemaDTO> getCinemaById(@PathVariable("name") String name) {
        CinemaDTO cinemaDTO = cinemaService.getCinemaById(name);
        return ResponseEntity.ok(cinemaDTO);
    }

    // Update Cinema
    @PutMapping("/admin/{id}")
    public  ResponseEntity<CinemaDTO> updateCinema(@PathVariable("id") String name, @RequestBody CinemaDTO updatedCinema) {
        CinemaDTO cinemaDTO = cinemaService.updateCinema(name, updatedCinema);
        return ResponseEntity.ok(cinemaDTO);
    }

    // Delete Cinema
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteCinema(@PathVariable("id") String name) {
        cinemaService.deleteCinema(name);
        return ResponseEntity.ok("Cinema deleted successfully!!");
    }
}
