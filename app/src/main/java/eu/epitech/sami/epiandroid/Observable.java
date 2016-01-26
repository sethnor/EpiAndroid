package eu.epitech.sami.epiandroid;

/**
 * Created by mathie_t on 26/01/16
 */

public interface Observable {
    public void addObserver(Observer obs);
    public void removeObserver();
    public void notifyObserver(Object... objs);
}