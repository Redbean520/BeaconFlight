# BeaconFlight - JDK 21 安装脚本
# 用于构建 MC 1.20.1 和 1.21.1 版本
# 以管理员身份运行此脚本

$jdkVersion = "21"
$installPath = "C:\Program Files\Eclipse Adoptium\jdk-21"

Write-Host "=== BeaconFlight JDK 21 安装 ===" -ForegroundColor Cyan
Write-Host ""

# 检查是否已安装
if (Test-Path "$installPath\bin\java.exe") {
    Write-Host "[OK] JDK 21 已安装在: $installPath" -ForegroundColor Green
    & "$installPath\bin\java" -version
    Write-Host ""
    Write-Host "如需重新安装，请先手动删除上述目录。"
    exit 0
}

Write-Host "[1/2] 正在下载 Adoptium JDK 21..."
$url = "https://api.adoptium.net/v3/binary/latest/21/ga/windows/x64/jdk/hotspot/normal/eclipse"
$tempFile = "$env:TEMP\jdk-21.msi"

try {
    Invoke-WebRequest -Uri $url -OutFile $tempFile -ErrorAction Stop
    Write-Host "[OK] 下载完成: $tempFile"
} catch {
    Write-Host "[FAIL] 下载失败: $_" -ForegroundColor Red
    Write-Host "请手动从 https://adoptium.net/download/ 下载 JDK 21 并安装到: $installPath"
    exit 1
}

Write-Host "[2/2] 正在安装 JDK 21 到 $installPath ..."
try {
    Start-Process msiexec.exe -ArgumentList "/i `"$tempFile`" /quiet /norestart INSTALLDIR=`"$installPath`"" -Wait
    Write-Host "[OK] 安装完成!" -ForegroundColor Green
} catch {
    Write-Host "[FAIL] 安装失败: $_" -ForegroundColor Red
    exit 1
}

# 验证
if (Test-Path "$installPath\bin\java.exe") {
    Write-Host ""
    Write-Host "=== 验证安装 ===" -ForegroundColor Cyan
    & "$installPath\bin\java" -version
    Write-Host ""
    Write-Host "[OK] JDK 21 安装成功！现在可以构建 BeaconFlight 1.20.1 和 1.21.1 了。" -ForegroundColor Green
} else {
    Write-Host "[FAIL] 安装后未找到 java.exe，请手动检查。" -ForegroundColor Red
    exit 1
}
