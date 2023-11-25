package interface_adapter.generate_meal;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class GenerateMealViewModel extends ViewModel {



    public GenerateMealViewModel() {
        super("Generated Meal View");
    }
    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
