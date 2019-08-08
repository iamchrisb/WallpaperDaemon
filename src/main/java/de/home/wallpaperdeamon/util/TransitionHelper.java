package de.home.wallpaperdeamon.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TransitionHelper {

   public BufferedImage fadeTwoPictures(File picture1, File picture2) {
      try {
         BufferedImage imgA = ImageIO.read(picture1);
         BufferedImage imgB = ImageIO.read(picture2);

         if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
            float alpha = 0.5f;
            int compositeRule = AlphaComposite.SRC_OVER;
            AlphaComposite ac;
            int imgW = imgA.getWidth();
            int imgH = imgA.getHeight();
            BufferedImage overlay = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = overlay.createGraphics();
            ac = AlphaComposite.getInstance(compositeRule, alpha);
            g.drawImage(imgA, 0, 0, null);
            g.setComposite(ac);
            g.drawImage(imgB, 0, 0, null);
            g.setComposite(ac);
            //ImageIO.write(overlay, "PNG", new File(logFolder, browser + "__" + token));
            g.dispose();
         } else {
            //System.err.println(token + " dymension not match ");
         }
      } catch (IOException e) {
      }
      return null;
   }
}
