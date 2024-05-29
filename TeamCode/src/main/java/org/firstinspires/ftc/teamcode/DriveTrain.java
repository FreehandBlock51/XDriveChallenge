package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class DriveTrain {
    public static final String FRONT_LEFT_MOTOR_NAME = "Front Left Wheel",
                               FRONT_RIGHT_MOTOR_NAME = "Front Right Wheel",
                               BACK_LEFT_MOTOR_NAME = "Back Left Wheel",
                               BACK_RIGHT_MOTOR_NAME = "Back Right Wheel";

    protected final DcMotor frontLeftMotor,
                            frontRightMotor,
                            backLeftMotor,
                            backRightMotor;

    public DriveTrain(DcMotor frontLeftMotor,
                      DcMotor frontRightMotor,
                      DcMotor backLeftMotor,
                      DcMotor backRightMotor) {
        this.frontLeftMotor = frontLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backLeftMotor = backLeftMotor;
        this.backRightMotor = backRightMotor;
    }
    public DriveTrain(HardwareMap map) {
        this(
                map.get(DcMotor.class, FRONT_LEFT_MOTOR_NAME),
                map.get(DcMotor.class, FRONT_RIGHT_MOTOR_NAME),
                map.get(DcMotor.class, BACK_LEFT_MOTOR_NAME),
                map.get(DcMotor.class, BACK_RIGHT_MOTOR_NAME)
        );
    }

    public abstract void setDrivePower(
            double horizontalPower,
            double verticalPower,
            double rotationPower
    );
}
