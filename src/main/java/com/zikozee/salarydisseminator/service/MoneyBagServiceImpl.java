package com.zikozee.salarydisseminator.service;

import com.zikozee.salarydisseminator.model.MoneyBag;
import com.zikozee.salarydisseminator.model.enumModel.BankingAccountClass;
import com.zikozee.salarydisseminator.repo.MoneyBagRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MoneyBagServiceImpl implements MoneyBagService {

    private final MoneyBagRepository moneyBagRepository;

    public MoneyBagServiceImpl(MoneyBagRepository moneyBagRepository) {
        this.moneyBagRepository = moneyBagRepository;
    }


    @Override
    public Set<MoneyBag> findAll() {
        Set<MoneyBag> moneyBags = new HashSet<>();
        moneyBagRepository.findAll().iterator().forEachRemaining(moneyBags::add);
        return moneyBags;
    }

    @Override
    public Set<MoneyBag> findByBank(String bank) {
        return moneyBagRepository.findByBank(bank);
    }

    @Override
    public List<MoneyBag> findByBankAndBankingAccountClass(String bank, BankingAccountClass bankingAccountClass) {
        return moneyBagRepository.findByBankAndBankingAccountClass(bank, bankingAccountClass);
    }

    @Override
    public MoneyBag findById(Long id) {
        return moneyBagRepository.findById(id).orElse(null);
    }

    @Override
    public void save(MoneyBag moneyBag) {
        moneyBagRepository.save(moneyBag);
    }

    @Override
    public void delete(MoneyBag moneyBag) {
        moneyBagRepository.delete(moneyBag);
    }

    @Override
    public void deleteById(Long id) {
        moneyBagRepository.deleteById(id);
    }
}
