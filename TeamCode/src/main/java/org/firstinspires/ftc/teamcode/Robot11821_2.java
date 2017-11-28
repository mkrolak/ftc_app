package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;


public class Robot11821_2 {
    //Easy access to the directions
    //BACKRIGHT BACKLEFT FRONTRIGHT FRONTLEFT
    public static final double[] LEFT = {-1,-1,1,1};
    public static final double[] RIGHT = {1,1,-1,-1};
    public static final double[] UP = {1,-1,1,-1};
    public static final double[] DOWN = {-1,1,-1,1};
    
    public static final double[] CLOCKWISE= {-1,-1,-1,-1};
    public static final double[] COUNTERCLOCKWISE = {1,1,1,1};
    
    public static final double[] IN = {-1,1};
    public static final double[] OUT = {1,-1};
    
    public static final double[] OFF = {0,0,0,0};
    
    private double[] current;
    
    private double modifier;
    //motor

    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    
    private DcMotor intakeRight;
    private DcMotor intakeLeft;
    
    private Servo jewel;
    private ColorSensor cSensor;
    private ColorSensor fSensor;
    
    //Declarations of motors
    public Robot11821_2(DcMotor bL, DcMotor bR, DcMotor fL, DcMotor fR, DcMotor iR, DcMotor iL, Servo s, ColorSensor cS , ColorSensor fS){

        backRight = bR;
        backLeft = bL;
        frontRight = fR;
        frontLeft = fL;
        
        intakeRight = iR;
        intakeLeft = iL;
        
        jewel = s;
        cSensor = cS;
        fSensor = fS;
    
        current = this.OFF;
    }
    //set a direction with one direction
    public void setDirection(double[] dir){
        if(dir.length == 4)current = dir;
    }
    //set a direction with two direction
    public void setDiagonal(double [] dir1, double[] dir2){
        if(dir1.length == 4 && dir2.length == 4){
            for(int i = 0; i < 4; i++){
                current[i] = (dir1[i] + dir2[i]==0)?0:1%(dir1[i]+dir2[i]);
            }
        }
    }
    
    
    //Use with Encoders
    public void runTo(double rotations){
        backRight.setTargetPosition(backRight.getCurrentPosition()+(int)(360*rotations*current[0]));
        backLeft.setTargetPosition(backLeft.getCurrentPosition()+(int)(360*rotations*current[1]));
        frontRight.setTargetPosition(frontRight.getCurrentPosition()+(int)(360*rotations*current[2]));
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition()+(int)(360*rotations*current[3]));

    }
    //Sets power to wheels
    public void start(){
        backRight.setPower(current[0]*modifier);
        backLeft.setPower(current[1]*modifier);
        frontRight.setPower(current[2]*modifier);
        frontLeft.setPower(current[3]*modifier);
    }
    //Takes an double and uses for set power to wheels
    public void start(double m){
        modifier = m;
        start();
        
    }
    
    public void navagation(double x,double y){
        if(null == direction(x,y)){
            setDiagonal(direction(x,0),direction(0,y));
        }
        else{
            setDirection(direction(x,y));
        }
        if(Math.abs(x) > Math.abs(y)){
            start(Math.abs(x));
        } else{
            start(Math.abs(y));
        }
    }
    
    private double [] direction(double x, double y){
        if(x == 0){
            if(y < 0){
                return UP;
            }else{
                return DOWN;
            }
        }
        else if(y == 0){
            if(x < 0){
                return RIGHT;
            }else{
                return LEFT;
            }
        }
        return null;
    }
    
    public boolean isBusy(){
        return (frontRight.isBusy() || frontLeft.isBusy() || backRight.isBusy() || backLeft.isBusy());
    }
    
    //power for wheels for later
    public void setModifier(double i){
        modifier = i;
    }
    
    //sets intake
    public void intake(double[] a){
        intakeLeft.setPower(a[0]);
        intakeRight.setPower(a[1]);
    }
    
    public void setServo(Double pos){
        jewel.setPosition(pos);
    }
    
    public int[] getColor(){
        return new int[] {cSensor.red(),cSensor.green(),cSensor.blue()};
    }
    
    public int[] floorColor(){
        return new int[] {fSensor.red(),fSensor.green(),fSensor.blue()};
        
    }
    
}