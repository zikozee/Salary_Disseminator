package com.zikozee.salarydisseminator.model.enumModel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BankingAccountClassConverter implements AttributeConverter<BankingAccountClass, String> {

    @Override
    public String convertToDatabaseColumn(BankingAccountClass bankingAccountClass) {
        if (bankingAccountClass == null) {
            return null;
        }
        return bankingAccountClass.toString();
    }


    @Override
    public BankingAccountClass convertToEntityAttribute(String string) {
        if (string == null) {
            return null;
        }
        try {
            return BankingAccountClass.valueOf(string);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
