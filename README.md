# 信标飞行 | Beacon Flight

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Mod Loader: Fabric](https://img.shields.io/badge/Mod_Loader-Fabric-blue)](https://fabricmc.net)
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

### 📥 下载

从 [Releases](../../releases) 页面选择对应 MC 版本的 jar：

| Minecraft | 状态 |
|-----------|------|
| 1.20.1 | ✅ |
| 1.21.1 | ✅ |
| 1.21.11 | ✅ |
| 26.1 | ✅ |
| 26.2 | ✅ |

### 📦 安装

1. 下载对应 MC 版本的 jar（如 `beaconflight+mc1.20.1-1.0.1.jar`）
2. 放入 `mods/` 文件夹
3. 确保已安装 **Fabric Loader**
4. 启动游戏

### 🔧 构建

```bash
# 以 1.20.1 为例（需 JDK 17+）
cd 1.20.1
./gradlew build
# jar 输出到 build/libs/（如 beaconflight+mc1.20.1-1.0.1.jar）
```

各版本的 JDK 要求：

| 版本 | JDK |
|------|-----|
| 1.20.1 | ≥ 17 |
| 1.21.1 / 1.21.11 | ≥ 21 |
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

### 📥 Download

Choose the jar matching your MC version from [Releases](../../releases):

| Minecraft | Status |
|-----------|--------|
| 1.20.1 | ✅ |
| 1.21.1 | ✅ |
| 1.21.11 | ✅ |
| 26.1 | ✅ |
| 26.2 | ✅ |

### 📦 Installation

1. Download the jar matching your MC version (e.g. `beaconflight+mc1.20.1-1.0.1.jar`)
2. Place in `mods/` folder (server or singleplayer)
3. Ensure **Fabric Loader** is installed
4. Launch and enjoy!

### 🔧 Build

```bash
# Example for 1.20.1 (requires JDK 17+)
cd 1.20.1
./gradlew build
# Output: build/libs/
```

| Version | JDK |
|---------|-----|
| 1.20.1 | ≥ 17 |
| 1.21.1 / 1.21.11 | ≥ 21 |
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
├── README.md
├── LICENSE
├── 1.20.1/       ← MC 1.20.1 (pre-Holder API)
├── 1.21.1/       ← MC 1.21.1 (Holder API)
├── 1.21.11/      ← MC 1.21.11 (Holder API)
├── 26.1/         ← MC 26.1 Tiny Takeover
└── 26.2/         ← MC 26.2 Summer Drop
```

## 👤 Author

**Redbean**

## ❤️ 赞助 Sponsor

用爱发电，完全免费。如果这个模组帮到了你，欢迎请我喝杯咖啡 ☕

- [爱发电](https://afdian.net/a/HD520)

| 支付宝 Alipay | 微信 WeChat |
|:---:|:---:|
| ![支付宝](alipay.jpg) | ![微信](wechat.jpg) |

## 📄 License

[MIT](LICENSE) — 自由使用、修改、分发。
