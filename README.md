# xdrip2term
capturing xDrip broadcast and sending to BT terminal

Simple Python terminal forward to 7seg for example:

import serial
import time  # Optional (required if using time.sleep() below)

serBt = serial.Serial(port='COM6', baudrate=115200)
serDisp = serial.Serial(port='COM5', baudrate=57600)

while (True):
    if (serBt.inWaiting() > 0):
        input = serBt.inWaiting()
        data_str = serBt.read(input).decode('ascii')
        print(data_str, end='')
        b=[]
        b.extend(map(ord, data_str))
        serDisp.write(b)

    time.sleep(0.1)
