package com.zikozee.salarydisseminator.model.enumModel;

public enum BudgetType {
    EXPENSES, SAVINGS, SPEND_LATER, MISCELLANEOUS;
    //EXPENSES("E"), SAVINGS("S"), SPEND_LATER("S_L"), MISCELLANEOUS("M");
//
//    private String shortName;
//
//    BudgetType(String shortName) {
//        this.shortName = shortName;
//    }
//
//    public String getShortName() {
//        return shortName;
//    }
//
//    public static BudgetType fromShortName(String shortName) {
//        switch (shortName) {
//            case "E":
//                return BudgetType.EXPENSES;
//
//            case "S":
//                return BudgetType.SAVINGS;
//
//            case "S_L":
//                return BudgetType.SPEND_LATER;
//
//            case "M":
//                return BudgetType.MISCELLANEOUS;
//
//            default:
//                throw new IllegalArgumentException("ShortName [" + shortName
//                        + "] not supported.");
//        }
//    }
}
