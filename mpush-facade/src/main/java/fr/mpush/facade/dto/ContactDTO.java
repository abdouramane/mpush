package fr.mpush.facade.dto;


public class ContactDTO extends PersonDTO {

    private CategoryDTO category;

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
