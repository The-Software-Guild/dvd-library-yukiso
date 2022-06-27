package com.m3.c242;


//In this assessment, you will create a program that stores information about a DVD collection. The program must do the following:
//
//        Allow the user to add a DVD to the collection
//        Allow the user to remove a DVD from the collection
//        Allow the user to edit the information for an existing DVD in the collection
//        Allow the user to list the DVDs in the collection
//        Allow the user to display the information for a particular DVD
//        Allow the user to search for a DVD by title
//        Load the DVD library from a file
//        Save the DVD library back to the file when the program completes
//        Allow the user to add, edit, or delete many DVDs in one session
//
//Additionally, the program must follow the MVC design pattern and use dependency injection as shown in the course material.
//
//        You should follow the process outlined in the Agile Approach Checklist for Console Applications document elsewhere in this course.
//
//        Your DVD data transfer object should have the following fields:
//
//        Title
//        Release date
//        MPAA rating
//        Director's name
//        Studio
//        User rating or note (allows the user to enter additional information, e.g., "Good family movie")

import com.m3.c242.DVDController.DvdController;
import com.m3.c242.dao.DvdDao;
import com.m3.c242.dao.DvdDaoFileImpl;
import com.m3.c242.ui.DvdView;
import com.m3.c242.ui.UserIO;
import com.m3.c242.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdView myView = new DvdView(myIo);
        DvdDao myDao = new DvdDaoFileImpl();
        DvdController controller = new DvdController(myDao, myView);
        controller.run();

    }
}