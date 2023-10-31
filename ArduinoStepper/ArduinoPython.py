from flask import Flask, request
import serial
import time

app = Flask(__name__)

# Open serial port
ser = serial.Serial('/dev/tty.usbmodem1201', 115200)
time.sleep(2)  # Give some time for the connection to establish

# example url: http://localhost:8888/arduino?s1=300&s2=500

@app.route('/arduino', methods=['GET'])
def arduino_command():
    s1 = request.args.get('s1', default=0, type=int)
    s2 = request.args.get('s2', default=0, type=int)

    message = f"S1 {s1} S2 {s2}\n"
    ser.write(message.encode())

    response = ser.readline().decode().strip()

    return f"Sent: {message}. Received: {response}"

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8888)
