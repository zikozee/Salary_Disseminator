package com.zikozee.salarydisseminator.controller;

import com.zikozee.salarydisseminator.model.MoneyBag;
import com.zikozee.salarydisseminator.model.enumModel.BankingAccountClass;
import com.zikozee.salarydisseminator.model.enumModel.BudgetType;
import com.zikozee.salarydisseminator.service.MoneyBagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MoneyBagControllerTest {
    @Mock
    MoneyBagService moneyBagService;

    @InjectMocks
    MoneyBagController controller;

    MockMvc mockMvc;

    Set<MoneyBag> moneyBags;
    MoneyBag bag;

    @BeforeEach
    void setUp() {
        moneyBags = new HashSet<>();
        bag = new MoneyBag(1L,"budget", BudgetType.EXPENSES, "access bank", BankingAccountClass.SAVINGS, 50000);
        moneyBags.add(bag);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller).build();

    }

    @Test
    void getHomepage() throws Exception {
        when(moneyBagService.findAll()).thenReturn(moneyBags);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("moneyBag"))
                .andExpect(view().name("moneyBaggee/index"));

        verify(moneyBagService, times(1)).findAll();
        assertEquals(1, moneyBagService.findAll().size());
    }

    @Test
    void showFormForAdd() throws Exception {

        mockMvc.perform(get("/showFormForAdd"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("aMoneyBag", "budgetChooser", "bankType"))
                .andExpect(view().name("moneyBaggee/addForm"));
    }

    @Test
    void showFormForUpdate() throws Exception {
        MoneyBag moneyBag = new MoneyBag();
        moneyBag.setId(1L);

        when(moneyBagService.findById(anyLong())).thenReturn(moneyBag);

        mockMvc.perform(get("/showFormForUpdate?moneyBagId=1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("aMoneyBag", "budgetChooser", "bankType"))
                .andExpect(view().name("moneyBaggee/addForm"));
    }

    @Test
    void saveEmployee() throws Exception {
        moneyBags.add(new MoneyBag(2L,"budget", BudgetType.EXPENSES, "access bank", BankingAccountClass.SAVINGS, 20000));

        when(moneyBagService.findAll()).thenReturn(moneyBags);
        assertEquals(2, moneyBagService.findAll().size());

        mockMvc.perform(post("/save"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void showFormForDelete() throws Exception {
        when(moneyBagService.findAll()).thenReturn(moneyBags);
        moneyBags.remove(bag);

        mockMvc.perform(get("/delete?moneyBagId=1"))
                .andExpect(status().is3xxRedirection());

        assertEquals(0, moneyBagService.findAll().size());

        verify(moneyBagService, never()).findById(anyLong());

    }

}