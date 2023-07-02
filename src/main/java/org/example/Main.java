package org.example;

import java.io.*;
import java.lang.module.Configuration;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // TELEFON UYGULAMASI
    public static Config config;
    public static String filename = "TelefonNumarasi.txt";
    public static void main(String[] args){
        System.out.println("Telefon uygulamasına hoşgeldin! ");
        //Dosya ürettim
        config = new org.example.Config();
        config.create();

        //Dosyanın içerisine yazmak için try catch
        try {
            //Dosya yazı yazma ve kaldığı satırdan devam etme
            FileWriter fileWriter = new FileWriter(filename,true);
            System.out.println("Telefon numarası girilebilir halde!");
            //Kullanıcdan giriş
            Scanner scanner = new Scanner(System.in);
            String telefonnumaraisim;
            do {
                telefonnumaraisim = scanner.nextLine();
                if (!telefonnumaraisim.equalsIgnoreCase("kapat"))
                {
                    //Kullanıcının girdiği verilerin aralarına boşluk bıraktırmak
                    String[] veri = telefonnumaraisim.split(" ");
                    String isim = veri[0];
                    String telefon = veri[1];
                    //Dosyayı okumak
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
                    {
                        String line;
                        //Dosyadaki satırların içerisini okumak
                        while ((line = bufferedReader.readLine()) != null)
                        {
                            //Dosyanın içinde isim değişkeninle aynı olan satır var mı yok mu kontrolü
                            if (isim != null && line.contains(isim))
                            {
                                //Aynı isimde bir yazı var ise es geçmesini yaptık
                                System.out.println( isim +" Bu ad ile kayıtlı bir kişi bulunmaktadır!");
                                isim = null;
                                telefon = null;
                                break;
                            }
                        }
                        //Kullanıcı değeri eğer boş değil ise
                        if (isim != null)
                        {
                            fileWriter.write( isim + " " + telefon + "\n");
                        }
                    }
                }
                //eğer kapat yazılırsa döngüden çıkar
            } while (!telefonnumaraisim.equalsIgnoreCase("kapat"));
            //Kaydet ve kapat
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}