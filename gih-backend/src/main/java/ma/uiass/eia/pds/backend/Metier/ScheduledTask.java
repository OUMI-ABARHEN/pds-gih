package ma.uiass.eia.pds.backend.Metier;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask {
    private final MetierSejour metierSejour;

    public ScheduledTask(MetierSejour metierSejour) {
        this.metierSejour = metierSejour;
    }

    @Override
    public void run() {
        metierSejour.checkExpiredSejours();
    }
}
