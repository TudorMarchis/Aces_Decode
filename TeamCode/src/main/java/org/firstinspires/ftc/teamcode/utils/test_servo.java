package org.firstinspires.ftc.teamcode.utils;


import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@Configurable
@TeleOp(name = "test_servo", group = "teleop")
public class test_servo extends LinearOpMode {
    public static double left=0,  right=1;
    public Servo servo1, servo2;
    @Override
    public void runOpMode() throws InterruptedException {
        servo1 = hardwareMap.get(Servo.class, "1");
        servo2 = hardwareMap.get(Servo.class, "2");
        waitForStart();

        while(opModeIsActive()){
            servo1.setPosition(left);
            servo2.setPosition(right);
        }

    }
}
