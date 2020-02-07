import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Firewall {

    private int startIndex, endIndex;
    private ArrayList<Rules> firewallRules = new ArrayList<>();

    public Firewall(String rulesFilePath) {

        BufferedReader bufferedReader;
        String individualRule;

        try {
            bufferedReader = new BufferedReader(new FileReader(rulesFilePath));
            while ((individualRule = bufferedReader.readLine()) != null) {
                firewallRules.add(new Rules(individualRule));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        firewallRules.sort(new SortBasedOnPort());
    }

    boolean accept_packet(String direction, String protocol, int port, String IPAddress) {

        startIndex = 0;
        endIndex = firewallRules.size();

        findIndexRange(port);

        for (int i = startIndex; i < endIndex; i++) {
            Rules rule = firewallRules.get(i);
            if (direction.equals(rule.getDirection()) && protocol.equals(rule.getProtocol()) && (port >= rule.getStartPort() && port <= rule.getEndPort()) && rule.isInRange(IPAddress))
                return true;
        }
        return false;
    }

    private void findIndexRange(int port) {
        int mid;
        while (true) {
            mid = (startIndex + endIndex) / 2;
            if (firewallRules.get(mid).getStartPort() > port && mid > 0) {
                endIndex = mid;
                continue;
            }
            break;
        }
    }
}