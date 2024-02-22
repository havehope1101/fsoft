package fa.training.services.manager;

import fa.training.entities.Magazine;
import fa.training.services.iServices.PublicationManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MagazineManagement implements PublicationManagement<Magazine> {
    private List<Magazine> magazineList = new ArrayList<>();

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

    public void displayData(List<Magazine> magazineList, String publisher, int publicationYear){
        List<Magazine> searchMagazineList = new ArrayList<>();
        for (Magazine magazine : magazineList) {
            if(publisher.equals(magazine.getPublisher()) && publicationYear == magazine.getPublicationYear()){
                searchMagazineList.add(magazine);
            }
        }
        for (Magazine magazine : searchMagazineList) {
            magazine.display();
        }
    }

    public void displayTop10(List<Magazine> magazineList){
        Collections.sort(magazineList, new Comparator<Magazine>() {
            @Override
            public int compare(Magazine o1, Magazine o2) {
                return o2.getVolume()-o1.getVolume();
            }
        });
        int d = 1;
        for (Magazine magazine : magazineList) {
            magazine.display();
            d++;
            if (d == 11) {
                break;
            }
        }
    }
}
