package de.home.wallpaperdeamon;

import de.home.wallpaperdeamon.control.TrayActivity;
import de.home.wallpaperdeamon.view.TrayView;
import de.home.wallpaperdeamon.view.TrayViewImpl;

public class Application {

   public static void main(String[] args) {
      final TrayView trayView = new TrayViewImpl();
      TrayActivity trayActivity = new TrayActivity(trayView);
      trayView.setPresenter(trayActivity);
   }

}
