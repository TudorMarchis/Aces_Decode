package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.systems.ColorSensorData;
import org.firstinspires.ftc.teamcode.systems.SensorSys;

@TeleOp(name = "Test_senzor", group = "teleops")
public class Test_senzor extends LinearOpMode {

   public SensorSys sensor;

    @Override
    public void runOpMode(){
        sensor = new SensorSys(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
            ColorSensorData data = sensor.getSensorData();
            if(data == ColorSensorData.Green){
                telemetry.addData("Color", "Green");
            } else if(data == ColorSensorData.Purple){
                telemetry.addData("Color", "Purple");
            } else {
                telemetry.addData("Color", "Nan");
            }
            telemetry.update();
        }
    }
}
