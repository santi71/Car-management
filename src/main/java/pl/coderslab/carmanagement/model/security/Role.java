package pl.coderslab.carmanagement.model.security;

import pl.coderslab.carmanagement.model.base.AbstractDictionaryEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "security_role")
public class Role extends AbstractDictionaryEntity {

}
