package com.kurdestan.xanu.modules.image;

import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ImageMapper {

    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageDTO(Image image);
    List<Image> toImageList(List<ImageDTO> imageDTOS);
    List<ImageDTO> toImageDTOList(List<Image> cities);
}
