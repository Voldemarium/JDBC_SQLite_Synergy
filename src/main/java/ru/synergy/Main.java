package ru.synergy;

public class Main {
    public static void main(String[] args) {
//  1. Что такое SQLite?
//         SQLite - это встроенная легковесная система управления  реляционными базами данных
//         при локальном хранении БД на устройстве, где эта СУБД и запускается.
        String urlDB = "mySQLiteDB";
        DDL ddl = new DDL(urlDB);
        UPDATE update = new UPDATE(urlDB);
        SELECT select = new SELECT(urlDB);
        ddl.createTable();
//        update.insertQuery();

//  2. Напишите запрос для отображения имен (first_name,last_name), используя псевдонимы «Имя»,«Фамилия».
        select.printNames();
//  3. Напишите запрос и получите все имена из таблицы сотрудников в верхнем регистре
        System.out.println(select.getUpperCaseNames());
//  4. Напишите запрос и получите все id сотрудников
        System.out.println(select.getAllId());
//  5. Напишите запрос, чтобы получить первые 3 символа имени из таблицы сотрудников
        System.out.println(select.getFirstThreeLettersOfNames());
//  6. Напишите запрос, чтобы выбрать первые 5 записей из таблицы.
        select.printFirstFiveEntries();
    }
}