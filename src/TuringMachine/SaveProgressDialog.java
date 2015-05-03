package TuringMachine;

import javax.swing.JFileChooser;
import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.print.*;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class SaveProgressDialog extends JDialog
{
  public JProgressBar saveProgressBar;
  public JLabel indicator;

  public SaveProgressDialog(int number, Frame owner)
  {
    super(owner);
    saveProgressBar = new JProgressBar(0,number*2);
    indicator = new JLabel("Saving Execution Sequence...");
    Container myPane = getContentPane();
    GridLayout myLayout = new GridLayout(2,1);
    myPane.setLayout(myLayout);
    myPane.add(indicator);
    myPane.add(saveProgressBar);
    setSize(200, 100);
    center();
    setTitle("Save Progress");
    repaint();
  }

  public void center()
  {
    Dimension screenSize =
        Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

    Dimension frameSize = this.getSize();
    int x = (screenWidth - frameSize.width)/2;
    int y = (screenHeight - frameSize.height)/2;

    if (x < 0)
    {
      x = 0;
      frameSize.width = screenWidth;
    }

    if (y < 0)
    {
      y = 0;
      frameSize.height = screenHeight;
    }
    this.setLocation(x, y);
  }
}
