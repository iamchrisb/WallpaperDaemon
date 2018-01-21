import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIFunctionMapper;
import com.sun.jna.win32.W32APITypeMapper;

public class DesktopManager {

   private File currentFile;
   private File[] wallpapers;

   private int DEFAULT_PERIOD = 10000;
   private int DEFAULT_DELAY = 10000;

   public interface User32 extends StdCallLibrary {
      //from MSDN article
      int SPI_SETDESKWALLPAPER = 20;
      int SPIF_UPDATEINIFILE = 0x01;
      int SPIF_SENDWININICHANGE = 0x02;

      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, new HashMap<String, Object>() {
         {
            put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
            put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
         }
      });

      public static final int SPI_GETDESKWALLPAPER = 0x0073;
      public static final int SPI_GETSCREENSAVERRUNNING = 114;

      boolean SystemParametersInfo(
            int uiAction,
            int uiParam,
            Pointer pvParam,
            int fWinIni
      );

      boolean SystemParametersInfo(
            int uiAction,
            int uiParam,
            String pvParam,
            int fWinIni
      );
   }

   public void setWallpaper(final String wallpaperPath) {
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
         if (absolutePath.contains(".jpg") || absolutePath.contains(".jpeg")) {
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
            setWallpaper(currentWallpaper.getAbsolutePath());
         }
      }, DEFAULT_DELAY, DEFAULT_PERIOD);
   }
}
