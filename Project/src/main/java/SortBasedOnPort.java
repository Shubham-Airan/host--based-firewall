import java.util.Comparator;

class SortBasedOnPort implements Comparator<Rules> {
    @Override
    public int compare(Rules rule1, Rules rule2) {
        if (rule1.getStartPort() > rule2.getStartPort())
            return 1;
        else if (rule1.getStartPort() < rule2.getStartPort())
            return -1;
        else
            return 0;
    }
}