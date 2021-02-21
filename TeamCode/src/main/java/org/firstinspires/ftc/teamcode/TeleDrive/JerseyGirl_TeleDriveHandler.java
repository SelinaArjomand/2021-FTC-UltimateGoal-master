package org.firstinspires.ftc.teamcode.TeleDrive; //set your package

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.teamcode.TeleDrive.TeleDrive;

import java.net.CookieHandler;

@TeleOp(name = "JerseyGirl_TeleDriveHandler", group = "TeleOpMode")
@Disabled
public class JerseyGirl_TeleDriveHandler extends TeleDrive {


    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    public DcMotor leftFront   = null;
    public DcMotor rightFront   = null;
    public DcMotor leftBack   = null;
    public DcMotor rightBack   = null;
    BNO055IMU imu;
    HardwareMap hwMap = null;

    // private HardwareMap ahwMap;

    @Override
    public void init() {
        super.init();
        //Init code here
        /* local OpMode members. */
        //HardwareMap hwMap           =  null;


        // Define and Initialize Motors
        /*
            CHAWKS: The deviceName should ALWAYS ALWAYS ALWAYS
                    match the part name to avoid confusion

*/

        leftFront  = hardwareMap.dcMotor.get("leftFront");
        rightFront  = hardwareMap.dcMotor.get("rightFront");

        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");


        // Set Direction/Motion for Motors
        /*
            CHAWKS: Why are we reversing the Right Wheels?

*/
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = false;
        //get and initialize IMU
        imu = hwMap.get(BNO055IMU.class, "imu");

        imu.initialize(parameters);

    }

    public void init_loop() {
        super.init_loop();
        //Init Loop code here
    }

    @Override
    public void start() {
        super.start();
        //Start code here
        runtime.reset();
    }

    @Override
    public void loop() {
        super.loop();
        //Loop code here
        handleGamepad1(gamepad1);
        handleGamepad2(gamepad2);
    }

    @Override
    public void stop() {
        super.stop();
        //Stop code here
    }

    public void handleGamepad1(Gamepad gamepad) {

    }

    public void handleGamepad2(Gamepad gamepad) {

    }
}