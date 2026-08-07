# Changelog

## 1.0.2 — 2026-08-07

### Added
- **NeoForge** loader support (1.21.1, 1.21.11, 26.1, 26.2)
- **Forge** loader support (1.20.1)
- Stonecutter multi-loader / multi-version project structure
- Mojang-named Fabric builds for MC 26.x (byte-identical across versions)

### Changed
- Jar naming: `beaconflight-{mc_range}-{loader}-{version}.jar` (e.g. `beaconflight-1.20.x-fabric-1.0.2.jar`)
- Version directories renamed to match MC coverage ranges (e.g. `1.20.x-fabric/`, `26.1-neoforge/`)
- `fabric.mod.json` now uses `${mc_range}` for flexible version matching

### Removed
- Stale root-level `fabric.mod.json`

## 1.0.1 — 2026-08-07

### Added
- Support for Minecraft 1.20.1, 1.21.1, 1.21.11, 26.1, and 26.2
- Jar filenames now include MC version (e.g. `beaconflight+mc1.20.1-1.0.1.jar`)
- `CHANGELOG.md`

### Changed
- Tick check interval reduced to every 0.5s (10 ticks) for better performance
- **Beacon effect detection now checks `isAmbient()`** — potions, commands, and other non-beacon effect sources no longer grant flight
- Package renamed `com.example.beaconflight` → `com.redbean.beaconflight`
- All `fabric.mod.json` minecraft constraints switched to exact match (no `~` prefix)

### Removed
- Fabric API dependency — the mod uses only vanilla Minecraft APIs

### Fixed
- Null safety check on `ServerPlayer.connection` for fake players / disconnected clients
- Null safety on `MobEffectInstance` before calling `isAmbient()`
- `beaconflight$grantedByUs` flag prevents revoking flight granted by other mods
- `compatibilityLevel` in `beaconflight.mixins.json` aligned with Java target version
- Added `@Unique` annotation on `CHECK_INTERVAL` to prevent mixin conflicts
- `gradle-wrapper.jar` correctly tracked in nested directories

## 1.0.0 — 2026-07

### Initial Release
- Creative flight inside beacon range
- Server-side only, zero configuration
- Any beacon effect (Speed, Haste, Resistance, Jump Boost, Strength, Regeneration) grants flight
- ~9s grace period after leaving beacon range (handled by vanilla beacon system)
