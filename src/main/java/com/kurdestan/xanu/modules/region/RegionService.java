package com.kurdestan.xanu.modules.region;

import java.util.List;

public interface RegionService {
    Region save(Region region);
    Region update(Region region);
    void delete(Long id);
    Region getById(Long id);
    Region getByName(String name);
    List<Region> getAllByCityId(Long cityId);
    List<Region> getAll();
}