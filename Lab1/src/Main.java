import MVC.Controllers.CarController;
import MVC.Model.ModelWorld;
import MVC.Model.TimerListener;
import MVC.Views.CarView;
import MVC.Views.DrawPanel;

import javax.swing.*;


public static void main(String[] args) {
    final int delay = 50;
    ModelWorld model = new ModelWorld();
    DrawPanel drawPanel = new DrawPanel(800, 560, model);
    TimerListener timerListener = new TimerListener(model);
    CarController cc = new CarController(model);
    CarView view = new CarView("CarSim 1.0",cc, drawPanel);
    Timer timer = new Timer(delay, timerListener);
    timerListener.addObserver(view);

    timer.start();
}