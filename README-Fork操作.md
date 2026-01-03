# 🍴 Fork 和 Pull Request 快速指南

## ⚠️ 重要提示

**您不是项目协作者，需要通过 Fork 方式提交 PR！**

## 🚀 快速操作步骤

### 1️⃣ Fork 原仓库

1. 访问: https://github.com/breezeys1n/smart-survey-system
2. 点击右上角 **"Fork"** 按钮
3. 等待 Fork 完成

### 2️⃣ 添加 Fork 为远程仓库

```bash
# 添加您的 Fork（替换为您的用户名）
git remote add fork https://github.com/您的用户名/smart-survey-system.git

# 验证
git remote -v
```

### 3️⃣ 推送功能分支到您的 Fork

```bash
# 确保在功能分支上
git branch
# 应该显示: * feature/role-d-questionnaire-filling

# 推送到您的 Fork
git push -u fork feature/role-d-questionnaire-filling
```

### 4️⃣ 创建 Pull Request

1. 访问您的 Fork: `https://github.com/您的用户名/smart-survey-system`
2. 点击 **"Compare & pull request"** 按钮
3. 选择:
   - **Base**: `breezeys1n/smart-survey-system` → `master`
   - **Compare**: `您的用户名/smart-survey-system` → `feature/role-d-questionnaire-filling`
4. 填写 PR 信息（模板在 `docs/Fork和PR操作指南.md` 中）
5. 点击 **"Create pull request"**

### 5️⃣ 等待审查

- ⏳ 等待仓库管理员审查
- 📝 根据反馈修改代码（继续推送到您的 Fork，PR 会自动更新）
- ✅ 管理员合并后，代码将合并到原仓库

## 📚 详细文档

- **完整指南**: `docs/Fork和PR操作指南.md` - 详细的 Fork 和 PR 操作步骤
- **PR模板**: `docs/PR提交指南.md` - PR 描述模板
- **Git推送**: `docs/Git推送指南.md` - SSH/Token 配置

## ✅ 当前状态

- ✅ 功能分支: `feature/role-d-questionnaire-filling`
- ✅ 所有代码已提交（包含 Mock.ps1）
- ✅ 工作区干净
- ⏳ 等待推送到您的 Fork 并创建 PR

---

**提示**: 如果您已经是协作者，可以直接使用 `docs/PR提交指南.md` 中的协作者方式。

