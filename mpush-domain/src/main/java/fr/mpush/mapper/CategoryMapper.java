package fr.mpush.mapper;

import fr.mpush.entities.Category;
import fr.mpush.facade.dto.CategoryDTO;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIoC = IoC.SPRING)
public interface CategoryMapper {

    CategoryDTO asCategoryDTO(Category in);

}
