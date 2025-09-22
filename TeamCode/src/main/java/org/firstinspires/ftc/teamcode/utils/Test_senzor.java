package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name = "Test_senzor", group = "teleops")
public class Test_senzor extends LinearOpMode {

   public ColorSensor senzor;

    @Override
    public void runOpMode(){
        senzor = hardwareMap.get(ColorSensor.class, "senzor");

        waitForStart();

        while(opModeIsActive()){
            int red = senzor.red();
            int green = senzor.green();
            int blue = senzor.blue();

            telemetry.addData("Roșu", red);
            telemetry.addData("Verde", green);
            telemetry.addData("Albastru", blue);

            if(red > green&&red > blue ){
                telemetry.addData("Culoarea detectata:", "Roșu");
            }else if(green > red&&green > blue){
                telemetry.addData("Culoarea detectata:", "Verde;");
            }else if(blue > green&&blue > red){
                telemetry.addData("Culoarea detectata:", "Albastru");
            }else if(red > 100 && blue > 100 && green < 80){
                telemetry.addData("Culoarea detectata:", "Mov");

            }else {
                telemetry.addData("Culoare detectata", "necunoscuta");
            }
            telemetry.update();
        }
    }
}
