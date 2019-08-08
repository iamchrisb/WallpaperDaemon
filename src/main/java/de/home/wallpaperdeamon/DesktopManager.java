package de.home.wallpaperdeamon;

import de.home.wallpaperdeamon.util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.jna.Platform;

public class DesktopManager {

   private File currentFile;
   private File[] wallpapers;

   public void setWallpaper(final String wallpaperPath) {
      if (Platform.isWindows()) {
         setWallpaperWin(wallpaperPath);
      } else if (Platform.isMac()) {
         setWallpaperMac(wallpaperPath);
      } else {
         throw new IllegalArgumentException("unsupported OS");
      }
   }

   private void setWallpaperMac(final String wallpaperPath) {
      Runtime runtime = Runtime.getRuntime();
      String[] args = { "osascript", "-e", "tell application \"Finder\" to set desktop picture to POSIX file \"" + wallpaperPath + "\"" };

      try {
         Process process = runtime.exec(args);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private void setWallpaperWin(final String wallpaperPath) {
      User32.INSTANCE.SystemParametersInfo(User32.SPI_SETDESKWALLPAPER, 0, wallpaperPath, User32.SPIF_SENDWININICHANGE | User32.SPIF_UPDATEINIFILE);
   }

   /**
    * @param folderPath
    *       path to look for random wallpaper
    */
   public DesktopManager(final String folderPath) {
      this.currentFile = new File(folderPath);

      if (!currentFile.exists()) {
         throw new IllegalArgumentException("folder does not exist");
      }

      if (!currentFile.isDirectory()) {
         throw new IllegalArgumentException("given path is no folder");
      }

      final File[] files = currentFile.listFiles(pathname -> {
         final String absolutePath = pathname.getAbsolutePath();
         if (absolutePath.contains(Constants.JPG) || absolutePath.contains(Constants.JPEG)) {
            return true;
         }
         return false;
      });

      this.wallpapers = files;
   }

   public void rand() {
      final Timer timer = new Timer();
      timer.schedule(new TimerTask() {
         @Override
         public void run() {
            File currentWallpaper = wallpapers[new Random().nextInt(wallpapers.length)];

            //@cbl TODO
            System.out.println(currentWallpaper.getAbsolutePath());
            setWallpaper(currentWallpaper.getAbsolutePath());
         }
      }, Constants.DEFAULT_DELAY, Constants.DEFAULT_PERIOD);
   }

   public void next() {
      File currentWallpaper = wallpapers[new Random().nextInt(wallpapers.length)];
      setWallpaper(currentWallpaper.getAbsolutePath());
   }
}
