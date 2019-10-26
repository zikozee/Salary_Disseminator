package com.zikozee.salarydisseminator.repo;

import com.zikozee.salarydisseminator.model.MoneyBag;
import com.zikozee.salarydisseminator.model.enumModel.BankingAccountClass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface MoneyBagRepository extends CrudRepository<MoneyBag, Long> {
    Set<MoneyBag> findByBank(String bank);

    List<MoneyBag> findByBankAndBankingAccountClass(String bank, BankingAccountClass bankingAccountClass);

}
