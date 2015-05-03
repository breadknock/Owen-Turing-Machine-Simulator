package TuringMachine;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.*;

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


public class TapePanel extends JScrollPane {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  public TapePanel() {
    super();
  }

  public TapePanel( JTable tape ) {
    super( tape );
  }

  public Dimension getMinimumSize() {
    return new Dimension( 500, 75 );
  }

  public Dimension getPreferredSize() {
    return new Dimension( 500, 75 );
  }
}

