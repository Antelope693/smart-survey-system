# Fork 和 Pull Request 操作指南

## 📋 当前状态

✅ **所有代码已提交到本地功能分支**: `feature/role-d-questionnaire-filling`  
⚠️ **您不是项目协作者**: 需要通过 Fork 方式提交 PR

## 🔄 标准 Fork 工作流

### 步骤1: Fork 原仓库到您的账户

1. **访问原仓库**: https://github.com/breezeys1n/smart-survey-system

2. **点击 Fork 按钮**:
   - 在仓库页面右上角点击 "Fork" 按钮
   - 选择您的账户作为 Fork 目标
   - 等待 Fork 完成

3. **获取您的 Fork 地址**:
   - Fork 完成后，您会有一个新的仓库地址
   - 格式: `https://github.com/您的用户名/smart-survey-system`

### 步骤2: 添加 Fork 作为远程仓库

```bash
# 查看当前远程仓库
git remote -v

# 添加您的 Fork 作为新的远程仓库（命名为 fork）
git remote add fork https://github.com/您的用户名/smart-survey-system.git

# 或者使用 SSH（如果已配置）
git remote add fork git@github.com:您的用户名/smart-survey-system.git

# 验证
git remote -v
# 应该看到:
# origin    https://github.com/breezeys1n/smart-survey-system.git (fetch)
# origin    https://github.com/breezeys1n/smart-survey-system.git (push)
# fork      https://github.com/您的用户名/smart-survey-system.git (fetch)
# fork      https://github.com/您的用户名/smart-survey-system.git (push)
```

### 步骤3: 推送功能分支到您的 Fork

```bash
# 确保在功能分支上
git branch
# 应该显示: * feature/role-d-questionnaire-filling

# 推送功能分支到您的 Fork
git push -u fork feature/role-d-questionnaire-filling
```

**如果遇到权限问题**:
- 确保已登录 GitHub
- 检查 Fork 是否成功
- 参考 `docs/Git推送指南.md` 配置 SSH 或 Token

### 步骤4: 在 GitHub 创建 Pull Request

1. **访问您的 Fork**: https://github.com/您的用户名/smart-survey-system

2. **创建 PR**:
   - 您会看到提示: "feature/role-d-questionnaire-filling had recent pushes"
   - 点击 "Compare & pull request" 按钮
   - 或者点击 "Pull requests" → "New pull request"

3. **选择仓库和分支**:
   - **Base repository**: `breezeys1n/smart-survey-system` ← 原仓库
   - **Base**: `master` ← 原仓库的主分支
   - **Head repository**: `您的用户名/smart-survey-system` ← 您的 Fork
   - **Compare**: `feature/role-d-questionnaire-filling` ← 您的功能分支

4. **填写 PR 信息**:

**标题**:
```
feat(角色D): 完成问卷填写、数据可视化和系统测试功能
```

**描述** (使用以下模板):

```markdown
## 📝 功能概述

本次PR实现了角色D的完整功能，包括：
- ✅ 问卷填写页面（前端）
- ✅ 数据可视化（统计分析页面）
- ✅ 系统测试（完整测试报告）
- ✅ 测试数据管理（5组mock数据）
- ✅ 数据切换工具（跨平台脚本）

## 🎯 主要变更

### 新增功能
- **前端项目**: 完整的React + Vite项目
  - 问卷填写页面（FillPage）
  - 统计分析页面（StatisticsPage）
  - 首页导航（HomePage）
  - 图表组件（PieChart, BarChart, TextAnswerList）
  - API服务封装

- **测试数据**: 5组不同场景的测试数据集
  - init-data-set1.sql: 基础测试数据
  - init-data-set2.sql: 多选题目测试
  - init-data-set3.sql: 文本题目测试
  - init-data-set4.sql: 复杂场景测试
  - init-data-set5.sql: 边界测试

- **工具脚本**: 跨平台数据切换工具
  - switch-data.ps1 (PowerShell)
  - switch-data.sh (Bash)
  - switch-data.bat (CMD)
  - Mock.ps1 (一键启动脚本)

- **项目文档**: 完整的开发文档
  - 开发文档.md
  - 角色D-接口文档.md
  - 问卷实现.md

### 问题修复
- ✅ 修复JPA LAZY加载问题（QuestionnaireServiceImpl）
  - 添加`@Transactional(readOnly = true)`确保懒加载数据正确加载
  - 手动触发`questions`和`options`的加载

- ✅ 修复JSON循环引用问题
  - 在所有实体类中添加`@JsonIgnore`注解
  - 防止序列化时的无限递归

### 文件变更统计
- **新增文件**: 50+ 个
- **修改文件**: 8 个
- **代码行数**: +6441 行

## 🧪 测试情况

- ✅ 功能测试: 42个测试用例，39个通过
- ✅ 接口测试: 所有API接口测试通过
- ✅ 集成测试: 前后端集成测试通过
- ✅ 边界测试: 异常情况处理正常

详细测试报告请参考: `docs/角色D-完整测试报告.md`

## 📚 相关文档

- 开发文档: `docs/开发文档.md`
- 接口文档: `docs/角色D-接口文档.md`
- 测试报告: `docs/角色D-完整测试报告.md`

## 🔍 代码审查要点

请重点关注：
1. 前端组件的代码质量和可维护性
2. API接口的数据格式和错误处理
3. 数据库查询的性能优化
4. 测试数据的完整性和覆盖度

## ✅ 检查清单

- [x] 代码已通过本地测试
- [x] 已更新相关文档
- [x] 已添加必要的注释
- [x] 已更新.gitignore
- [x] 提交信息符合规范
- [x] 无敏感信息泄露

## 🚀 部署说明

### 前端部署
```bash
cd frontend
npm install
npm run build
```

### 后端部署
```bash
mvn clean package
java -jar target/smart-survey-system-*.jar
```

### 数据库初始化
```bash
# 使用任意一组测试数据
cd scripts
.\switch-data.ps1 -Dataset 1
```

## 👥 相关人员

- **开发者**: [您的名字]
- **角色**: 角色D（前端开发、数据可视化、系统测试）
- **审查者**: 仓库管理员

---

**注意**: 请仓库管理员审查后合并到master分支。
```

5. **点击 "Create pull request"**

### 步骤5: 等待审查和合并

- ⏳ 等待仓库管理员审查代码
- 📝 根据反馈进行修改（如有需要）
- ✅ 管理员合并PR后，代码将合并到原仓库的master分支

## 🔄 后续操作（PR合并后）

### 1. 同步原仓库的最新代码

```bash
# 从原仓库拉取最新代码
git fetch origin

# 更新本地master分支
git checkout master
git pull origin master

# 删除已合并的功能分支（可选）
git branch -d feature/role-d-questionnaire-filling
```

### 2. 更新您的 Fork

```bash
# 从原仓库拉取最新代码到您的 Fork
git fetch origin
git checkout master
git merge origin/master

# 推送到您的 Fork
git push fork master
```

## 📋 完整操作流程总结

```bash
# 1. Fork 原仓库（在 GitHub 网页上操作）

# 2. 添加 Fork 作为远程仓库
git remote add fork https://github.com/您的用户名/smart-survey-system.git

# 3. 推送功能分支到您的 Fork
git push -u fork feature/role-d-questionnaire-filling

# 4. 在 GitHub 创建 PR（从您的 Fork 到原仓库）

# 5. 等待审查和合并
```

## ⚠️ 注意事项

1. **不要直接push到原仓库**: 您没有权限，必须通过 Fork + PR 方式
2. **保持 Fork 更新**: 定期从原仓库同步最新代码
3. **清晰的PR描述**: 帮助审查者理解变更
4. **及时响应反馈**: 根据审查意见及时修改代码

## 🆘 常见问题

### Q: Fork 后如何更新代码？
A: 
```bash
# 从原仓库拉取最新代码
git fetch origin
git checkout master
git merge origin/master
git push fork master
```

### Q: 如何修改 PR？
A: 在您的 Fork 的功能分支上继续提交，PR 会自动更新

### Q: PR 被拒绝怎么办？
A: 根据反馈修改代码，继续推送到您的 Fork，PR 会自动更新

### Q: 如何撤销 Fork？
A: 在 GitHub 的 Fork 仓库设置中，可以删除 Fork（但通常不需要）

---

**最后更新**: 2025-01-XX

