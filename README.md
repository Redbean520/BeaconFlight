# 信标飞行 Beacon Flight

[![Minecraft](https://img.shields.io/badge/Minecraft-26.2-brightgreen)](https://minecraft.net)
[![Fabric](https://img.shields.io/badge/Mod_Loader-Fabric-blue)](https://fabricmc.net)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
![Environment](https://img.shields.io/badge/Environment-Server-orange)

---

## ✈ 简介

在信标范围内获得**创造模式飞行**能力。

只要身上有信标效果（速度、急迫、抗性、跳跃提升、力量、生命恢复中的任意一个），就能像创造模式一样自由飞翔。离开范围后效果自然消失，飞行也随之停止，有约 9 秒的缓冲时间让你安全落地。

**纯服务端**模组——装在服务器上，所有玩家都能用。单人游戏也照常生效。

### 🎮 使用方法

1. 建造一个激活的信标（任意等级）
2. 在信标 GUI 中选择任意效果
3. 进入范围 → **自动获得飞行**
4. 离开范围 → 信标效果过期后飞行自动停止

无需特殊操作，信标的原生效果图标就是飞行状态的指示器。

### ✨ 特性

- 🚀 信标范围内创造飞行
- 🎯 不需要额外操作，选中任意信标效果即可
- ⏱ 离开范围约 9 秒缓冲后飞行停止
- 🖥 纯服务端，玩家无需安装
- ⚡ 零性能开销——仅检查玩家身上的原版效果
- 🔧 无配置文件，即装即用

### 📦 安装

1. 下载 `beaconflight-1.0.0.jar`
2. 放入服务端或单人游戏的 `mods/` 文件夹
3. 确保已安装 **Fabric Loader** 和 **Fabric API**
4. 启动游戏

### 🔗 依赖

| 依赖 | 版本 |
|---|---|
| Minecraft | 26.2 |
| Fabric Loader | ≥ 0.19.3 |
| Fabric API | 任意 |
| Java | ≥ 25 |

### 📝 技术细节

- 零扫描、零计时器——完全依赖原版信标的范围和效果系统
- 通过 Mixin 注入 `ServerPlayer.tick()`，在玩家拥有信标效果时设置 `mayfly = true`
- 效果消失时自动恢复，不影响创造/旁观模式玩家

---

## ✈ Description

Grants **creative-mode flight** to any player with an active beacon effect.

As long as you have ANY beacon effect active (Speed, Haste, Resistance, Jump Boost, Strength, or Regeneration), you can fly freely within the beacon's range. When you leave the range, the flight naturally expires with the beacon effects — giving you about 9 seconds of buffer time to land safely.

**Server-side only** — install on your server and all players benefit. Works in singleplayer too.

### 🎮 How to Use

1. Build and activate a beacon (any tier)
2. Select any effect in the beacon GUI
3. Enter range → **flight automatically activates**
4. Leave range → flight expires with beacon effects

The vanilla beacon effect icon serves as your flight indicator.

### ✨ Features

- 🚀 Creative flight inside beacon range
- 🎯 No special actions needed — just select any beacon effect
- ⏱ ~9s grace period after leaving range
- 🖥 Server-side — players don't need to install
- ⚡ Zero performance overhead — only checks for vanilla beacon effects
- 🔧 No config, plug and play

### 📦 Installation

1. Download `beaconflight-1.0.0.jar`
2. Place in `mods/` folder (server or singleplayer)
3. Requires **Fabric Loader** + **Fabric API**
4. Launch and enjoy!

---

## 👤 Author

**Redbean**

## 📄 License

MIT
