package com.m3.c242.ui;

import com.m3.c242.dto.Dvd;

import java.util.List;

public class DvdView {
    private final UserIO io;

    public DvdView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        int menuSelection;
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. View DVD");
        io.print("3. Add DVD");
        io.print("4. Edit DVD");
        io.print("5. Remove DVD");
        io.print("6. Exit");

        menuSelection = io.readInt("Please select from the"
                + " above choices.", 1, 7);
        return menuSelection;
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter title: ");
        String date = io.readString("Please enter date: ");
        String mpaa = io.readString("Please enter MPAA rating: ");
        String directorName = io.readString("Please enter director's name: ");
        String studio = io.readString("Please enter studio name: ");
        String userRatingNote = io.readString("Please enter user rating and notes: ");
        return new Dvd(title, date, mpaa, directorName, studio, userRatingNote);
    }

    public String getEditDvdValue() {
        return io.readString("Please enter field value: ");
    }

    public int getEditDvdField() {
        io.print("1. Title");
        io.print("2. Date");
        io.print("3. MPAA Rating");
        io.print("4. Director's name");
        io.print("5. Studio");
        io.print("6. User rating and notes");
        return io.readInt("Please enter field: ", 1, 6);
    }

    public void displayDvdList(List<Dvd> DvdList) {
        for (Dvd currentDvd : DvdList) {
            io.print(currentDvd.toString());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(Dvd dvd) {
        if (dvd != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }

    public void displayDVD(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.toString());
        } else {
            displayNotFound();
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayNotFound() {
        io.print("No such DVD.");
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayEditDvdBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayEditSuccessBanner() {
        io.readString(
                "DVD successfully edited.  Please hit enter to continue");
    }
}
