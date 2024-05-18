package com.telran.homeworks;

//  1. Сформировать SQL запрос:  Вернуть все записи из cars, где параметры равны заданным, используя StringBuilder.
//  Если значение null, то параметр не должен попадать в запрос.
//  {"model", "V-60", "country", "Germany", "city", "Berlin", "year", null, "active", true}
//  Пример: {"id", 1, "country", null, "city", "Helsinki", "year", null}
//  Результат: SELECT * FROM users WHERE id = '1'  AND city = 'Helsilnki';

public class Homework_14052024 {
    public static void main(String[] args) {

        String inputData = "{\"model\", \"V-60\", \"country\", \"Germany\", \"city\", \"Berlin\", \"year\", null, \"active\", true}";
        String tableName = "cars";
        int numberOfParameters = getNumbersOfParameters(inputData);
        String[] parameterName = new String[numberOfParameters];
        String[] parameter = new String[numberOfParameters];

        splitInputToArrays(inputData, parameterName, parameter);
        String request = getSelect(tableName, parameterName, parameter);
        System.out.println(request);
    }

    public static int getNumbersOfParameters(String str) {
        int numberOfParameters = 0;
        int qouteCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\"') {
                qouteCounter++;
            }
            if (qouteCounter % 2 == 0 && str.charAt(i) == ',') {         // если кавычка закрыта, то запятую считаем
                numberOfParameters++;
            }
        }
        return (numberOfParameters + 1) / 2;
    }

    public static void splitInputToArrays(String str, String[] parNames, String[] params) {
        String newStr = str.replace("{", "").replace("}", "").replace(", ", ",").replace("\"", "");
        String[] inputs = newStr.split(",");
        for (int i = 0; i < inputs.length; i += 2) {
            parNames[i / 2] = inputs[i];
            params[i / 2] = inputs[i + 1].equals("null") ? null : inputs[i + 1];
        }
    }

    public static String getSelect(String tableName, String[] parameterNames, String[] parameters) {
        StringBuilder sb = new StringBuilder("SELECT * FROM " + tableName + " WHERE");
        for (int i = 0; i < parameters.length; i++) {
            if (sb.substring(sb.length() - 5).equals("WHERE")) {
                sb.append(parameters[i] != null ? " " + parameterNames[i] + "='" + parameters[i] + "'" : "");
            } else {
                sb.append(parameters[i] != null ? " AND " + parameterNames[i] + "='" + parameters[i] + "'" : "");
            }
        }
        return sb.toString();
    }
}
