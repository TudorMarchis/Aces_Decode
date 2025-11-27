package org.firstinspires.ftc.teamcode.utils;


import static org.firstinspires.ftc.teamcode.utils.Constants.slot1;
import static org.firstinspires.ftc.teamcode.utils.Constants.slot2;
import static org.firstinspires.ftc.teamcode.utils.Constants.slot3;
import static org.firstinspires.ftc.teamcode.utils.Constants.sorterinit;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.systems.ColorSensorData;
import org.firstinspires.ftc.teamcode.systems.SensorSys;

@Configurable
@TeleOp(name = "Rezerva1.0", group = "teleop")
public class Teleop_rezerva extends LinearOpMode {
    Servo sorter;
    public SensorSys sensor;



    public void Slotul1(){
        sorter.setPosition(slot1);
    }

    public void Slotul2(){
        sorter.setPosition(slot2);
    }

    public void Slotul3(){
        sorter.setPosition(slot3);
    }
    @Override
    public void runOpMode() throws InterruptedException {
         sorter = hardwareMap.get(Servo.class, "sorter");
         sensor = new SensorSys(hardwareMap);
         sorter.setPosition(sorterinit);


         waitForStart();
         while(opModeIsActive()){
             ColorSensorData detected = sensor.getSensorData();


             if(detected == ColorSensorData.Green){
                 telemetry.addLine("Bila curenta: verde");
             }else if(detected == ColorSensorData.Purple){
                 telemetry.addLine("Bila curenta: Mov");
             }else{
                 telemetry.addLine("Nicio bila");
             }

             if(gamepad1.triangle){
                 Slotul1();

             }

             if(gamepad1.circle){
                 Slotul2();
             }

             if(gamepad1.square){
                 Slotul3();
             }


             telemetry.update();


         }
    }
}
