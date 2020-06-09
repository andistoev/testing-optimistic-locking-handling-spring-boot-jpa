package com.andistoev.optlockingservice;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Item extends BaseEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    private int amount = 0;
}
