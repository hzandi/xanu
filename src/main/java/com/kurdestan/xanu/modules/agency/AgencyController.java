package com.kurdestan.xanu.modules.agency;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/agencies/")
@AllArgsConstructor
public class AgencyController {

    private final AgencyService service;
    private AgencyMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody AgencyDTO agencyDTO) {
        Agency agency = mapper.toAgency(agencyDTO);
        service.save(agency);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/region/{id}")
    public ResponseEntity<List<AgencyDTO>> getAllByRegionId(@PathVariable Long id) {
        List<Agency> agencies = service.getAllByRegionId(id);
        List<AgencyDTO> agencyDTOS = mapper.toAgencyDTOList(agencies);
        return ResponseEntity.ok(agencyDTOS);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<AgencyDTO> getById(@PathVariable Long id) {
        Agency agency = service.getById(id);
        AgencyDTO agencyDTO = mapper.toAgencyDTO(agency);
        return ResponseEntity.ok(agencyDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<AgencyDTO>> getAll() {

        List<Agency> agencyList = service.getAll();
        List<AgencyDTO> agencyDTOS = mapper.toAgencyDTOList(agencyList);

        return ResponseEntity.ok(agencyDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

