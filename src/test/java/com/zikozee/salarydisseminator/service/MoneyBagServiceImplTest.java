package com.zikozee.salarydisseminator.service;

import com.zikozee.salarydisseminator.model.MoneyBag;
import com.zikozee.salarydisseminator.repo.MoneyBagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MoneyBagServiceImplTest {

    @Mock
    MoneyBagRepository moneyBagRepository;

    @InjectMocks
    MoneyBagServiceImpl service;

    Set<MoneyBag> moneyBags;

    @BeforeEach
    void setUp() {
        moneyBags = new HashSet<>();
        moneyBags.add(new MoneyBag(1L,"food", "expenses", "access bank", "savings", 5000));
    }

    @Test
    void findAll() {
//        when(moneyBagRepository.findAll()).thenReturn(moneyBags);

//        assertEquals(1, moneyBags.size());
        verifyNoInteractions(moneyBagRepository);
    }

    @Test
    void findByBank() {
        verify(moneyBagRepository,never()).findByBank(anyString());
    }

    @Test
    void findByBankAndBankingAccountClass() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
        verify(moneyBagRepository,never()).save(any());
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}