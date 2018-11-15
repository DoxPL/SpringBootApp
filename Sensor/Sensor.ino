const int DETECTOR = 0;
const int ALERT = 200;
const int REQUEST_CHAR = 'G';
const int CONN_SPEED = 9600;
const int LED = 13;
bool status = false;

void setup() {
  pinMode(DETECTOR, INPUT);
  pinMode(LED, OUTPUT);
  Serial.begin(CONN_SPEED);
}

void loop() {
  char c;
  if( Serial.available() )
  {
    c = Serial.read();
    if( c == REQUEST_CHAR )
    {
      int sensorValue = analogRead(DETECTOR);
      Serial.write(sensorValue);
      if(!status)
      {
        digitalWrite(LED, HIGH);
        status = true;
      }
      else
      {
        digitalWrite(LED, LOW);
        status = false;
      }
    }
  }
}
