# Git推送指南

## 当前状态

✅ **提交已创建成功**
- Commit ID: `fe87c95`
- 提交信息: `feat(角色D): 完成问卷填写、数据可视化和系统测试功能`
- 文件变更: 50个文件，6441行新增

❌ **推送失败**
- 错误: `Permission denied`
- 原因: GitHub认证问题

## 解决方案

### 方案1: 使用SSH密钥（推荐）

1. **检查是否已有SSH密钥**:
```bash
ls -al ~/.ssh
```

2. **如果没有，生成SSH密钥**:
```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

3. **添加SSH密钥到GitHub**:
   - 复制公钥: `cat ~/.ssh/id_ed25519.pub`
   - 登录GitHub → Settings → SSH and GPG keys → New SSH key
   - 粘贴公钥并保存

4. **更改远程仓库URL为SSH**:
```bash
git remote set-url origin git@github.com:breezeys1n/smart-survey-system.git
```

5. **测试连接**:
```bash
ssh -T git@github.com
```

6. **推送**:
```bash
git push origin master
```

### 方案2: 使用Personal Access Token（PAT）

1. **创建Personal Access Token**:
   - 登录GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic)
   - 点击 "Generate new token (classic)"
   - 选择权限: `repo` (完整仓库权限)
   - 生成并复制token

2. **使用token推送**:
```bash
git push https://<YOUR_TOKEN>@github.com/breezeys1n/smart-survey-system.git master
```

或者配置Git凭据:
```bash
git config --global credential.helper store
git push origin master
# 输入用户名: breezeys1n
# 输入密码: <YOUR_TOKEN>
```

### 方案3: 使用GitHub CLI

1. **安装GitHub CLI**:
   - Windows: `winget install GitHub.cli`
   - 或访问: https://cli.github.com/

2. **登录**:
```bash
gh auth login
```

3. **推送**:
```bash
git push origin master
```

## 推送命令

推送成功后，使用以下命令验证:

```bash
# 查看远程仓库状态
git remote -v

# 查看提交历史
git log --oneline -5

# 查看远程分支
git branch -r
```

## 提交内容总结

本次提交包含:

### 新增文件 (50个)
- **frontend/**: 完整的前端React项目
  - 页面组件: HomePage, FillPage, StatisticsPage
  - 业务组件: QuestionItem, PieChart, BarChart, TextAnswerList
  - 通用组件: Loading, ErrorMessage
  - API服务: api.js
  - 配置文件: package.json, vite.config.js

- **mock/**: 5组测试数据
  - init-data-set1.sql ~ init-data-set5.sql

- **scripts/**: 数据切换工具
  - switch-data.ps1 (PowerShell)
  - switch-data.sh (Bash)
  - switch-data.bat (CMD)

- **docs/**: 项目文档
  - 开发文档.md
  - 角色D-接口文档.md
  - 问卷实现.md
  - Git提交说明.md

- **README.md**: 项目主文档

### 修改文件 (8个)
- `.gitignore`: 添加前端相关忽略规则
- `src/main/java/.../entity/*.java`: 添加@JsonIgnore注解
- `src/main/java/.../service/QuestionnaireServiceImpl.java`: 修复LAZY加载
- `src/main/resources/application.properties`: 配置更新

## 注意事项

1. **node_modules已忽略**: 不会提交到仓库
2. **target已忽略**: 编译产物不会提交
3. **敏感信息**: application.properties中的数据库密码需要团队成员自行配置
4. **Mock.ps1**: 未提交（用户个人文件）

## 验证推送成功

推送成功后，访问GitHub仓库:
```
https://github.com/breezeys1n/smart-survey-system
```

应该能看到:
- ✅ 新增的frontend/目录
- ✅ 新增的mock/目录
- ✅ 新增的scripts/目录
- ✅ 更新的docs/目录
- ✅ 更新的README.md

## 后续操作

推送成功后，团队成员可以:

1. **拉取最新代码**:
```bash
git pull origin master
```

2. **安装前端依赖**:
```bash
cd frontend
npm install
```

3. **启动项目**:
```bash
# 后端
mvn spring-boot:run

# 前端（新终端）
cd frontend
npm run dev
```

4. **切换测试数据**:
```bash
cd scripts
.\switch-data.ps1 -Dataset 1
```

---

**如有问题，请检查**:
1. GitHub账户权限
2. 网络连接
3. Git配置

