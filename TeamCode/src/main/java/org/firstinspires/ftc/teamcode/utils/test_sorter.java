package org.firstinspires.ftc.teamcode.utils;


import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.systems.ColorSensorData;
import org.firstinspires.ftc.teamcode.systems.SorterSys;

@Configurable
@TeleOp(name = "test_sorter", group = "teleop")
public class test_sorter extends LinearOpMode {
    public static SorterSys sorter;
    @Override
    public void runOpMode() throws InterruptedException {
        sorter = new SorterSys(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
            if(gamepad1.a){sorter.depositArtifact(ColorSensorData.Green);};
                telemetry.addData("Color0", sorter.mem[0]);
                telemetry.addData("Color1", sorter.mem[1]);
                telemetry.addData("Color2", sorter.mem[2]);
                telemetry.update();

        }

    }
}
