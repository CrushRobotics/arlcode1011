package frc.robot.subsystems;


import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
// import com.revrobotics.spark.SparkClosedLoopController;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

public class CANAlgaeIntakeSubsystem extends SubsystemBase {
    private final SparkMax algaeIntakeMotor;
    private final SparkMaxConfig config;
    private final RelativeEncoder encoder;
    // private final SparkClosedLoopController pidAlgaeIntakeMotor;

    public CANAlgaeIntakeSubsystem() {
        algaeIntakeMotor = new SparkMax(11, MotorType.kBrushless); // placeholder ID

        // pidAlgaeIntakeMotor = algaeIntakeMotor.getClosedLoopController();

        //pidAlgaeIntakeMotor.setReference(0, null);
        
        config = new SparkMaxConfig();

        config.idleMode(IdleMode.kBrake);
        algaeIntakeMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        encoder = algaeIntakeMotor.getEncoder();
       
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Position", encoder.getPosition());
    }

    public void right() {
        algaeIntakeMotor.set(0.6);
    }
    public void moveToShootPosition(){
        //setTarget(frc.robot.Constants.ArmConstants.SHOOTING_POSITION);
    }

    public void left() {
        algaeIntakeMotor.set(-0.6);
    }
    public void stop(){
        algaeIntakeMotor.setVoltage(0);
    }
}

