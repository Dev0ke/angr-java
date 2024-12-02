## Guide
1. 生成精确的CFG
2. 检查invoke的API，并标记至CFG中的节点（称之为checkPoint）
3. 从首个checkPoint开始进行流敏感分析，寻找可达非终止路径上的所有checkPoint。

## TODO
- EntryAPI Finder

寻找所有公开的API接口，provider..

根据`C:\Users\devoke\Desktop\Android_base\services\core\java\com\android\server\audio\AudioService.java
` ,发现这些类的共性，都是继承了Stub

- checkPoint Tagger

从EntryAPI为入口，在其CG中寻找所有的APIcheck，标记为checkPoint，同时标记其调用路径，方便后续路径分析。

- Path Analyzer

进行逐语句的路径敏感分析，寻找所有可达路径。

? 如何确定终止条件呢？

? 有些检查是在onTranact的switch-case里面，如何确定分析的入口呢？
1. 处理invoke：1.标记点 2.污点作为传入参数 3.返回值与污点比较