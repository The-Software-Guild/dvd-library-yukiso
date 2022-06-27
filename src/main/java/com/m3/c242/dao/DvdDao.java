package com.m3.c242.dao;

//        Allow the user to edit the information for an existing DVD in the collection
//        Allow the user to add, edit, or delete many DVDs in one session


import com.m3.c242.dto.Dvd;

import java.util.List;

public interface DvdDao {
    void addDvd(Dvd dvd) throws DvdDaoException;

    Dvd removeDvd(String Title) throws DvdDaoException;

    Dvd getDvd(String title) throws DvdDaoException;

    void editDvd(Dvd dvd, int field, String value) throws DvdDaoException;

    List<Dvd> getAllDvds() throws DvdDaoException;
}
