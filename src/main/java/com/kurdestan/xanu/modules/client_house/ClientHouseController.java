package com.kurdestan.xanu.modules.client_house;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/client_houses/")
@AllArgsConstructor
public class ClientHouseController {

    private final ClientHouseService service;
    private ClientHouseMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ClientHouseDTO clientHouseDTO) {
        ClientHouse clientHouse = mapper.toClientHouse(clientHouseDTO);
        service.save(clientHouse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ClientHouseDTO clientHouseDTO) {
        ClientHouse clientHouse = mapper.toClientHouse(clientHouseDTO);
        service.update(clientHouse);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{clientId}")
    public ResponseEntity<List<ClientHouseDTO>> getAllByClientHouseId(@PathVariable Long clientId) {
        List<ClientHouse> clientHouses = service.getAllByClientId(clientId);
        List<ClientHouseDTO> clientHouseDTOS = mapper.toClientHouseDTOList(clientHouses);
        return ResponseEntity.ok(clientHouseDTOS);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<ClientHouseDTO> getById(@PathVariable Long id) {
        ClientHouse clientHouse = service.getById(id);
        ClientHouseDTO clientHouseDTO = mapper.toClientHouseDTO(clientHouse);
        return ResponseEntity.ok(clientHouseDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<ClientHouseDTO>> getAll() {
        List<ClientHouse> clientHouseList = service.getAll();
        List<ClientHouseDTO> clientHouseDTOS = mapper.toClientHouseDTOList(clientHouseList);
        return ResponseEntity.ok(clientHouseDTOS);
    }

}


