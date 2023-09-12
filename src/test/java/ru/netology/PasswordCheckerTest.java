package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PasswordCheckerTest {
    @ParameterizedTest
    @CsvSource(value = {"8,2,wqwqwqqw,true",
            "9,2,dwlwkd,false",
            "9,3,ffffjkljl,true"
    })
    public void passwordCheckerTester(String minLenght, String maxRepits, String password, boolean expected){
        PasswordChecker checker = new PasswordChecker(Integer.parseInt(minLenght),Integer.parseInt(maxRepits));
        boolean actual = checker.verify(password);
        Assertions.assertEquals(expected,actual);
    }
}
