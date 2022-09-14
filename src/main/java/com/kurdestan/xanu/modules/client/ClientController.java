package com.kurdestan.xanu.modules.client;

import com.kurdestan.xanu.common.PagingData;
import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.modules.city.City;
import com.kurdestan.xanu.modules.city.CityDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/clients/")
@AllArgsConstructor
public class ClientController {

    private final ClientService service;
    private ClientMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<?> save(@RequestBody ClientDTO clientDTO) {
        Client client = mapper.toClient(clientDTO);
        service.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<?> update(@RequestBody ClientDTO clientDTO) {
        Client client = mapper.toClient(clientDTO);
        service.update(client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{username}")
    public ResponseEntity<ClientDTO> getAllByUsername(@PathVariable String username) {
        Client client = service.getByUsername(username);
        ClientDTO clientDTO = mapper.toClientDTO(client);
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
        Client client = service.getById(id);
        ClientDTO clientDTO = mapper.toClientDTO(client);
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<Client> clientList = service.getAll();
        List<ClientDTO> clientDTOS = mapper.toClientDTOList(clientList);
        return ResponseEntity.ok(clientDTOS);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<ClientDTO>> Paging(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Client> clientPage = service.paging(page, size);
        return getPagingDataResponseEntity(page, clientPage);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<ClientDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<Client> clientList = service.search(searchCriteria);
        List<ClientDTO> clientDTOS = mapper.toClientDTOList(clientList);
        return ResponseEntity.ok(clientDTOS);
    }

    private ResponseEntity<PagingData<ClientDTO>> getPagingDataResponseEntity(@PathVariable Integer page, Page<Client> clientPage) {
        int totalPage = clientPage.getTotalPages();
        List<Client> data = clientPage.getContent();
        List<ClientDTO> clientDTOS = mapper.toClientDTOList(data);
        PagingData<ClientDTO> pagingData = new PagingData<>(totalPage, page, clientDTOS);
        return ResponseEntity.ok(pagingData);
    }

}


