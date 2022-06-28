package com.m3.c242;

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