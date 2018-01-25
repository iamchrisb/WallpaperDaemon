package de.home.wallpaperdeamon.util;

import java.io.File;

public class Constants {

   /**
    * file extensions
    */
   public static final String JPG = ".jpg";
   public static final String JPEG = ".jpeg";

   /**
    * time constants
    */
   public static final int SECOND = 1000;
   public static final int MINUTE = SECOND * 60;
   public static final int DEFAULT_PERIOD = MINUTE * 5;
   public static final int DEFAULT_DELAY = MINUTE * 5;

   /**
    * paths
    */
   public static final String WORKING_DIR = System.getProperty("user.dir");
   public static final String RES_DIR = WORKING_DIR + File.separator + "resources";
   public static final String IMAGES_DIR = RES_DIR + File.separator + "images";
   public static final String TRAY_ICON_PATH = IMAGES_DIR + File.separator + "tray.jpeg";
}
