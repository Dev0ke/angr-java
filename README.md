# angr-java

angr-java是一个使用Java语言重写的，基于Soot和Z3的Java符号执行引擎。

原始项目：
- https://github.com/angr/angr
- https://github.com/angr/pysoot

## 功能特性

- 基于Soot的程序分析框架
- 使用Z3 SMT求解器作为后端求解引擎。
- 多线程并行分析提升性能


## 系统要求

- Java 17或更高版本
- Maven 3.6或更高版本

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