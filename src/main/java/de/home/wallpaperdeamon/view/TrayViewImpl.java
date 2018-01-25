package de.home.wallpaperdeamon.view;

import de.home.wallpaperdeamon.util.Constants;

import java.awt.*;

import javax.swing.*;

public class TrayViewImpl implements TrayView {

   public static final String SET_WALLPAPER_FOLDER_PATH = "Set wallpaper folder path";
   public static final String INSERT_FOLDER_PATH = "Insert folder path";
   public static final String SHOW_CURRENT_PATH = "Show current path";
   public static final String PAUSE = "Pause";
   public static final String KILL = "Kill";
   public static final String START = "Start";

   public TrayViewImpl() {
      if (!SystemTray.isSupported()) {
         System.out.println("System tray is not supported!");
         return;
      }

      SystemTray systemTray = SystemTray.getSystemTray();

      Image image = Toolkit.getDefaultToolkit()
            .getImage(Constants.TRAY_ICON_PATH);

      PopupMenu trayPopupMenu = new PopupMenu();

      statusEntry = new MenuItem("");
      trayPopupMenu.add(statusEntry);
      setStatus(STATUS.PAUSED);

      trayPopupMenu.addSeparator();

      MenuItem startItem = new MenuItem(START);
      startItem.addActionListener(e -> {
         if (presenter == null) {
            return;
         }
         setStatus(STATUS.RUNNING);
         presenter.start();

      });
      trayPopupMenu.add(startItem);
      //      startItem.setEnabled(false);

      MenuItem action = new MenuItem(SET_WALLPAPER_FOLDER_PATH);
      action.addActionListener(e -> {
         //         JOptionPane.showMessageDialog(null, "Sliding images..");
         //         System.out.println("Menu clicked");
         JOptionPane.showInputDialog(INSERT_FOLDER_PATH);
      });
      trayPopupMenu.add(action);

      final MenuItem showCurrentPath = new MenuItem(SHOW_CURRENT_PATH);
      trayPopupMenu.add(showCurrentPath);
      trayPopupMenu.addActionListener(e -> {
         if (presenter == null) {
            return;
         }
         JOptionPane.showMessageDialog(null, presenter.getCurrentFolderPath());
      });

      MenuItem pauseItem = new MenuItem(PAUSE);
      pauseItem.addActionListener(e -> {
         setStatus(STATUS.PAUSED);

      });
      trayPopupMenu.add(pauseItem);
      pauseItem.setEnabled(false);

      trayPopupMenu.addSeparator();

      MenuItem close = new MenuItem(KILL);
      close.addActionListener(e -> System.exit(0));
      trayPopupMenu.add(close);

      final String tooltip = "Wallpaper Deamon" + " | Current path: /Users/root1/Downloads/chromecast1200/";

      TrayIcon trayIcon = new TrayIcon(image, tooltip, trayPopupMenu);
      trayIcon.setImageAutoSize(true);

      try {
         systemTray.add(trayIcon);
      } catch (AWTException awtException) {
         awtException.printStackTrace();
      }
   }

   private void setStatus(final STATUS status) {
      this.statusEntry.setLabel(STATUS_STRING + status.name());
   }

   @Override
   public void setPresenter(final Presenter presenter) {
      this.presenter = presenter;
   }

   private Presenter presenter;
   private MenuItem statusEntry;
   public static final String STATUS_STRING = "Status: ";
}
