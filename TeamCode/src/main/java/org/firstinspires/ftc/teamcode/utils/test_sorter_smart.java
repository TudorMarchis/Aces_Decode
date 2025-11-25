package org.firstinspires.ftc.teamcode.utils;


import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.systems.ColorSensorData;
import org.firstinspires.ftc.teamcode.systems.SensorSys;
import org.firstinspires.ftc.teamcode.systems.SorterSys;

@Configurable
@TeleOp(name = "test_sorter_full", group = "teleop")
public class test_sorter_smart extends LinearOpMode {
    public SorterSys sorter;
    public SensorSys sensor;
    @Override
    public void runOpMode() throws InterruptedException {
        sorter = new SorterSys(hardwareMap);
        sensor = new SensorSys(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
            ColorSensorData sensorOutput = sensor.getSensorData();
            if(sensorOutput != ColorSensorData.Nan && sorter.canIntake){
                sleep(300);
                sorter.depositArtifact(sensorOutput);
                sleep(650);
            };
            telemetry.addData("Color0", sorter.mem[0]);
            telemetry.addData("Color1", sorter.mem[1]);
            telemetry.addData("Color2", sorter.mem[2]);
            telemetry.update();

            if(gamepad1.cross){
                sorter.canIntake = false;
                sorter.loadType(ColorSensorData.Green);
                sleep(350);
            }else if(gamepad1.circle){
                sorter.canIntake = false;
                sorter.loadType(ColorSensorData.Purple);
                sleep(350);
            }

            sorter.canIntake = true;


        }

    }
}
