package com.m3.c242.dao;

import com.m3.c242.dto.Dvd;

import java.io.*;
import java.util.*;

public class DvdDaoFileImpl implements DvdDao {
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    private final Map<String, Dvd> dvds = new HashMap<>();

    private Dvd unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        return new Dvd(dvdTokens[0], dvdTokens[1], dvdTokens[2], dvdTokens[3], dvdTokens[4], dvdTokens[5]);
    }

    private String marshallDvd(Dvd dvd) {
        return String.format("%s::%s::%s::%s::%s::%s",
                dvd.getTitle(),
                dvd.getDate(),
                dvd.getMpaa(),
                dvd.getDirectorName(),
                dvd.getStudio(),
                dvd.getUserRatingNote());
    }

    @Override
    public void addDvd(Dvd dvd) throws DvdDaoException {
        loadLibrary();
        Dvd prevDvd = dvds.put(dvd.getTitle(), dvd);
        saveLibrary();
    }

    @Override
    public Dvd removeDvd(String title) throws DvdDaoException {
        loadLibrary();
        Dvd removedDvd = dvds.remove(title);
        saveLibrary();
        return removedDvd;

    }

    @Override
    public Dvd getDvd(String title) throws DvdDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public void editDvd(Dvd dvd, int field, String value) throws DvdDaoException {
        loadLibrary();
        dvds.remove(dvd.getTitle());
        switch (field) {
            case 1:
                dvd.setTitle(value);
                break;
            case 2:
                dvd.setDate(value);
                break;
            case 3:
                dvd.setMpaa(value);
                break;
            case 4:
                dvd.setDirectorName(value);
                break;
            case 5:
                dvd.setStudio(value);
                break;
            case 6:
                dvd.setUserRatingNote(value);
                break;
        }
        Dvd editedDvd = dvds.put(dvd.getTitle(), dvd);
        saveLibrary();

    }

    @Override
    public List<Dvd> getAllDvds() throws DvdDaoException {
        loadLibrary();
        return new ArrayList<>(dvds.values());
    }

    public void loadLibrary() throws DvdDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdDaoException("-_- Could not load library data into memory.", e);
        }
        String currentLine;
        Dvd currentDvd;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }

    public void saveLibrary() throws DvdDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdDaoException("Could not save student data.", e);
        }

        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
