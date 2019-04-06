/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author chrisjamesjoshy
 */
class JPEGImageFileFilter extends FileFilter implements java.io.FileFilter
         {
        @Override
         public boolean accept(File f)
           {
           if (f.getName().toLowerCase().endsWith(".jpeg")) return true;
           if (f.getName().toLowerCase().endsWith(".jpg")) return true;
           else return true;
           }
         @Override
         public String getDescription()
           {
           return "JPEG files";
           }

         }