import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import oscP5.*; 
import netP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class grasshopper_ghowl_to_wekinator extends PApplet {

/**
 * oscP5sendreceive by andreas schlegel
 * example shows how to send and receive osc messages.
 * oscP5 website at http://www.sojamo.de/oscP5
 */
 


  
PFont f;
OscP5 oscP5;
NetAddress myRemoteLocation;

int PORT_INCOMING = 6447;
int PORT_OUTGOING = 6448;

boolean recentMessage = false;

public void setup() {
  
  frameRate(25);


  f = createFont("Arial", 24);
  textFont(f);
  
  /* start oscP5, listening for incoming messages at port 12000 */
  oscP5 = new OscP5(this, PORT_INCOMING);
  
  /* myRemoteLocation is a NetAddress. a NetAddress takes 2 parameters,
   * an ip address and a port number. myRemoteLocation is used as parameter in
   * oscP5.send() when sending osc packets to another computer, device, 
   * application. usage see below. for testing purposes the listening port
   * and the port of the remote location address are the same, hence you will
   * send messages back to this sketch.
   */
  myRemoteLocation = new NetAddress("127.0.0.1", PORT_OUTGOING);
}


public void draw() {
  background(0);
  
  fill(255);
   
  textAlign(LEFT);

  text("---> 1. Listening from Grasshopper on port " + PORT_INCOMING, 185, 55);
  text("      2. Converting messages to Wekinator-friendly format", 185, 85);
  text("<--- 3. Sending to Wekinator on port " + PORT_OUTGOING, 185, 115);
  
  textAlign(CENTER);
    
  if(recentMessage == true) {
    text("sending", 80, 65);
    fill(5, 405, 30);
    recentMessage = false;
  } else {
    text("idle", 80, 65);
    fill(255);
  }
  
  ellipse(80, 100, 45, 45);
}

/*
void mousePressed() {
  // in the following different ways of creating osc messages are shown by example 
  OscMessage myMessage = new OscMessage("/test");
 
  myMessage.add(123); // add an int to the osc message 

  // send the message 
  oscP5.send(myMessage, myRemoteLocation); 
}
*/

public OscMessage messageStringToFloat(OscMessage oscmsg) {
  
  OscMessage newmsg = new OscMessage(oscmsg.addrPattern());
  
  String msgtypes = oscmsg.typetag();
  for (int i = 0; i < msgtypes.length(); i++) {
    float f = PApplet.parseFloat(oscmsg.get(i).stringValue());
    newmsg.add(f);
  }

  return newmsg;
}

/* incoming osc message are forwarded to the oscEvent method. */
public void oscEvent(OscMessage theOscMessage) {
  /* print the address pattern and the typetag of the received OscMessage */
  
  
  print("### received an osc message.");
  oscP5.send(messageStringToFloat(theOscMessage), myRemoteLocation);
  println("sending again:");
  
  recentMessage = true;
  
  
  
  
}
  public void settings() {  size(850,150); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "grasshopper_ghowl_to_wekinator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
