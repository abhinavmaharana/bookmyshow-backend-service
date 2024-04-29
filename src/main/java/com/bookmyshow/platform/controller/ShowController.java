package com.bookmyshow.platform.controller;

import com.bookmyshow.platform.dto.ShowsDTO;
import com.bookmyshow.platform.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/shows")
public class ShowController {
    private ShowService showService;

    // Add Shows API
    @PostMapping("/admin/createShows")
    public ResponseEntity<ShowsDTO> createShows(@RequestBody ShowsDTO showsDTO) {
        ShowsDTO savedShows = showService.createShows(showsDTO);
        return new ResponseEntity<>(savedShows, HttpStatus.CREATED);
    }

    // Get All Shows API
    @GetMapping
    public ResponseEntity<List<ShowsDTO>> getAllShows() {
        List<ShowsDTO> shows = showService.getAllShows();
        return  ResponseEntity.ok(shows);
    }

    // Get Show By ID API
    @GetMapping("{id}")
    public ResponseEntity<ShowsDTO> getShowById(@PathVariable("id") String showId) {
        ShowsDTO showsDTO = showService.getShowById(showId);
        return ResponseEntity.ok(showsDTO);
    }

    // Update Show API
    @PutMapping("/admin/{id}")
    public ResponseEntity<ShowsDTO> updateShow(@PathVariable("id") String showId, @RequestBody ShowsDTO updatedShow) {
        ShowsDTO showsDTO = showService.updateShow(showId, updatedShow);
        return ResponseEntity.ok(showsDTO);
    }

    // Delete Show API
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable("id") String showId) {
        showService.deleteShow(showId);
        return ResponseEntity.ok("Show deleted successfully!!");
    }
}
