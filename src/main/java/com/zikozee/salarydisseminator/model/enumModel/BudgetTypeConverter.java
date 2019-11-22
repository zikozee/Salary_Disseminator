package com.zikozee.salarydisseminator.model.enumModel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BudgetTypeConverter implements AttributeConverter<BudgetType, String> {
    @Override
    public String convertToDatabaseColumn(BudgetType budgetType) {
        if (budgetType == null) {
            return null;
        }
        return budgetType.toString();
    }


    @Override
    public BudgetType convertToEntityAttribute(String string) {
        if (string == null) {
            return null;
        }
        try {
            return BudgetType.valueOf(string);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
