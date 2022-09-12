package com.kurdestan.xanu.modules.agency;

import com.kurdestan.xanu.common.PagingData;
import com.kurdestan.xanu.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody AgencyDTO agencyDTO) {
        Agency agency = mapper.toAgency(agencyDTO);
        service.update(agency);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<AgencyDTO> getById(@PathVariable Long id) {
        Agency agency = service.getById(id);
        AgencyDTO agencyDTO = mapper.toAgencyDTO(agency);
        return ResponseEntity.ok(agencyDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/region/{regionId}/{page}/{size}")
    public ResponseEntity<PagingData<AgencyDTO>> getAllPagingByRegion(@PathVariable Long regionId, @PathVariable Integer page, @PathVariable Integer size) {
        Page<Agency> agencyPage = service.pagingByRegionId(regionId, page, size);
        return getPagingDataResponseEntity(page, agencyPage);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<AgencyDTO>> getAllPaging(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Agency> agencyPage = service.paging(page, size);
        return getPagingDataResponseEntity(page, agencyPage);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<AgencyDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<Agency> houseList = service.search(searchCriteria);
        List<AgencyDTO> agencyDTOS = mapper.toAgencyDTOList(houseList);
        return ResponseEntity.ok(agencyDTOS);
    }

    private ResponseEntity<PagingData<AgencyDTO>> getPagingDataResponseEntity(@PathVariable Integer page, Page<Agency> agencyPage) {
        int totalPage = agencyPage.getTotalPages();
        List<Agency> data = agencyPage.getContent();
        List<AgencyDTO> agencyDTOS = mapper.toAgencyDTOList(data);
        PagingData<AgencyDTO> pagingData = new PagingData<>(totalPage, page, agencyDTOS);
        return ResponseEntity.ok(pagingData);
    }

}


