package agh.zti.welp.controllers.presentations;

import agh.zti.welp.persistence.User;

public class UserPresentation {

    private String login;
    private long id;

    public UserPresentation(){

    }

    public UserPresentation(User user){
        this.id = user.getId();
        this.login = user.getLogin();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
