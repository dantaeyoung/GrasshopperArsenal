#include <AccelStepper.h>
 
AccelStepper stepper1(AccelStepper::FULL2WIRE, 2, 5);
AccelStepper stepper2(AccelStepper::FULL2WIRE, 3, 6);
 

// how much serial data we expect before a newline
const unsigned int MAX_INPUT = 50;


void setup() {
  Serial.begin (115200);

  // Configure each stepper
  stepper1.setMaxSpeed(10000);
  stepper2.setMaxSpeed(10000);
  stepper1.setSpeed(1000);
  stepper2.setSpeed(1000);
  stepper1.setAcceleration(1000);
  stepper2.setAcceleration(1000);

  stepper1.moveTo(0);
  stepper2.moveTo(0);


}



// here to process incoming serial data after a terminator received
void process_data (const char * data)
 {
    int s1, s2;
    if (sscanf(data, "S1 %d S2 %d", &s1, &s2) == 2) {
      // Successfully parsed
      s1 = static_cast<float>(s1);
      s2 = static_cast<float>(s2);
      stepper1.moveTo(s1);
      stepper2.moveTo(s2);
      Serial.print("moving to S1 ");
      Serial.print(s1);
      Serial.print(" S2 ");
      Serial.println(s2);
    } else {
      Serial.println("format should be 'S1 100 S2 300'");
    }
 
 }  // end of process_data


 

void processIncomingByte (const byte inByte)
{
  static char input_line [MAX_INPUT];
  static unsigned int input_pos = 0;

switch (inByte)
  {

  case '\n':   // end of text
    input_line [input_pos] = 0;  // terminating null byte

    // terminator reached! process input_line here ...
    process_data (input_line);

    // reset buffer for next time
    input_pos = 0;  
    break;

  case '\r':   // discard carriage return
    break;

  default:
    // keep adding if not full ... allow for terminating null byte
    if (input_pos < (MAX_INPUT - 1))
      input_line [input_pos++] = inByte;
    break;

  }  // end of switch

} // end of processIncomingByte  







 
void loop() {

  // if serial data available, process it
  while (Serial.available () > 0)
    processIncomingByte (Serial.read ());
  stepper1.run();
  stepper2.run();
  



}
