package com.kurdestan.xanu.modules.agency;

import java.util.List;


public interface AgencyService {
    Agency save(Agency agency);
    Agency update(Agency agency);
    void delete(Long id);
    Agency getById(Long id);
    List<Agency> getAll();
}