package com.deliver.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "delivery_person_details")
public class DeliveryPersonDetails {

    @Id
    private String id;

    @Column(name = "personName")
    private String personName;

    @Column(name= "contact")
    private String contact;

    @Column(name = "status")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
