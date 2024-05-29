package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DriveTeleop extends OpMode {
    private DriveTrain driveTrain;

    @Override
    public void init() {
        driveTrain = new XDriveTrain(hardwareMap);
    }

    @Override
    public void loop() {
        driveTrain.setDrivePower(
                gamepad1.left_stick_x,
                gamepad1.left_stick_y,
                gamepad1.right_stick_x
        );
    }
}
