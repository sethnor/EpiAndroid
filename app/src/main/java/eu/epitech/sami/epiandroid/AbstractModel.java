package eu.epitech.sami.epiandroid;

import android.util.Log;

import eu.epitech.sami.epiandroid.Observable;
import eu.epitech.sami.epiandroid.Observer;

/**
 * Created by mathie_t on 26/01/2016.
 */
public abstract class AbstractModel implements Observable {
    private Observer observer = null;

    public void addObserver(Observer obs) {
        observer = obs;
        }

    public void notifyObserver(Object... objs) {
        Log.e("test", "Observer Notification");
        if (observer != null)
        observer.update(objs);
        }

    public void removeObserver() {
        observer = null;
        //listObserver = new ArrayList<Observer>();
        }
}
