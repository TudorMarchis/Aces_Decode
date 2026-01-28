package org.firstinspires.ftc.teamcode.systems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.teamcode.utils.Constants.glisieraRepaus;
import static org.firstinspires.ftc.teamcode.utils.Constants.glisieraUpForce;
import static org.firstinspires.ftc.teamcode.utils.Constants.glisieradowntime;
import static org.firstinspires.ftc.teamcode.utils.Constants.glisierauptime;


import static java.lang.Thread.sleep;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Configurable
public class GlisiereSys {

    public DcMotorEx GlisieraDr, GlisieraSt;

    public GlisiereSys(HardwareMap hardwareMap){
        GlisieraDr = hardwareMap.get(DcMotorEx.class, "glisieraDr");
        GlisieraSt = hardwareMap.get(DcMotorEx.class, "glisieraSt");

    }


    public void GlisieraUp() throws InterruptedException{
        gamepad2.rumble(50);
        sleep(200);
        GlisieraDr.setPower(-glisieraUpForce);
        GlisieraSt.setPower(-glisieraUpForce);
        sleep(200);
        GlisieraDr.setPower(glisieraRepaus);
        GlisieraSt.setPower(glisieraRepaus);

    }

    public void GlisieraDown() throws  InterruptedException{
        gamepad2.rumble(50);
        sleep(200);
        GlisieraDr.setPower(glisieraUpForce+2*glisieraRepaus);
        GlisieraSt.setPower(glisieraUpForce+2*glisieraRepaus);
        sleep(glisieradowntime);
        GlisieraDr.setPower(glisieraRepaus);
        GlisieraSt.setPower(glisieraRepaus);
    }

}
