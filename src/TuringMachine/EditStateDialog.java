package TuringMachine;

import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;


/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */

public class EditStateDialog extends JDialog {
  /**
	 * 
	 */
  private static final long serialVersionUID = 8314741997670570749L;
  JLabel stateName = new JLabel( "State Name: ", JLabel.RIGHT );
  JTextField stateText = new JTextField();
  JLabel halting = new JLabel( "Halting State: ", JLabel.RIGHT );
  JCheckBox halt = new JCheckBox();
  JButton ok = new JButton( "OK" );
  JButton cancel = new JButton( "Cancel" );
  State newState;
  Vector<State> states;

  EditStateDialog( State newState, Vector<State> states ) {
    this.newState = newState;
    this.states = states;
    halt.setSelected(newState.finalState);
    Container mypane = getContentPane();
    mypane.setLayout( new GridLayout( 3, 2, 0, 0 ) );
    setTitle( "Edit State Settings" );

    stateText.setText( newState.stateName );
    mypane.add( stateName );
    mypane.add( stateText );
    mypane.add( halting );
    mypane.add( halt );
    mypane.add( ok );
    mypane.add( cancel );

    ok.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent e ) {
        if( stateText.getText().length() > 0 ) {
          if (updateState()) {
            dispose();
            }
        }
      }
    } );
    cancel.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent e ) {
        if( stateText.getText().length() > 0 ) {
          dispose();
        }
      }
    } );
  }

  boolean updateState() {
    boolean current = false;
    boolean start = false;
    for( State s : states) {
      if(s == newState) {
        continue;
      }

      if( ( s.currentState ) ) current = true;
      if( ( s.startState ) ) start = true;
      if( s.stateName.equals(stateText.getText())) {
        WarningBox wb = new WarningBox("Error: This state name is already taken",this);
        wb.validate();
        wb.setVisible(true);
        return false;
      }
    }
    if( !current ) newState.currentState = true;
    if( !start ) newState.startState = true;

    newState.stateName = stateText.getText();
    newState.finalState = halt.isSelected();

    return true;
  }

  void removeState() {
    states.removeElement( newState );
  }

  public void center() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

    Dimension frameSize = this.getSize();
    int x = ( screenWidth - frameSize.width ) / 2;
    int y = ( screenHeight - frameSize.height ) / 2;

    if( x < 0 ) {
      x = 0;
      frameSize.width = screenWidth;
    }

    if( y < 0 ) {
      y = 0;
      frameSize.height = screenHeight;
    }
    this.setLocation( x, y );
  }
}

