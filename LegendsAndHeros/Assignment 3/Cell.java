import java.util.*;
public class Cell { 
  private Token token;  
  private Token activeDesign;
  private int rowID; 
  private int colID;    
  private boolean isActive;
  public static Scanner in = new Scanner(System.in);   //player input scanner
  
  public Cell(int rowID, int colID) {
    this.rowID= rowID;
    this.colID = colID;
    this.token = null;
    isActive = false;
    activeDesign = null;
  }
  
  public Cell(int rowID, int colID, Token token) {
    this.rowID= rowID;
    this.colID = colID;
    this.token = token;
    isActive = false;
    activeDesign = null;
  }
  
  public Cell(int rowID, int colID, Token token, Token activeDesign) {
    this.rowID= rowID;
    this.colID = colID;
    this.token = token;
    isActive = false;
    this.activeDesign = activeDesign;
  }
  
  
  public boolean isActive(){
    return isActive; 
  }
  
  public void setActive(boolean a){
    isActive = a; 
  }
  
  
  public Token getToken(){
    return token; 
  }
  
  public void setToken(Token i){
    token = i; 
  }
  
  public int getRowID(){
    return rowID;
  }
  
  public void setRowID(int i){
    rowID = i; 
  }
  
  public int getColID(){
    return colID; 
  }
  
  public void setColID(int i){
    colID = i; 
  }
  
  public void printRegToken() {
    token.printDesign(); 
  }
  
  public void printActiveToken(){
    activeDesign.printDesign(); 
  }
}