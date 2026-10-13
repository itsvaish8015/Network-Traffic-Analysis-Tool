# BRAG Plan — Network Traffic Analysis Tool

## Invocation
`/brag --tone cinematic` (user-selected cinematic, landscape, no voice).

## 9-question rubric

1. **What is the app?**
   A real-time packet analysis tool that captures live network traffic with TShark, flags anomalies with rule-based detection, and visualizes results in an interactive dashboard.

2. **Funniest / most impressive claim.**
   It flagged 2 anomalies out of 20 captured packets — a 10% anomaly rate — from live traffic.

3. **Visual hook.**
   Packets as glowing streams crossing a dark operations grid, then one packet catching fire as an anomaly.

4. **What should be shown from the actual UI?**
   The light dashboard from `frontend/index.html`: the "Real-Time Packet Analyzer" title, the Chart.js packet-type bar chart, the summary statistics, and the D3 force-directed network map.

5. **Shortest satisfying video.**
   20 seconds. Hook → reveal → capture → anomaly → dashboard → outro.

6. **Tone.**
   Preset: `cinematic`. Direction: "network operations room trailer — every packet under a lens."

7. **Audio.**
   Warm, steady cinematic bed (`vol-12`), restrained motion-matched impact SFX. Audio-reactive treatment: subtle — hero glow and dashboard presence breathe with RMS. No waveform/equalizer visuals.

8. **Share caption.**
   See `share-copy.txt`.

9. **User flow worth showing.**
   Capture live packets → detect anomalies → inspect the dashboard.

## Angle

The tool treats ordinary network traffic like a crime scene. The video plays that straight: your network is constantly talking, packets leave traces, and this tool is the one paying attention. Cinematic scale, declarative sentences, big reveals.

Pattern: Hook (0–3.5s) → Reveal (3.5–7.0s) → Highlights (7.0–17.4s) → Outro (17.4–20.5s).

## Storyboard (total: 20.5s)

### Scene 1 — Hook — 0.0–3.5s
- Dark ops grid; packets stream left→right along three lanes with short trails.
- Line 1 "YOUR NETWORK" rises in at 0.2s.
- Line 2 "IS TALKING." rises in at 0.9s, "TALKING." in accent blue.
- SFX: `impact/impactSoft_medium_000` at 0.15s.
- Fade out at 3.1s.

### Scene 2 — Reveal — 3.5–7.0s
- Small badge "REAL-TIME PACKET ANALYZER" at 3.7s.
- Title "NETWORK TRAFFIC ANALYSIS TOOL" two lines, rise in at 3.82s (near beat 3.82).
- Subtitle "Real-time packet capture, powered by TShark." at 4.6s.
- Accent underline scaleX 0→1 at 4.7s.
- SFX: `impact/impactBell_heavy_000` at 3.7s (hero reveal).
- Fade out at 6.6s.

### Scene 3 — Live capture — 7.0–10.5s
- Eyebrow "LIVE CAPTURE" at 7.2s.
- Four protocol chips TCP / UDP / DNS / TLS drop in on beats 7.64, 8.19, 8.74, 9.29 (// beat-grid).
- Caption "Captures live traffic across TCP, UDP, DNS, and TLS." at 9.6s.
- SFX: `interface/drop_001..003` on first three chips; the TLS chip lands on strong cue 8.74 (// beat-locked).
- Fade out at 10.1s.

### Scene 4 — Anomaly detection — 10.5–14.0s
- Eyebrow "RULE-BASED ANOMALY DETECTION" at 10.7s.
- Big stat counts 0→10% starting on strong cue 10.93 (// beat-locked).
- Label "anomaly rate" at 11.3s.
- Sub "2 anomalies flagged across 20 captured packets." at 12.0s.
- SFX: `impact/impactMetal_medium_002` at 10.9s.
- Fade out at 13.6s.

### Scene 5 — Dashboard — 14.0–17.4s
- Eyebrow "INTERACTIVE DASHBOARD" at 14.2s.
- Light dashboard card scales in at 14.73s: title "Summary Statistics", packet-type bar chart, D3 network map.
- Bars grow and network nodes pop on beats 15.29→16.38 (// beat-grid).
- Caption "Chart.js bar chart + D3.js force-directed network map." at 16.5s.
- SFX: `impact/impactSoft_medium_001` at 14.7s.
- Fade out at 17.0s.

### Scene 6 — Outro — 17.4–20.5s
- "NETWORK TRAFFIC ANALYSIS TOOL" slams in at 17.47s (// beat-locked, strong cue).
- Tagline "See every packet. Miss nothing." at 18.3s.
- Accent bar scaleX at 18.56s (// beat-locked).
- SFX: `impact/impactBell_heavy_004` at 17.45s.
- Music fades under the logo; fade out at 20.1s.

## Music cue guidance
Source: bundled preset `<skill-dir>/assets/music/cues/happy-beats-business-moves-vol-12-by-ende-dot-app.music-cues.json`.
Track: `happy-beats-business-moves-vol-12-by-ende-dot-app.mp3` (117.36s, ~110 BPM).
Strong cues used: 8.74s, 10.93s, 17.47s (and 18.56s). Small entrances snap to the beat grid.
Cue metadata is optional timing guidance; story and readability stay primary.

## Voiceover
Not requested. No narration.
