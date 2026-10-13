# Hyperframes Composition Brief: Network Traffic Analysis Tool

## Objective
Create a short launch-style brag video for the Network Traffic Analysis Tool.

## Output
- Composition directory: `brag-output/composition/`
- Rendered video: `brag-output/brag.mp4`
- Format: landscape — 1920x1080
- Duration: 20.5 seconds

## Source Material
- Project root: `Network-Traffic-Analysis-Tool/`
- Primary files read: `frontend/index.html`, `README.md`
- Product name: Network Traffic Analysis Tool (dashboard title: "Real-Time Packet Analyzer")
- Tagline / strongest claim: "A real-time packet analysis tool integrated with TShark" / "2 anomalies out of 20 packets (10% anomaly rate)"
- Key UI or visual moment to recreate: the light dashboard card — "Summary Statistics", Chart.js packet-type bar chart, and the D3 force-directed network map.
- Copy that must appear verbatim:
  - "Real-Time Packet Analyzer"
  - "Captures live traffic across TCP, UDP, DNS, TLS"
  - "2 anomalies out of 20 packets (10% anomaly rate)"
  - "Chart.js bar chart + D3.js force-directed network map"

## Creative Direction
- Tone preset: cinematic
- Creative direction: "network operations room trailer — every packet under a lens"
- Interpretation: full-bleed scenes, large all-caps type, dramatic reveals, slow scale-in transitions; declarative sentences that land before the next begins.
- Angle: ordinary network traffic treated like a crime scene; the tool is the one paying attention.
- Hook: "YOUR NETWORK IS TALKING."
- Outro / punchline: "NETWORK TRAFFIC ANALYSIS TOOL — See every packet. Miss nothing."
- Avoid:
  - Generic SaaS language
  - Abstract filler visuals
  - Unrelated visual redesign

## Visual Identity
- Background: deep ops navy `#070b14` (product's light UI reversed for cinematic drama)
- Text: `#f4f7fb`
- Accent: product blue `#35a3ff` (brand `#007bff` brightened for contrast); alert green `#34d07a` (from `#28a745`)
- Dashboard panel (verbatim product look): background `#f0f4f8`, card `#ffffff`, text `#1a2433`, blue `#007bff`
- Display font: `Inter, ui-sans-serif, system-ui, sans-serif` (system stack, no webfont dependency)
- Body font: same
- Visual references from the project: bar chart (packet types), force-directed network map, "Summary Statistics" panel

## Storyboard
Contract: `brag-output/brag-plan.md`. Scene summary:
1. Hook — 3.5s — "YOUR NETWORK IS TALKING." over packet streams
2. Reveal — 3.5s — title + "Real-Time Packet Analyzer" badge + TShark subtitle
3. Live capture — 3.5s — TCP/UDP/DNS/TLS chips
4. Anomaly detection — 3.5s — 10% anomaly rate stat
5. Dashboard — 3.4s — light dashboard card (bar chart + network map)
6. Outro — 3.1s — name slam + tagline

## Audio
- Audio role: cinematic support
- Audio arc: steady bed enters immediately, sits under the edit, swells conceptually at the outro, fades under the final logo
- Music: `assets/music/happy-beats-business-moves-vol-12-by-ende-dot-app.mp3`
- Music treatment: volume 0.35 bed; brief fade-in at 0 and a fade-out under the final logo
- Music cue guidance: bundled preset `cues/happy-beats-business-moves-vol-12-by-ende-dot-app.music-cues.json`; strong cues at 8.74s, 10.93s, 17.47s; beat grid for chip/bar/node entrances
- Audio-reactive treatment: subtle — hero glow and dashboard card presence breathe with RMS. No waveform/equalizer visuals.
- Audio-coupled moments:
  - Scene 3 chips — sequential drop SFX land with each chip
  - Scene 4 stat — metal accent as the counter settles
  - Scene 6 logo — bell on the slam, music fades under it
- SFX selection guidance: `impactBell_heavy_*` for hero/outro, `impactSoft_medium_*` for reveals, `interface/drop_*` for chips. Guidance doc: `<skill-dir>/assets/sfx/sfx-analysis.md`
- Exact SFX choice: implemented in the composition.
- Audio files: copied into `composition/assets/`.

## Hyperframes Instructions
Load `hyperframes-core`, `hyperframes-animation`, `hyperframes-creative`, `hyperframes-keyframes`, `hyperframes-cli`. Requirements:
- Show at least one real UI/copy element from the source project (dashboard card).
- Keep all text readable; keep within 15–25s.
- Deterministic only; one paused root timeline on `window.__timelines["main"]`.
- Run `npx hyperframes check` before render; render locally.
