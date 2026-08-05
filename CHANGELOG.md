# Changelog

## 1.0.1 — 2026-08-05

### Added
- Support for Minecraft 1.20.1, 1.21.1, 1.21.11, 26.1, 26.1.2, and 26.2
- Jar filenames now include MC version (e.g. `beaconflight+mc1.20.1-1.0.1.jar`)
- `CHANGELOG.md`

### Changed
- Tick check interval reduced to every 0.5s (10 ticks) for better performance
- **Beacon effect detection now checks `isAmbient()`** — potions, commands, and other non-beacon effect sources no longer grant flight
- Package renamed `com.example.beaconflight` → `com.redbean.beaconflight`
- Updated `.gitignore` to correctly track `gradle-wrapper.jar` in nested directories

### Removed
- Fabric API dependency — the mod uses only vanilla Minecraft APIs

### Fixed
- Null safety check on `ServerPlayer.connection` for fake players / disconnected clients
- `compatibilityLevel` in `beaconflight.mixins.json` aligned with Java target version
- Added `@Unique` annotation on `CHECK_INTERVAL` to prevent mixin conflicts

## 1.0.0 — 2026-07

### Initial Release
- Creative flight inside beacon range
- Server-side only, zero configuration
- Any beacon effect (Speed, Haste, Resistance, Jump Boost, Strength, Regeneration) grants flight
- ~9s grace period after leaving beacon range (handled by vanilla beacon system)
