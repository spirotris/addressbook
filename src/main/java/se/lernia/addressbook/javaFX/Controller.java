package se.lernia.addressbook.javaFX;

import se.lernia.addressbook.javaFX.connectin.Connectin;
import se.lernia.addressbook.service.PersonService;

public abstract class Controller {
    protected PersonService pService;
    protected Main app; //Not a fan of this, but required for choosing window view

    public void setPersonService(PersonService pService) {
        this.pService = pService;
    }

    public void setApp(Main app) {
        this.app = app;
    }

    public Main getApp() {
        return app;
    }

}
