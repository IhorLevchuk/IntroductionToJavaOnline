package unit04.simple_classes_and_objects.task04;

import java.util.Comparator;

public class DestinationNameComparator implements Comparator<Train> {
    @Override
    public int compare(Train o1, Train o2) {
        int ret = (o1.getDestinationName().compareTo(o2.getDestinationName()));
        if(ret == 0){
            if(o1.getTimeOfDeparture().isBefore(o2.getTimeOfDeparture())){
                return -1;
            } return 1;
        } return ret;
    }
}
