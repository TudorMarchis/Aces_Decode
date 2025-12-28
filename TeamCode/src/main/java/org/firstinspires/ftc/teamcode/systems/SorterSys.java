package org.firstinspires.ftc.teamcode.systems;

import static org.firstinspires.ftc.teamcode.utils.Constants.sorterpos0;
import static org.firstinspires.ftc.teamcode.utils.Constants.sorterpos1;
import static org.firstinspires.ftc.teamcode.utils.Constants.sorterpos2;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.utils.Constants.*;

public class  SorterSys {
    public boolean canIntake = true;
    public ColorSensorData[] mem = {ColorSensorData.Nan, ColorSensorData.Nan, ColorSensorData.Nan};
    public int curstep=0;
    Servo sorterStep;
    public SorterSys(HardwareMap hardwareMap){
        sorterStep = hardwareMap.get(Servo.class, "sorter");
        turnToStep(curstep);
    }

    public void depositArtifact(ColorSensorData color){
        if(curstep==-1){return;}
        mem[curstep]=color;
        curstep = findEmpty();
        if(curstep!=-1){turnToStep(curstep);}
    }
    boolean isCurStepNan(){return mem[curstep]==ColorSensorData.Nan;}
    int findEmpty(){
        for(int i=0;i<=2;i++){
            if(mem[i]==ColorSensorData.Nan){return i;}
        }

        return -1;
    }

    void turnToStep(int wantedStep){
//        curstep = wantedStep;
        switch (wantedStep){
            case 0:
                sorterStep.setPosition(sorterpos0);
                break;
            case 1:
                sorterStep.setPosition(sorterpos1);
                break;
            case 2:
                sorterStep.setPosition(sorterpos2);
                break;


        }
    }

    public void loadType(ColorSensorData color){
        for(int i=0;i<=2;i++){
            if(mem[i]==color){
                turnToStep(i);
                break;
            }
        }
    }



}
