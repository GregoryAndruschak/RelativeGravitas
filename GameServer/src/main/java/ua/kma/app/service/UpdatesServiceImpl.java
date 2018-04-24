package ua.kma.app.service;

import org.springframework.stereotype.Service;
import ua.kma.app.entities.Updates;
import ua.kma.app.repository.UpdatesRepository;

import java.sql.Date;

@Service
public class UpdatesServiceImpl {
    private final UpdatesRepository updatesRepository;

    public UpdatesServiceImpl(UpdatesRepository updatesRepository) {
        this.updatesRepository = updatesRepository;
    }

    private void setUpdatesNow() {
        updatesRepository.save(new Updates());
    }

    public Date getLastWeekUpdate() {
        Updates u = updatesRepository.getOne(1L);
        if (u == null) {
            setUpdatesNow();
            return getLastWeekUpdate();
        } else
            return u.getLastWeekUpdate();
    }

    public void setLastWeekUpdateNow() {
        Updates curr = updatesRepository.getOne(1L);
        if (curr == null)
            setUpdatesNow();
        else {
            curr.setLastWeekUpdate(new Date(System.currentTimeMillis()));
            updatesRepository.saveAndFlush(curr);
        }
    }

    public Date getLastMonthUpdate() {
        Updates u = updatesRepository.getOne(1L);
        if (u == null) {
            setUpdatesNow();
            return getLastMonthUpdate();
        } else
            return u.getLastMonthUpdate();
    }

    public void setLastMonthUpdateNow() {
        Updates curr = updatesRepository.getOne(1L);
        if (curr == null)
            setUpdatesNow();
        else {
            curr.setLastMonthUpdate(new Date(System.currentTimeMillis()));
            updatesRepository.saveAndFlush(curr);
        }
    }
}
