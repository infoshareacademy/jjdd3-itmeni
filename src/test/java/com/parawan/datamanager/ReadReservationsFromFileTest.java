package com.parawan.datamanager;

import com.parawan.Beach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReadReservationsFromFileTest {

    @Test
    void shouldThrowIOException() {
        Throwable exception = assertThrows(IOException.class, () -> {
            BufferedReader br = new BufferedReader(new FileReader("smth.smth"));
        });
    }



}
