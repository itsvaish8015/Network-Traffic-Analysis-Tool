# Network Traffic Analysis Tool

<p align="center">
  <a href="brag-output/brag.mp4"><img src="brag-output/brag.jpg" alt="Watch the launch video" width="720"></a>
</p>

A real-time packet analysis tool integrated with **TShark** that captures and inspects live network traffic, flags anomalies using rule-based detection, and visualizes results through an interactive dashboard.

## Features
- Captures and processes live network traffic across multiple protocols (**TCP, UDP, DNS, TLS**) using TShark
- Parses packet attributes: source/destination IP, protocol type, packet length
- Rule-based anomaly detection (e.g., TCP packets over 1000 bytes, UDP packets under 50 bytes) — flagged **2 anomalies out of 20 packets (10% anomaly rate)** in test captures
- Generates summary statistics identifying the **top 5 most active source IPs** by packet volume
- Interactive frontend dashboard (Chart.js bar chart of packet types + D3.js force-directed network map of traffic relationships)

## Tech Stack
- **Backend:** Java, TShark (Wireshark CLI)
- **Frontend:** HTML, CSS, JavaScript, Chart.js, D3.js

## Project Structure
```
network-traffic-analyzer/
├── backend/
│   └── RealTimePacketAnalyzer.java   # Packet capture, anomaly detection, CSV export
├── frontend/
│   └── index.html                    # Dashboard: bar chart + network map
└── README.md
```

## How It Works
1. Prompts the user for a network interface (e.g., `Wi-Fi`) and number of packets to capture.
2. Runs TShark via `Runtime.exec` to capture live packets and extract frame number, source/destination IP, protocol, and length.
3. Writes raw captured data to `packet_data.csv`.
4. Applies anomaly rules to flag suspicious packets and writes results to `analyzed_packet_data.csv`.
5. Prints summary statistics (total packets, anomalies, most active IPs) to the console.
6. The frontend loads `analyzed_packet_data.csv` and renders a packet-type bar chart, summary stats, and a force-directed network map of IP-to-IP traffic.

## Running Locally
**Prerequisites:** Java JDK, [Wireshark/TShark](https://www.wireshark.org/) installed and available on PATH.

```bash
cd backend
javac RealTimePacketAnalyzer.java
java RealTimePacketAnalyzer
```
> Note: the capture command uses `cmd.exe`, so it runs on Windows as written. For macOS/Linux, replace the `Runtime.exec` call with a direct `tshark ...` command (no `cmd.exe /c` wrapper).

Then open `frontend/index.html` in a browser and upload the generated `analyzed_packet_data.csv`.

## Sample Output
```
Enter the network interface (e.g., Wi-Fi): Wi-Fi
Enter the number of packets to capture: 20
Packet data successfully saved to packet_data.csv
Total Anomalies Detected: 2
Analyzed data successfully saved to analyzed_packet_data.csv
Summary Statistics:
Total Packets: 20
Total Anomalies: 2
Most Active IPs: 192.168.229.138: 8, 52.137.106.217: 5, : 4, 192.168.229.133: 2, 20.212.88.117: 1
```
