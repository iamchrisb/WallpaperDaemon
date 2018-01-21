public class Application {

   public static void main(String[] args) {
      //      IntByReference intPtr = new IntByReference();
      //      final int POINTER_SIZE = Pointer.SIZE * 265;
      //      final Pointer ptr = new Memory(POINTER_SIZE);
      //
      //      final boolean isWallpaperRunning = User32.INSTANCE.SystemParametersInfo(User32.SPI_GETSCREENSAVERRUNNING, 0, intPtr.getPointer(), 0);
      //      final boolean couldLoadWallpaper = User32.INSTANCE.SystemParametersInfo(User32.SPI_GETDESKWALLPAPER, 256, ptr, 0);
      //
      //      System.out.println(isWallpaperRunning);
      //      System.out.println(couldLoadWallpaper);
      //
      //      final char[] ptrContent = ptr.getCharArray(0, 256);
      //      final String path = String.valueOf(ptrContent);
      //      System.out.println(path);

      //      final boolean updateWallpaper = User32.INSTANCE.SystemParametersInfo(User32.SPI_SETDESKWALLPAPER, 0, wallpaperPath, User32.SPIF_UPDATEINIFILE | User32.SPIF_SENDWININICHANGE);
      //      final boolean updateWallpaper = User32.INSTANCE.SystemParametersInfo(User32.SPI_SETDESKWALLPAPER, 0, wallpaperPath, User32.SPIF_UPDATEINIFILE);

      String folderPath = "C:\\Users\\root\\Downloads\\chromecast1200\\";
      final DesktopManager desktopManager = new DesktopManager(folderPath);
      desktopManager.rand();
   }

}
