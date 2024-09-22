## 本项目实现的最终作用是基于SSH在线电影售票选座版网站平台系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 影片管理
 - 用户管理
 - 电影评论管理
 - 管理员登陆
 - 管理员管理
 - 订单管理
### 第2个角色为用户角色，实现了如下功能：
 - 加入购物车
 - 查看以及修改个人信息
 - 查看电影以及评论
 - 查看订单
 - 用户登陆注册
 - 用户首页
 - 订单付款
 - 评价电影
 - 选择座位
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_movie_ticket_sale

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [admin](#admin) | 管理员表 |
| [comment](#comment) | 评价表 |
| [film](#film) |  |
| [film_seat](#film_seat) |  |
| [orders](#orders) | 订单信息表 |
| [order_item](#order_item) | 订单子项表 |
| [user](#user) | 用户表 |

**表名：** <a id="admin">admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | adminname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 管理员名称  |
|  3   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  5   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |

**表名：** <a id="comment">comment</a>

**说明：** 评价表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | reply |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 回复  |
|  6   | replyTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  7   | film_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  9   | isReply |   int   | 10 |   0    |    N     |  N   |       |   |

**表名：** <a id="film">film</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | endTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 结束时间  |
|  3   | image |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 图片  |
|  4   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | isRecommend |   int   | 10 |   0    |    N     |  N   |       |   |
|  6   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  7   | price |   double   | 23 |   0    |    N     |  N   |       | 价格  |
|  8   | remark |   varchar   | 5000 |   0    |    Y     |  N   |   NULL    | 标记备注  |
|  9   | startTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 开始时间  |

**表名：** <a id="film_seat">film_seat</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | z1 |   int   | 10 |   0    |    N     |  N   |       |   |
|  3   | z10 |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | z11 |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | z12 |   int   | 10 |   0    |    N     |  N   |       |   |
|  6   | z13 |   int   | 10 |   0    |    N     |  N   |       |   |
|  7   | z14 |   int   | 10 |   0    |    N     |  N   |       |   |
|  8   | z15 |   int   | 10 |   0    |    N     |  N   |       |   |
|  9   | z16 |   int   | 10 |   0    |    N     |  N   |       |   |
|  10   | z17 |   int   | 10 |   0    |    N     |  N   |       |   |
|  11   | z18 |   int   | 10 |   0    |    N     |  N   |       |   |
|  12   | z19 |   int   | 10 |   0    |    N     |  N   |       |   |
|  13   | z2 |   int   | 10 |   0    |    N     |  N   |       |   |
|  14   | z20 |   int   | 10 |   0    |    N     |  N   |       |   |
|  15   | z21 |   int   | 10 |   0    |    N     |  N   |       |   |
|  16   | z22 |   int   | 10 |   0    |    N     |  N   |       |   |
|  17   | z23 |   int   | 10 |   0    |    N     |  N   |       |   |
|  18   | z24 |   int   | 10 |   0    |    N     |  N   |       |   |
|  19   | z25 |   int   | 10 |   0    |    N     |  N   |       |   |
|  20   | z26 |   int   | 10 |   0    |    N     |  N   |       |   |
|  21   | z27 |   int   | 10 |   0    |    N     |  N   |       |   |
|  22   | z28 |   int   | 10 |   0    |    N     |  N   |       |   |
|  23   | z29 |   int   | 10 |   0    |    N     |  N   |       |   |
|  24   | z3 |   int   | 10 |   0    |    N     |  N   |       |   |
|  25   | z30 |   int   | 10 |   0    |    N     |  N   |       |   |
|  26   | z4 |   int   | 10 |   0    |    N     |  N   |       |   |
|  27   | z5 |   int   | 10 |   0    |    N     |  N   |       |   |
|  28   | z6 |   int   | 10 |   0    |    N     |  N   |       |   |
|  29   | z7 |   int   | 10 |   0    |    N     |  N   |       |   |
|  30   | z8 |   int   | 10 |   0    |    N     |  N   |       |   |
|  31   | z9 |   int   | 10 |   0    |    N     |  N   |       |   |
|  32   | film_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="orders">orders</a>

**说明：** 订单信息表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  3   | orderTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  4   | status |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  5   | total |   double   | 23 |   0    |    N     |  N   |       | 总计  |
|  6   | uid |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  7   | user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  8   | isRemark |   int   | 10 |   0    |    N     |  N   |       |   |
|  9   | film_seat_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  10   | seat |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="order_item">order_item</a>

**说明：** 订单子项表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | count |   int   | 10 |   0    |    N     |  N   |       | 数量  |
|  3   | subtotal |   double   | 23 |   0    |    Y     |  N   |   NULL    | 金额  |
|  4   | film_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | orders_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  6   | film_seat_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  7   | seat |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="user">user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  3   | loginName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  5   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  6   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |

