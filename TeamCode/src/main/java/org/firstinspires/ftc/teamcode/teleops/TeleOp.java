package org.firstinspires.ftc.teamcode.teleops;

import static org.firstinspires.ftc.teamcode.utils.Constants.comeback;
import static org.firstinspires.ftc.teamcode.utils.Constants.counterforce;
import static org.firstinspires.ftc.teamcode.utils.Constants.decrease;
import static org.firstinspires.ftc.teamcode.utils.Constants.elicieinit;
import static org.firstinspires.ftc.teamcode.utils.Constants.increase;
import static org.firstinspires.ftc.teamcode.utils.Constants.launchSpeed;
import static org.firstinspires.ftc.teamcode.utils.Constants.launchTime;
import static org.firstinspires.ftc.teamcode.utils.Constants.slot1;
import static org.firstinspires.ftc.teamcode.utils.Constants.sniperSpeed;
import static org.firstinspires.ftc.teamcode.utils.Constants.stoppos;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.systems.ColorSensorData;
import org.firstinspires.ftc.teamcode.systems.Hardware;
import org.firstinspires.ftc.teamcode.systems.SensorSys;

@Configurable
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Rezerva2.0", group = "teleop")
public class TeleOp extends LinearOpMode {
    Hardware sys;
    Servo sorter;

    public SensorSys sensor;


    double elicie = elicieinit;


    public void eliciepozitiva(){
        elicie += increase;
        elicie = Math.min(elicie, 1);
        sorter.setPosition(elicie);

    }

    public void elicienegativa(){
        elicie -= decrease;
        elicie = Math.max(elicie,0);
        sorter.setPosition(elicie);

    }
    @Override
    public void runOpMode() throws InterruptedException {
      // sys = new Hardware(hardwareMap);
        sorter = hardwareMap.get(Servo.class, "sorter");
        sensor = new SensorSys(hardwareMap);
        sorter.setPosition(elicieinit);


        waitForStart();
        while (opModeIsActive()){
            ColorSensorData detected = sensor.getSensorData();


            if(detected == ColorSensorData.Green){
                telemetry.addLine("Bila curenta: verde");
            }else if(detected == ColorSensorData.Purple){
                telemetry.addLine("Bila curenta: Mov");
            }else{
                telemetry.addLine("Nicio bila");
            }

            // Movement
//            double px = - gamepad1.right_stick_x * sniperSpeed;
//            double py = - gamepad1.right_stick_y * sniperSpeed;
//            double pp = gamepad1.left_stick_x * sniperSpeed;
//            sys.leftMotorBack.setPower(py + pp + px);
//            sys.leftMotorFront.setPower(py + pp - px);
//            sys.rightMotorBack.setPower(py - pp - px);
//            sys.rightMotorFront.setPower(py - pp + px);

            if(gamepad1.right_bumper){
                eliciepozitiva();
                sleep(300);
            }

            if(gamepad1.left_bumper){
                elicienegativa();
                sleep(300);
            }
            if(gamepad1.cross){
                sorter.setPosition(elicieinit);
            }




       }
    }
}
