package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    public int x1;
    public int x2;
    public int y1;
    public int y2;
    //CONSTRUCTOR
    public LinearCalculator(String p1,String p2){ // <--add 2 string parameters to this constructor
    
    //removes the () from Strings
    String p1NP = p1.substring(1,p1.length()-1);
    String p2NP = p2.substring(1,p2.length()-1);
    //splits them into before and after the comma
    x1 = Integer.parseInt(p1NP.substring(0,p1NP.indexOf(",")));
    y1 = Integer.parseInt(p1NP.substring((p1NP.indexOf(",")+1),p1NP.length()));
    x2 = Integer.parseInt(p2NP.substring(0,p2NP.indexOf(",")));
    y2 = Integer.parseInt(p2NP.substring((p2NP.indexOf(",")+1),p2NP.length()));
    }
  
    //getter methods
    public int getX1(){
       return x1;           
    }                        
    public int getY1(){
        return y1;           
    }                        
    public int getX2(){    
        return x2;           
    }                  
    public int getY2(){
        return y2;
    }

    //Setter methods
    public void setX1(int NewX1){
        this.x1 = NewX1;
    }
    public void setY1(int NewY1){
        this.y1 = NewY1;
    }
    public void setX2(int NewX2){
        this.x2 = NewX2;
    }
    public void setY2(int NewY2){
        this.y2 = NewY2;
    }



    //gives you the distance between the 2 points
    public double distance(){
        double  distance = (Math.sqrt(Math.pow(x2-x1,2)+(Math.pow(y2-y1,2))));
        distance = roundedToHundredth(distance);
        return distance;
    }
    //gives you the yintercept between the 2 points and returns -999.99 if undefined
    public double yInt(){
        if (slope()==-999.99) {
            return -999.99;
        } else {
        double yIntercept = (y1-(x1*slope()));
        yIntercept = roundedToHundredth(yIntercept);
        return yIntercept;
    }
}
    //this calculates the slope of the 2 points and returns -999.99 if its undefined
    public double slope(){
        if (x2-x1==0) {
            return -999.99;
        } else {
        double slope = (double)(y2-y1)/(x2-x1);
        slope = roundedToHundredth(slope);
        return slope;
        }
    }

    //gives you the equation of the line in standard form 
    public String equation(){
        if (slope() == -999.99) {
            return "undefined";
        } else { 
        if (yInt()==0) {
            return "y="+ slope() + "x";
        }
        if (slope()==0) {
            return "y="+yInt();
        }
        if (yInt()>0) {
            return "y="+ slope() + "x" + "+" +yInt(); 
        }
        return "y="+ slope() + "x" + yInt();
        }
    }


    //a function that rounds the number to the nearest hundred
    public double roundedToHundredth(double x){
        x = Math.round(x*100)/100.0;
        return x;
    }
   

    public String Midpoint() {
        double averageOfX = (x1 + x2) / 2.0;
        double averageOfY = (y1 + y2) / 2.0;
        return "The midpoint of this line is: (" + averageOfX + "," + averageOfY + ")";
    }
   


    public String findSymmetry() {
        if (x1 == -x2 && y1 == -y2) {
            return "Symmetric about the origin";
        } else if (x1 == -x2) {
            return "Symmetric about the y-axis";
        } else if (y1 == -y2) {
            return "Symmetric about the x-axis";
        }
        return "No symmetry";
    }
   
   


    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are
    //not working.
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
 
        return str;
    }
}



