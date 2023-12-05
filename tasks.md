# 任务拆解

---

* given：-l
* when：parse("-l")
* then：

| flag1   |
|---------|
| logging |
| true    |

---

* given：empty_args
* when：parse("")
* then：

| flag1   |
|---------|
| logging |
| false   |

---

* given：-l -p 8080
* when：parse("-l -p 8080")
* then：

| flag1   | flag2 |
|---------|-------|
| logging | port  |
| true    | 8080  |

---

* given：-l -p 8080 -d /usr/logs
* when：parse("-l -p 8080 -d /usr/logs")
* then：

| flag1   | flag2 | flag3     |
|---------|-------|-----------|
| logging | port  | directory |
| true    | 8080  | /usr/logs |

---

* given：-p -d
* when：parse("-p -d")
* then：

| flag1   | flag2 | flag3        |
|---------|-------|--------------|
| logging | port  | directory    |
| false   | 8080  | /usr/default |

---

* given：-l
* when：parse("-l")
* then：

| flag1   |
|---------|
| logging |
| true    |
| Boolean |
---

* given：empty
* when：parse("")
* then：

| flag1   |
|---------|
| logging |
| false   |
| Boolean |

---
* given：-l -p 8080
* when：parse("-l -p 8080")
* then：

| flag1   | flag2   |
|---------|---------|
| logging | port    |
| true    | 8080    |
| Boolean | Integer |

---

* given：-l -p 8080 -d /usr/logs
* when：parse("-l -p 8080 -d /usr/logs")
* then：

| flag1   | flag2   | flag3     |
|---------|---------|-----------|
| logging | port    | directory |
| true    | 8080    | /usr/logs |
| Boolean | Integer | String    |

---
* given：empty
* when：parse("")
* then：

| flag1   | flag2   | flag3     |
|---------|---------|-----------|
| logging | port    | directory |
| false   | 0       | ""        |
| Boolean | Integer | String    |