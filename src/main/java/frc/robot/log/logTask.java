package frc.robot.log;
import frc.robot.OI;

import java.util.TimerTask;

import edu.wpi.first.wpilibj.command.Command;

public class logTask extends TimerTask {
    Command m_log;
    @Override
    public void run() {
        m_log.start();
    }

}