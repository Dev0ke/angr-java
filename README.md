# angr-java

angr-java是一个使用Java语言重写的，基于Soot和Z3的Java符号执行引擎。

原始项目：
- https://github.com/angr/angr
- https://github.com/angr/pysoot

## 功能特性

- 基于Soot的程序分析框架
- 使用Z3 SMT求解器作为后端求解引擎
- 多线程并行分析提升性能
- 支持Java字节码/Android dex/odex符号执行
- 提供API接口用于自定义分析

## 系统要求

- Java 17或更高版本
- Maven 3.6或更高版本
- Linux/Unix操作系统

## 快速开始

1. 下载z3
```bash
cd ~
wget https://github.com/Z3Prover/z3/releases/download/z3-4.13.4/z3-4.13.4-x64-glibc-2.35.zip
unzip z3-4.13.4-x64-glibc-2.35.zip
```

2. 配置环境变量

```bash
export Z3_DIR=~/z3-4.13.4-x64-glibc-2.35
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$Z3_DIR/bin
export LC_ALL=C
```

3. 克隆项目

```bash
git clone https://github.com/Dev0ke/angr-java
cd angr-java
mvn clean package
```



## 贡献指南

我们欢迎社区贡献！如果您想要参与项目开发，请：

1. Fork本仓库
2. 创建您的特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交您的修改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启一个Pull Request



## 联系方式

- 项目维护者：[Dev0ke]
- 项目问题反馈：[GitHub Issues](https://github.com/Dev0ke/angr-java/issues)