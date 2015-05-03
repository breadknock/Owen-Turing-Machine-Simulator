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


public class TapeCellRenderer extends DefaultTableCellRenderer {
	  /**
		 * 
		 */
	  private static final long serialVersionUID = 1L;

	  public TapeCellRenderer() {
	    setOpaque( true );
	  }

	  public Component getTableCellRendererComponent( JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column ) {
	    super.getTableCellRendererComponent(table, value, false, hasFocus, row, column);
	    this.setToolTipText("Enter ^ to set the pointer location");
	    setHorizontalAlignment(SwingConstants.CENTER);
	    return this;
	  }
	}


