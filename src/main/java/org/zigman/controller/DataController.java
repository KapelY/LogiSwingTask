package org.zigman.controller;

import org.zigman.model.Client;
import org.zigman.model.TextField;

import java.io.*;
import java.util.List;

public class DataController {
    private static final String FILE_NAME = "src/main/resources/source.data";

    @SuppressWarnings("unchecked")
    public static List<Client> readData() {
        FileInputStream fis;
        ObjectInputStream ois;
        List<Client> clientList = null;
        try {
            fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);
            clientList = (List<Client>) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            e.printStackTrace();
        }
        return clientList;
    }

    public static void writeData(List<Client> clientList) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(clientList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
