# NJFU-IoT-Practice 教学平台项目介绍

## 项目概述
本项目 `NJFU-IoT-Practice` 是与南京林业大学物联网实践相关的教学平台项目，其中包含了 `portal-teachingmyj` 子项目，主要基于 Vue 3 和 Vite 进行开发，用于教学实践的相关功能实现。

## 项目结构
### 主要目录结构
- `njfu001`：项目主目录，包含教学平台相关的配置和子项目。
  - `.idea`：IDE 相关配置文件。
  - `teaching-platform`：教学平台核心代码目录。
    - `teaching-platform`：二级目录。
      - `portal-teachingmyj`：基于 Vue 3 和 Vite 的前端项目。
        - `src`：源代码目录。
        - `public`：公共资源目录。
        - `package.json`：项目依赖和脚本配置文件。
        - `pnpm-lock.yaml`：pnpm 依赖锁定文件。
        - `README.md`：项目说明文档。

## 子项目：portal-teachingmyj

### 项目介绍
`portal-teachingmyj` 是一个基于 Vue 3 和 Vite 的前端项目，旨在为教学平台提供用户界面和交互功能。

### 推荐的 IDE 配置
- [VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) （并禁用 Vetur）

### 项目设置

#### 安装依赖
```sh
pnpm install
```

#### 开发环境编译和热更新
```sh
pnpm dev
```

#### 生产环境编译和压缩
```sh
pnpm build
```

#### 使用 ESLint 进行代码检查
```sh
pnpm lint
```

### 自定义配置
如需自定义配置，请参考 [Vite 配置参考](https://vite.dev/config/)。

### 项目依赖
- **生产依赖**：
  - `@element-plus/icons-vue`：Element Plus 图标库。
  - `axios`：用于发送 HTTP 请求。
  - `element-plus`：Element Plus 组件库。
  - `pinia`：Vue 状态管理库。
  - `vue`：Vue 3 核心库。
  - `vue-router`：Vue 路由库。
- **开发依赖**：
  - `@eslint/js`：ESLint JavaScript 插件。
  - `@vitejs/plugin-vue`：Vite Vue 插件。
  - `eslint`：代码检查工具。
  - `eslint-plugin-vue`：ESLint Vue 插件。
  - `sass`：CSS 预处理器。
  - `vite`：构建工具。

## 其他配置文件说明
### `.gitignore` 文件
- `portal-teachingmyj/.gitignore`：指定了项目中需要忽略的文件和目录，如日志文件、`node_modules` 等。
- `njfu001/.idea/.gitignore` 和 `teaching-platform/teaching-platform/.idea/.gitignore`：IDE 相关的忽略文件配置。

### `jarRepositories.xml` 文件
`njfu001/teaching-platform/teaching-platform/.idea/jarRepositories.xml` 和 `njfu001/.idea/jarRepositories.xml` 配置了 Maven 远程仓库的信息，包括中央仓库、JBoss 社区仓库等。

## 贡献指南
如果您想为项目做出贡献，请遵循以下步骤：
1. Fork 本仓库。
2. 创建新的分支进行开发。
3. 提交代码并发起 Pull Request。

## 许可证
本项目采用 [具体许可证] 许可证，详情请参考 [许可证文件]。

## 联系方式
如果您有任何问题或建议，请联系 [联系人邮箱]。

## 代码贡献
本篇代码全部来自好厚米mmm，正宗代码，值得拥有！
