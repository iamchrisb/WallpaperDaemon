package de.home.wallpaperdeamon;

import de.home.wallpaperdeamon.control.TrayActivity;
import de.home.wallpaperdeamon.view.TrayView;
import de.home.wallpaperdeamon.view.TrayViewImpl;

public class Application {

   public static void main(String[] args) {
      //      IntByReference intPtr = new IntByReference();
      //      final int POINTER_SIZE = Pointer.SIZE * 265;
      //      final Pointer ptr = new Memory(POINTER_SIZE);
      //
      //      final boolean isWallpaperRunning = de.home.wallpaperdeamon.User32.INSTANCE.SystemParametersInfo(de.home.wallpaperdeamon.User32.SPI_GETSCREENSAVERRUNNING, 0, intPtr.getPointer(), 0);
      //      final boolean couldLoadWallpaper = de.home.wallpaperdeamon.User32.INSTANCE.SystemParametersInfo(de.home.wallpaperdeamon.User32.SPI_GETDESKWALLPAPER, 256, ptr, 0);
      //
      //      System.out.println(isWallpaperRunning);
      //      System.out.println(couldLoadWallpaper);
      //
      //      final char[] ptrContent = ptr.getCharArray(0, 256);
      //      final String path = String.valueOf(ptrContent);
      //      System.out.println(path);

      //      final boolean updateWallpaper = de.home.wallpaperdeamon.User32.INSTANCE.SystemParametersInfo(de.home.wallpaperdeamon.User32.SPI_SETDESKWALLPAPER, 0, wallpaperPath, de.home.wallpaperdeamon.User32.SPIF_UPDATEINIFILE | de.home.wallpaperdeamon.User32.SPIF_SENDWININICHANGE);
      //      final boolean updateWallpaper = de.home.wallpaperdeamon.User32.INSTANCE.SystemParametersInfo(de.home.wallpaperdeamon.User32.SPI_SETDESKWALLPAPER, 0, wallpaperPath, de.home.wallpaperdeamon.User32.SPIF_UPDATEINIFILE);

      //      String folderPath = "C:\\Users\\root\\Downloads\\chromecast1200\\";
      //      folderPath = "/Users/root1/Downloads/chromecast1200/";
      //
      //      final de.home.wallpaperdeamon.DesktopManager desktopManager = new de.home.wallpaperdeamon.DesktopManager(folderPath);
      //      desktopManager.rand();

      final TrayView trayView = new TrayViewImpl();
      TrayActivity trayActivity = new TrayActivity(trayView);
      trayView.setPresenter(trayActivity);

   }

}
