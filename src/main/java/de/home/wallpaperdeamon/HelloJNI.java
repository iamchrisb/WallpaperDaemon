package de.home.wallpaperdeamon;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class HelloJNI {

   public interface CLib extends Library {

      CLib INSTANCE = (CLib) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLib.class);

      void printf(String format, Object... args);
   }

   public static void main(String[] args) {
      CLib.INSTANCE.printf("Hello World\n");

      for (int i = 0; i < args.length; i++) {
         CLib.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
      }
   }
}
