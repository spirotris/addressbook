package se.lernia.addressbook.javaFX;

import se.lernia.addressbook.javaFX.connectin.Connectin;

public abstract class Controller {
    protected Connectin contin;
    protected Main app; //Not a fan of this, but required for choosing window view

    public void setConnectin(Connectin contin) {
        this.contin = contin;
    }

    public void setApp(Main app) {
        this.app = app;
    }

    public Main getApp() {
        return app;
    }

}
