package com.zikozee.salarydisseminator.service;

import com.zikozee.salarydisseminator.model.MoneyBag;
import com.zikozee.salarydisseminator.model.enumModel.BankingAccountClass;

import java.util.List;
import java.util.Set;

public interface MoneyBagService {
    Set<MoneyBag> findAll();

    Set<MoneyBag> findByBank(String bank);

    List<MoneyBag> findByBankAndBankingAccountClass(String bank, BankingAccountClass bankingAccountClass);

    MoneyBag findById(Long id);

    void save(MoneyBag moneyBag);

    void delete(MoneyBag moneyBag);

    void deleteById(Long id);
}
