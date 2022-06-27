package com.m3.c242.DVDController;

import com.m3.c242.dao.DvdDao;
import com.m3.c242.dao.DvdDaoException;
import com.m3.c242.dto.Dvd;
import com.m3.c242.ui.DvdView;

import java.util.List;


public class DvdController {
    private final DvdDao dao;
    private final DvdView view;

    public DvdController(DvdDao dao, DvdView view) {
        this.dao = dao;
        this.view = view;
    }

    private void createDvd() throws DvdDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd);
        view.displayCreateSuccessBanner();
    }

    private void editDvd() throws DvdDaoException {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        if (dvd == null)
            view.displayNotFound();
        else {
            int field = view.getEditDvdField();
            String value = view.getEditDvdValue();
            dao.editDvd(dvd, field, value);
            view.displayEditSuccessBanner();
        }
    }

    private void listDvds() throws DvdDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDVD(dvd);
    }

    private void removeDvd() throws DvdDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {
                menuSelection = view.printMenuAndGetSelection();

                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        viewDvd();
                        break;
                    case 3:
                        createDvd();
                        break;
                    case 4:
                        editDvd();
                        break;
                    case 5:
                        removeDvd();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
}

