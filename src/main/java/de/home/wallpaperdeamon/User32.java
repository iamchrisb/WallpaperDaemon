package de.home.wallpaperdeamon;

import java.util.HashMap;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIFunctionMapper;
import com.sun.jna.win32.W32APITypeMapper;

public interface User32 extends StdCallLibrary {
   public static final int SPI_GETDESKWALLPAPER = 0x0073;
   public static final int SPI_GETSCREENSAVERRUNNING = 114;

   //from MSDN article
   int SPI_SETDESKWALLPAPER = 20;
   int SPIF_UPDATEINIFILE = 0x01;
   int SPIF_SENDWININICHANGE = 0x02;

   String USER_32_LIB = "user32";

   User32 INSTANCE = (User32) Native.loadLibrary(USER_32_LIB, User32.class, new HashMap<String, Object>() {
      {
         put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
         put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
      }
   });

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
