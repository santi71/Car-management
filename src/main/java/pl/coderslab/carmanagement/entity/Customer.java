package pl.coderslab.carmanagement.entity;

import pl.coderslab.carmanagement.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends User {



}
