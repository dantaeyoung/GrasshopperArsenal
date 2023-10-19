import ghhops_server as hs
import rhino3dm
import serial
import time

hops = hs.Hops()

ser = None

def open_serial(port, baud, message):
    ser = serial.Serial(port, baud, timeout=1)
    try: 
        ser.open()
    except e:
        yield 'event:error\n' + 'data:' + 'Serial port error({0}): {1}\n\n'.format(e.errno, e.strerror)

        

@hops.component(
    "/serialmessage",
    name="Serial",
    nickname="Serial",
    description="send Serial Message",
    icon="examples/pointat.png",
    inputs=[
        hs.HopsString("Port", "Port", "Port"),
        hs.HopsNumber("Baud", "Baud", "Baud"),
        hs.HopsString("Message", "Message", "Message to Send"),
    ],
    outputs=[
        hs.HopsString("Status", "Status", "Status"),
    ]
)
def serialmessage(port, baud, message):

    global ser
    
    print("hey")
    print("message!!!", message)

    if(message.startswith("0x")):
        print("yup it does 0x")
        message = '\\x' + message.removeprefix("0x")
    else:
        message += "\n"


    try: 
        ser.write(message.encode())
        return ser.readline().decode("utf-8").strip()
    except:
        print("Opening serial port")
        ser = serial.Serial('/dev/tty.usbmodem1301', 115200, timeout=1)
        ser.close()
        ser.open()
        time.sleep(2)
        #ser.write('$J=G20G91Y0.1F6\n'.encode())
        ser.write(message.encode())
        time.sleep(2)
        return ser.readline().decode("utf-8").strip()
        return "Connected + Sent"


    
if __name__ == "__main__":
    hops.start(debug=True)
