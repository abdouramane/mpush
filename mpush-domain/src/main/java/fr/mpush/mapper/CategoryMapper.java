package fr.mpush.mapper;

import fr.mpush.entities.Category;
import fr.mpush.facade.dto.CategoryDTO;
import fr.xebia.extras.selma.CollectionMappingStrategy;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.DESTINATION,
        withCollectionStrategy = CollectionMappingStrategy.ALLOW_GETTER)
public interface CategoryMapper {

    CategoryDTO asCategoryDTO(Category in);

    List<CategoryDTO> asCategoryDTOList(List<Category> in);

}
