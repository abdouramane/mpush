package fr.mpush.facade.dto;


import java.util.List;

public class ContactDTO extends PersonDTO {

    private List<CategoryDTO> categories;

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
