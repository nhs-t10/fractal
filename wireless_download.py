#Script by Tyler Osborne
#Runs in python 2 only!
import os

print '''\n\n\nPrerequisites for Wireless Download:
1. Phone and Computer downloading code to phone MUST be on the same network
2. A USB cable will be required to initialize the wireless connection between the computer and phone
3. The local IP address of the phone must be known (Settings->Wi-Fi->Tap on Network phone is connected to->Write down IP address)
4. If the phone or computer ever lose connection to the network, then all connections will be lost
--
Please plug the phone into the computer, press enter when done
'''
raw_input()
print "Killing any active ADB servers and restarting in USB mode..."
os.system("adb kill-server");os.system("adb usb")
raw_input("Please verify that your device is connected, press enter to continue")
ip = raw_input("Please enter the IP address of the phone to connect to:")
os.system("adb tcpip 5556")
connect_cmd = "adb connect " + ip + ":5556"
os.system(connect_cmd)
raw_input("Now unplug the phone and press enter to continue")
os.system(connect_cmd)
os.system("adb devices")
print "\nIf you see your phone and its IP address, you are set! If not, try running the script again and check to make sure that the IP address is correct"