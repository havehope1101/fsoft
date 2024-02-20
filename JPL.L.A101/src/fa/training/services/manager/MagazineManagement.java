package fa.training.services.manager;

import fa.training.entities.Magazine;
import fa.training.services.iServices.PublicationManagement;

import java.util.List;

public class MagazineManagement implements PublicationManagement<Magazine> {
    private List<Magazine> magazineList = null;

    public MagazineManagement() {};

    @Override
    public void add(Magazine magazine) {
        this.magazineList.add(magazine);
    }

    @Override
    public int findIndexById(String id) {
        return 0;
    }

    @Override
    public List<Magazine> getAll() {
        return null;
    }

    @Override
    public List<Magazine> findByName(String name) {
        return null;
    }


}
