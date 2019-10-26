package com.zikozee.salarydisseminator.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@ToString @AllArgsConstructor @NoArgsConstructor
@Entity
public class MoneyBag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String budgetType;
    private String bank;
    private String bankingAccountClass;
    private double amount;
}
