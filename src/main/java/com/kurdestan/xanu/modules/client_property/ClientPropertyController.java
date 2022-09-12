package com.kurdestan.xanu.modules.client_property;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/client_properties/")
@AllArgsConstructor
public class ClientPropertyController {

    private final ClientPropertyService service;
    private ClientPropertyMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ClientPropertyDTO clientPropertyDTO) {
        ClientProperty clientProperty = mapper.toClientProperty(clientPropertyDTO);
        service.save(clientProperty);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ClientPropertyDTO clientPropertyDTO) {
        ClientProperty clientProperty = mapper.toClientProperty(clientPropertyDTO);
        service.update(clientProperty);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{clientId}")
    public ResponseEntity<List<ClientPropertyDTO>> getAllByClientPropertyId(@PathVariable Long clientId) {
        List<ClientProperty> clientProperties = service.getAllByClientId(clientId);
        List<ClientPropertyDTO> clientPropertyDTOS = mapper.toClientPropertyDTOList(clientProperties);
        return ResponseEntity.ok(clientPropertyDTOS);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<ClientPropertyDTO> getById(@PathVariable Long id) {
        ClientProperty clientProperty = service.getById(id);
        ClientPropertyDTO clientPropertyDTO = mapper.toClientPropertyDTO(clientProperty);
        return ResponseEntity.ok(clientPropertyDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<ClientPropertyDTO>> getAll() {
        List<ClientProperty> clientPropertyList = service.getAll();
        List<ClientPropertyDTO> clientPropertyDTOS = mapper.toClientPropertyDTOList(clientPropertyList);
        return ResponseEntity.ok(clientPropertyDTOS);
    }

}


