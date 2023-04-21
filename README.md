Sample-Project
==========

**Sample-Project**: 应用的简单介绍.

### 应用功能(可通过接口能力进行描述)
- 提供xxx能力
- 提供yyy能力
- 提供zzz能力

### 项目文档
- [设计文档](文档链接地址)
- [接口文档](文档链接地址)

### 代码结构
- domain: 领域层，负责领域模型、领域服务、仓储接口等的定义
- sdk: SDK接口层，负责接口、传输模型等的定义，业务简单的服务可以依赖domain层
- repository: 仓储层，封装仓储层的操作逻辑，存储、删除、查询等能力，依赖domain层
- server: 服务层，负责实现业务场景的相关的逻辑，依赖domain层、sdk层、repository层
- http: HTTP Client用于http请求的接口调试Case管理