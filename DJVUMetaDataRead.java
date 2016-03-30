/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package djvutests;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import sun.management.FileSystem;

/**
 *
 * @author YOUNG PROGRAMMER
 */
public class DJVUMetaDataRead {
    public static void main(String[] args) throws IOException {
        java.nio.file.FileSystem filesys;
        filesys = FileSystems.getDefault();
        for(FileStore store:filesys.getFileStores()){
            System.out.println(store.toString());
            for(String view :filesys.supportedFileAttributeViews()){
            if(store.supportsFileAttributeView(view)){
                System.out.println(view+" ");
            }
            }
        }
    }   
}