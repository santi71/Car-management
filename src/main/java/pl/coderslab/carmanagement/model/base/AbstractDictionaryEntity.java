package pl.coderslab.carmanagement.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractDictionaryEntity extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;
    private String description;

}
