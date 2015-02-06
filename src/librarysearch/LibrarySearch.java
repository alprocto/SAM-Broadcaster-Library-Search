/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysearch;

/**
 *
 * @author alprocto
 */
public class LibrarySearch {
    
    public static void main(String[] args) {
        Functions.setDBInfo("database.properties");
        SearchFrame.main(args);
        
    }
}
