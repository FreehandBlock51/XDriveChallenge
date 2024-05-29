package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class XDriveTrain extends DriveTrain {
    private static final double FRONT_LEFT_MOTOR_ROTATION = Math.PI * 3 / 4,
                                FRONT_RIGHT_MOTOR_ROTATION = Math.PI / 4,
                                BACK_LEFT_MOTOR_ROTATION = Math.PI * 5 / 4,
                                BACK_RIGHT_MOTOR_ROTATION = Math.PI * 7 / 4;

    public XDriveTrain(HardwareMap map) {
        super(map);
    }

    private static void setDirectionalPower(
            DcMotor motor,
            double motorRotationRadians,
            double power,
            double powerDirectionRadians,
            double rotationalPower
    ) {
        final double actualPower = power * Math.cos(powerDirectionRadians - motorRotationRadians);
        motor.setPower((actualPower + rotationalPower) / 2);
    }

    public void setMovementVectorAndRotate(double movePower, double moveDirectionRadians, double rotationPower) {
        setDirectionalPower(frontLeftMotor, FRONT_LEFT_MOTOR_ROTATION, movePower, moveDirectionRadians, rotationPower);
        setDirectionalPower(frontRightMotor, FRONT_RIGHT_MOTOR_ROTATION, movePower, moveDirectionRadians, rotationPower);
        setDirectionalPower(backLeftMotor, BACK_LEFT_MOTOR_ROTATION, movePower, moveDirectionRadians, rotationPower);
        setDirectionalPower(backRightMotor, BACK_RIGHT_MOTOR_ROTATION, movePower, moveDirectionRadians, rotationPower);
    }

    @Override
    public void setDrivePower(double horizontalPower, double verticalPower, double rotationPower) {
        final double moveDirection = Math.atan2(horizontalPower, verticalPower);
        final double movePower = Math.sqrt(horizontalPower * horizontalPower + verticalPower * verticalPower);
        setMovementVectorAndRotate(movePower, moveDirection, rotationPower);
    }
}
