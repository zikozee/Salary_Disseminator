package com.zikozee.salarydisseminator.model;

import com.zikozee.salarydisseminator.model.enumModel.BankingAccountClass;
import com.zikozee.salarydisseminator.model.enumModel.BudgetType;
import lombok.*;

import javax.persistence.*;

@Getter @Setter
@ToString @AllArgsConstructor @NoArgsConstructor
@Entity
public class MoneyBag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BudgetType budgetType;

    private String bank;

    @Enumerated(EnumType.STRING)
    private BankingAccountClass bankingAccountClass;

    private double amount;
}
