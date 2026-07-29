import java.io.*;
import java.util.*;

public class RealTimePacketAnalyzer {

    private static final String CAPTURE_COMMAND_TEMPLATE =
        "tshark -i %s -c %d -T fields -e frame.number -e ip.src -e ip.dst -e _ws.col.Protocol -e frame.len";

    private static List<String[]> packetData = new ArrayList<>();

    public static void capturePackets(String interfaceName, int numPackets) {
        try {
            // Command to capture packets with tshark
            String command = String.format(CAPTURE_COMMAND_TEMPLATE, interfaceName, numPackets);
            Process process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", command});

            // Buffered Reader to capture output from tshark
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            packetData.add(new String[]{"Packet No", "Source", "Destination", "Protocol", "Length"});

            String line;
            while ((line = reader.readLine()) != null) {
                String[] packet = line.split("\t");
                packetData.add(packet);
            }
            process.waitFor();

            // Write the captured data to a CSV file
            writeToCSV("packet_data.csv", packetData);
            System.out.println("Packet data successfully saved to packet_data.csv");

            // Analyze packets for anomalies
            List<String[]> analyzedData = analyzePackets(packetData);
            writeToCSV("analyzed_packet_data.csv", analyzedData);
            System.out.println("Analyzed data successfully saved to analyzed_packet_data.csv");

            // Generate summary statistics
            generateSummaryStatistics(analyzedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to write data to CSV file
    private static void writeToCSV(String filename, List<String[]> data) {
        try (FileWriter csvWriter = new FileWriter(filename)) {
            for (String[] row : data) {
                csvWriter.append(String.join(",", row));
                csvWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to analyze packet data for anomalies
    public static List<String[]> analyzePackets(List<String[]> packetData) {
        List<String[]> analyzedData = new ArrayList<>();
        analyzedData.add(new String[]{"Packet No", "Source", "Destination", "Protocol", "Length", "Status"});

        int anomalyCount = 0;
        for (int i = 1; i < packetData.size(); i++) { // Skip header
            String[] packet = packetData.get(i);
            String protocol = packet[3];
            int length = Integer.parseInt(packet[4]);

            // Anomaly detection criteria
            String status = "Normal";
            if (protocol.equals("TCP") && length > 1000) {
                status = "Anomaly";
                anomalyCount++;
            } else if (protocol.equals("UDP") && length < 50) {
                status = "Anomaly";
                anomalyCount++;
            }
            analyzedData.add(new String[]{packet[0], packet[1], packet[2], packet[3], packet[4], status});
        }
        System.out.println("Total Anomalies Detected: " + anomalyCount);
        return analyzedData;
    }

    // Method to generate summary statistics
    public static void generateSummaryStatistics(List<String[]> analyzedData) {
        Map<String, Integer> ipCount = new HashMap<>();
        for (int i = 1; i < analyzedData.size(); i++) { // Skip header
            String[] packet = analyzedData.get(i);
            String sourceIP = packet[1];
            ipCount.put(sourceIP, ipCount.getOrDefault(sourceIP, 0) + 1);
        }

        System.out.println("Summary Statistics:");
        System.out.println("Total Packets: " + (analyzedData.size() - 1)); // Exclude header
        System.out.println("Total Anomalies: " + getAnomalyCount(analyzedData));
        System.out.println("Most Active IPs: " + getMostActiveIPs(ipCount));
    }

    // Method to get the anomaly count
    private static int getAnomalyCount(List<String[]> analyzedData) {
        int count = 0;
        for (String[] packet : analyzedData) {
            if (packet[5].equals("Anomaly")) {
                count++;
            }
        }
        return count;
    }

    // Method to get the most active IPs
    private static String getMostActiveIPs(Map<String, Integer> ipCount) {
        return ipCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .map(e -> e.getKey() + ": " + e.getValue())
                .reduce((e1, e2) -> e1 + ", " + e2)
                .orElse("None");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the network interface (e.g., Wi-Fi): ");
        String interfaceName = sc.nextLine();
        System.out.print("Enter the number of packets to capture: ");
        int numPackets = sc.nextInt();

        capturePackets(interfaceName, numPackets);
    }
}
