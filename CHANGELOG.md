# Changelog

## 1.0.1 — 2026-08-05

### Added
- Support for Minecraft 1.20.1, 1.21.1, 26.1, and 26.1.2
- Jar filenames now include MC version (e.g. `beaconflight-1.0.1+mc1.20.1.jar`)

### Changed
- Tick check interval reduced to every 0.5s (10 ticks) for better performance on large servers

### Removed
- Fabric API dependency — the mod uses only vanilla Minecraft APIs

### Fixed
- Null safety check on `ServerPlayer.connection` for fake players / disconnected clients
- `compatibilityLevel` in `beaconflight.mixins.json` aligned with Java target version

## 1.0.0 — 2026-07

### Initial Release
- Creative flight inside beacon range
- Server-side only, zero configuration
- Any beacon effect (Speed, Haste, Resistance, Jump Boost, Strength, Regeneration) grants flight
- ~9s grace period after leaving beacon range (handled by vanilla beacon system)
