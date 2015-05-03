package TuringMachine;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

public class State implements Serializable {
  private static final long serialVersionUID = 7903724405884412505L;
  double x;
  double y;
  String stateName;

  boolean finalState;
  boolean currentState;
  boolean startState;

  boolean highlight = false;

  public State( double x, double y, String name, boolean f ) {
    this.x = x;
    this.y = y;
    finalState = f;
    currentState = false;
    startState = false;
    stateName = name;
  }
}

