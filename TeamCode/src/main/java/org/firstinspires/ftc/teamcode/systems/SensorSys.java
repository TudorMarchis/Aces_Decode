package org.firstinspires.ftc.teamcode.systems;

import static org.firstinspires.ftc.teamcode.utils.Constants.minDetect;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SensorSys {
    public ColorSensor sensor;

    public SensorSys(HardwareMap hardwareMap) {
        sensor = hardwareMap.get(ColorSensor.class, "senzor");
    }

    public ColorSensorData getSensorData(){
        int red = sensor.red();
        int green = sensor.green();
        int blue = sensor.blue();

        if(green < minDetect){return ColorSensorData.Nan;}

        if(red > green && blue > green){
            return ColorSensorData.Purple;
        } else if(green > red && green > blue){
            return ColorSensorData.Green;
        } else { return ((blue+red)/2>green? ColorSensorData.Purple : ColorSensorData.Green); }
    }
}
