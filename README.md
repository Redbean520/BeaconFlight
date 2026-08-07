# 信标飞行 | Beacon Flight

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Mod Loader: Fabric](https://img.shields.io/badge/Mod_Loader-Fabric-blue)](https://fabricmc.net)
[![Mod Loader: NeoForge](https://img.shields.io/badge/Mod_Loader-NeoForge-orange)](https://neoforged.net)
[![Mod Loader: Forge](https://img.shields.io/badge/Mod_Loader-Forge-red)](https://minecraftforge.net)
[![Environment: Server](https://img.shields.io/badge/Environment-Server-orange)](#)
[![Modrinth](https://img.shields.io/badge/Modrinth-coming_soon-green)](#)
[![CurseForge](https://img.shields.io/badge/CurseForge-coming_soon-orange)](#)

[**English**](#english) | [**中文**](#中文)

---

<a name="中文"></a>
## ✈ 信标飞行

在信标范围内获得**创造模式飞行**能力——只要身上有任意信标效果，就能像创造模式一样自由飞翔。

**纯服务端**模组，装在服务器上所有玩家都能用，单人游戏也生效。无配置文件、无额外依赖，即装即用。

### 🎮 使用

1. 建造一个激活的信标（任意等级）
2. 选择任意信标效果
3. 进入范围 → **自动获得飞行**
4. 离开范围 → 效果过期后飞行自动停止（~9 秒缓冲）

### ✨ 特性

- 🚀 信标范围内创造模式飞行
- 🎯 零操作——选中任意信标效果即可
- ⏱ 离开范围约 9 秒缓冲后自动停止
- 🖥 纯服务端，玩家无需安装
- ⚡ 零性能开销——仅检查原版信标效果
- 🔧 无配置文件，即装即用
- 📦 无需 Fabric API
- 🔌 支持 Fabric / NeoForge / Forge 三种 loader

### 📥 下载

从 [Releases](../../releases) 页面选择对应 MC 版本和 loader 的 jar：

| MC 范围 | Loader | Jar |
|----------|--------|-----|
| 1.20.x | Fabric | `beaconflight-1.20.x-fabric-1.0.3.jar` |
| 1.20.x | Forge | `beaconflight-1.20.x-forge-1.0.3.jar` |
| 1.21.1 | Fabric | `beaconflight-1.21.1-fabric-1.0.3.jar` |
| 1.21.1 | NeoForge | `beaconflight-1.21.1-neoforge-1.0.3.jar` |
| 1.21.11 | Fabric | `beaconflight-1.21.11-fabric-1.0.3.jar` |
| 1.21.11 | NeoForge | `beaconflight-1.21.11-neoforge-1.0.3.jar` |
| 26.1.x | Fabric | `beaconflight-26.1.x-fabric-1.0.3.jar` |
| 26.1.x | NeoForge | `beaconflight-26.1.x-neoforge-1.0.3.jar` |
| 26.2.x | Fabric | `beaconflight-26.2.x-fabric-1.0.3.jar` |
| 26.2.x | NeoForge | `beaconflight-26.2.x-neoforge-1.0.3.jar` |

Jar 命名格式: `beaconflight-{mc_range}-{loader}-{mod_version}.jar`

### 📦 安装

1. 下载对应 MC 版本和 loader 的 jar
2. 放入 `mods/` 文件夹
3. 确保已安装对应的 **Mod Loader**（Fabric / NeoForge / Forge）
4. 启动游戏

### 🔧 构建

```bash
# 全量构建（需 JDK 17+，Gradle wrapper 会自动下载所需 JDK）
./gradlew build

# 构建单个版本
./gradlew :1.21.1-fabric:build
```

各版本的 JDK 要求：

| 版本 | JDK |
|------|-----|
| 1.20.x | ≥ 17 |
| 1.21.x | ≥ 21 |
| 26.x | ≥ 25 |

### 📝 技术细节

- **零扫描、零计时器**——完全依赖原版信标的范围和效果系统
- 通过 Mixin 注入 `ServerPlayer.tick()`，检测 `BeaconBlockEntity.BEACON_EFFECTS`
- 拥有信标效果时设置 `mayfly = true`，效果消失自动恢复
- 不影响创造/旁观模式玩家
- 每 0.5 秒检查一次（信标效果本身有数秒缓冲），极致性能

---

<a name="english"></a>
## ✈ Beacon Flight

Grants **creative-mode flight** to players within an active beacon's range. As long as you have ANY beacon effect active, you can fly freely.

**Server-side only** — install on your server and all players benefit. No config, no extra dependencies.

### 🎮 Usage

1. Build and activate a beacon (any tier)
2. Select any effect in the beacon GUI
3. Enter range → **flight activates automatically**
4. Leave range → flight expires with ~9s grace period

### ✨ Features

- 🚀 Creative flight inside beacon range
- 🎯 Zero setup — just select any beacon effect
- ⏱ ~9s grace period after leaving range
- 🖥 Server-side — players don't need to install
- ⚡ Zero overhead — checks vanilla beacon effects only
- 🔧 No config, plug and play
- 📦 No Fabric API required
- 🔌 Fabric / NeoForge / Forge loaders supported

### 📥 Download

Choose the jar matching your MC version and loader from [Releases](../../releases):

| MC 范围 | Loader | Jar |
|----------|--------|-----|
| 1.20.x | Fabric | `beaconflight-1.20.x-fabric-1.0.3.jar` |
| 1.20.x | Forge | `beaconflight-1.20.x-forge-1.0.3.jar` |
| 1.21.1 | Fabric | `beaconflight-1.21.1-fabric-1.0.3.jar` |
| 1.21.1 | NeoForge | `beaconflight-1.21.1-neoforge-1.0.3.jar` |
| 1.21.11 | Fabric | `beaconflight-1.21.11-fabric-1.0.3.jar` |
| 1.21.11 | NeoForge | `beaconflight-1.21.11-neoforge-1.0.3.jar` |
| 26.1.x | Fabric | `beaconflight-26.1.x-fabric-1.0.3.jar` |
| 26.1.x | NeoForge | `beaconflight-26.1.x-neoforge-1.0.3.jar` |
| 26.2.x | Fabric | `beaconflight-26.2.x-fabric-1.0.3.jar` |
| 26.2.x | NeoForge | `beaconflight-26.2.x-neoforge-1.0.3.jar` |

Jar naming: `beaconflight-{mc_range}-{loader}-{mod_version}.jar`

### 📦 Installation

1. Download the jar matching your MC version and mod loader
2. Place in `mods/` folder (server or singleplayer)
3. Ensure the matching **Mod Loader** is installed (Fabric / NeoForge / Forge)
4. Launch and enjoy!

### 🔧 Build

```bash
# Build all versions (requires Gradle wrapper, auto-downloads JDKs)
./gradlew build

# Build a single version
./gradlew :1.21.1-fabric:build
```

| Version | JDK |
|---------|-----|
| 1.20.x | ≥ 17 |
| 1.21.x | ≥ 21 |
| 26.x | ≥ 25 |

### 📝 Technical Details

- **No scanning, no timers** — leverages vanilla beacon range & effect system
- Mixin into `ServerPlayer.tick()`, checks `BeaconBlockEntity.BEACON_EFFECTS`
- Sets `mayfly = true` when beacon effects are active, auto-revokes on expiry
- Does not affect creative or spectator players
- Checks every 0.5s — beacon effects have multi-second buffer, so this is imperceptible

---

## 📁 Project Structure

```
BeaconFlight/
├── build.gradle              ← 核心构建脚本（三 loader 条件激活）
├── settings.gradle.kts       ← Stonecutter 版本注册
├── stonecutter.gradle.kts    ← 当前活跃版本
├── src/
│   ├── main/java/.../        ← 共享源代码（Mixin + BeaconEffectCompat）
│   ├── main/resources/       ← 共享资源（mixin 配置、语言文件）
│   ├── fabric/               ← Fabric 入口点 + fabric.mod.json
│   ├── neoforge/             ← NeoForge 入口点 + neoforge.mods.toml
│   └── forge/                ← Forge 入口点 + mods.toml
└── versions/                 ← 各版本独立目录
    ├── 1.20.x-fabric/        ← Fabric 1.20.x（intermediary 映射）
    ├── 1.20.x-forge/         ← Forge 1.20.x
    ├── 1.21.1-fabric/        ← Fabric 1.21.1（intermediary）
    ├── 1.21.1-neoforge/      ← NeoForge 1.21.1
    ├── 1.21.11-fabric/       ← Fabric 1.21.11（intermediary）
    ├── 1.21.11-neoforge/     ← NeoForge 1.21.11
    ├── 26.1.x-fabric/          ← Fabric 26.1.x（Mojang 映射）
    ├── 26.1.x-neoforge/        ← NeoForge 26.1.x
    ├── 26.2.x-fabric/          ← Fabric 26.2.x（Mojang 映射）
    └── 26.2.x-neoforge/        ← NeoForge 26.2.x
```

## 👤 Author

**Redbean**

## ❤️ Sponsor / 赞助

完全免费，用爱发电。如果这个模组帮到了你，欢迎请我喝杯咖啡 ☕

- [爱发电](https://afdian.net/a/HD520)

| 支付宝 Alipay | 微信 WeChat |
|:---:|:---:|
| ![支付宝](alipay.jpg) | ![微信](wechat.jpg) |

## 📄 License

[MIT](LICENSE) — 自由使用、修改、分发。
