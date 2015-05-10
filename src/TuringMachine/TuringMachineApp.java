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
  private int instances;

  public TuringMachineApp() {
	  instances = 0;
  }
  
  public void close() {
	  instances--;
	  if(instances == 0) {
		  System.exit(0);
	  }
  }
  
  public void createNewInstance(File inputFile) {
	    JFrame frame = new TuringMachineFrame(this,inputFile);
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
    TuringMachineApp tma = new TuringMachineApp();
    tma.createNewInstance(file);
  }
}
