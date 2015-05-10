package TuringMachine;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * Main class - creates the TuringMachineFrame and places it on the screen
 * 
 * @author Owen F. Kellett
 * @version 1.0
 */

public class TuringMachineApp {
  private static int instances = 0;
  private boolean packFrame = false;

  // Construct the application
  public TuringMachineApp(File inputFile) {
    TuringMachineFrame frame = new TuringMachineFrame(inputFile);
    // Validate frames that have preset sizes
    // Pack frames that have useful preferred size info, e.g. from their layout
    if( packFrame ) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    frame.setSize( new Dimension( 1024, 764 ) );
    // Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if( frameSize.height > screenSize.height ) {
      frameSize.height = screenSize.height;
    }
    if( frameSize.width > screenSize.width ) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation( ( screenSize.width - frameSize.width ) / 2,
        ( screenSize.height - frameSize.height ) / 2 );
    frame.setVisible( true );
    instances++;
  }
  
  public static void close() {
	  instances--;
	  if(instances == 0) {
		  System.exit(0);
	  }
  }
  
  public static void createNewInstance() {
	    TuringMachineFrame frame = new TuringMachineFrame();
	    // Validate frames that have preset sizes
	    // Pack frames that have useful preferred size info, e.g. from their layout

	    frame.validate();
	    frame.setSize( new Dimension( 1024, 764 ) );
	    // Center the window
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension frameSize = frame.getSize();
	    if( frameSize.height > screenSize.height ) {
	      frameSize.height = screenSize.height;
	    }
	    if( frameSize.width > screenSize.width ) {
	      frameSize.width = screenSize.width;
	    }
	    frame.setLocation( ( screenSize.width - frameSize.width ) / 2,
	        ( screenSize.height - frameSize.height ) / 2 );
	    frame.setVisible( true );
	    instances++;
  }

  // Main method
  public static void main( String[] args ) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch ( Exception e ) {
      e.printStackTrace();
    }
    File file = null;
    if(args.length > 0) {
    	file = new File(args[0]);
    }

    new TuringMachineApp(file);
  }
}
