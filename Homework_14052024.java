package com.telran.homeworks;

//  1. Сформировать SQL запрос:  Вернуть все записи из cars, где параметры равны заданным, используя StringBuilder.
//  Если значение null, то параметр не должен попадать в запрос.
//  {"model", "V-60", "country", "Germany", "city", "Berlin", "year", null, "active", true}
//  Пример: {"id", 1, "country", null, "city", "Helsinki", "year", null}
//  Результат: SELECT * FROM users WHERE id = '1'  AND city = 'Helsilnki';
//
//  2. Метод isValidAccountNumber(String accountNumber) покрыть тестами

public class Homework_14052024 {
    public static void main(String[] args) {
//        String id = "1";
//        String model = "V-60";
//        String country = "Germany";
//        String city = "Berlin";
//        String year = null;
//        String active = "true";

        String tableName = "cars";
        String[] parameterName = {"id", "model", "country" , "city"  , "year", "active"};
        String[] parameter     = {"1",  "v-60",  "Germany" , "Berlin", null  , "true"};
//        String[] parameter     = {null,  "v-60",  "Germany" , "Berlin", null  , "true"};
//        String[] parameter     = {null,  "v-60",  "Germany" , "Berlin", null  , null};
//        String[] parameter     = {null,  "X-5",  null, null, null  , "true"};

        StringBuilder sb = new StringBuilder("SELECT * FROM " + tableName + " WHERE");
        for (int i = 0; i < parameter.length; i++) {
            if (sb.substring(sb.length() - 5).equals("WHERE")){
                sb.append(parameter[i] != null ? " " + parameterName[i] + "='" + parameter[i] + "'" : "");
            } else {
                sb.append(parameter[i] != null ? " AND " + parameterName[i] + "='" + parameter[i] + "'" : "");
            }
        }

        System.out.println(sb);
    }
}
