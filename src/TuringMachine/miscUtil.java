package TuringMachine;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

public class miscUtil {

  public static boolean isLetterOrDigit( char ch ) { // for Java 1.0
    String list = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
        + "0123456789";
    return( list.indexOf( ch ) > -1 );
  }
}
