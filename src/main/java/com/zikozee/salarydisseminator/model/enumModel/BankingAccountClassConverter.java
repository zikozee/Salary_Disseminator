//package com.zikozee.salarydisseminator.model.enumModel;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//
//@Converter(autoApply = true)
//public class BankingAccountClassConverter implements AttributeConverter<BankingAccountClass, String> {
//    @Override
//    public String convertToDatabaseColumn(BankingAccountClass bankingAccountClass) {
//        return bankingAccountClass.getShortName();
//    }
//
//    @Override
//    public BankingAccountClass convertToEntityAttribute(String dBData) {
//        return BankingAccountClass.fromShortName(dBData);
//    }
//}
