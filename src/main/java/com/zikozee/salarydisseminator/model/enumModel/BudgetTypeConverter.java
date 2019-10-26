//package com.zikozee.salarydisseminator.model.enumModel;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//
//@Converter(autoApply = true)
//public class BudgetTypeConverter implements AttributeConverter<BudgetType, String> {
//    @Override
//    public String convertToDatabaseColumn(BudgetType budgetType) {
//        return budgetType.getShortName();
//    }
//
//    @Override
//    public BudgetType convertToEntityAttribute(String dbData) {
//        return BudgetType.fromShortName(dbData);
//    }
//}
