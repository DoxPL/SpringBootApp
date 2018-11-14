const int DETECTOR = 0;
const int ALERT = 200;

void setup() {
  pinMode(DETECTOR, INPUT);
  Serial.begin(9600);
}

void loop() {
  char c = 'g';
  if( Serial.available() )
  {
    c = Serial.read();
    if(c == 'g')
    {
      int sensorValue = analogRead(DETECTOR);
      Serial.println(sensorValue);
    }
  }
}
