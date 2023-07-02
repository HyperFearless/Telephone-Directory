package org.example;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Config {

    public static Main main;
    public void create()
    {
        if (main.filename == null) {
            throw new IllegalArgumentException("Filename cannot be null.");
        }
        File file = new File(main.filename);
        try {
            file.createNewFile();
            System.out.println("Telefon dosyasi oluşturuldu!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
