package de.home.wallpaperdeamon.view;

public interface TrayView {

   public enum STATUS {
      RUNNING,
      PAUSED;
   }

   interface Presenter {
      void onChoosePathSelected(String path);

      String getCurrentFolderPath();

      void start();
   }

   void setPresenter(Presenter presenter);
}
