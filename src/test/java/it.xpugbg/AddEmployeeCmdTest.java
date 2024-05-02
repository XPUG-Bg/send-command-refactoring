package it.xpugbg;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddEmployeeCmdTest {


    @Test
    void write_test() throws Exception {

        String name = "Pippo";
        String address = "Via LeDitaDalNaso";
        String city = "Bergamo";
        String state = "Italy";
        int yearlySalary = 50000;
        AddEmployeeCmd addEmployeeCmd = new AddEmployeeCmd(name, address, city, state, yearlySalary);

        var outputStream = new ByteArrayOutputStream();
        addEmployeeCmd.write(outputStream);
        String actualOutput = Base64.getEncoder().encodeToString(outputStream.toByteArray());

        String expectedOutput = "3q0yAlBpcHBvAFZpYSBMZURpdGFEYWxOYXNvAEJlcmdhbW8ASXRhbHkANTAwMDAAvu8=";
        assertEquals(expectedOutput, actualOutput);

    }

}