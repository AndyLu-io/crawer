# PlantUML简易教程

[TOC]

## 用例图（use case）

### 语法

| 语法                    | 含义                 | 备注                        |
| ----------------------- | -------------------- | --------------------------- |
| ()                      | 绘制椭圆用例         | usecase 关键字也可定义 用例 |
| ::                      | 绘制小人角色         | actor 也可定义 角色         |
| ->                      | 连接线               | 中横线越多 连接线越长       |
| left to right direction | 将用例转换为从左向右 | 默认从上到下                |

### 案例

#### 场景

采购 上架商品 并 设置成本价

运营 设置公司商品利润

门店 设置门店利润

消费者 购买商品

#### code

```wiki
@startuml
left to right direction
actor 采购
usecase 设置利润

采购 ----> (上架)
采购 ----> (设置成本价)
:运营: ----> 设置利润
:门店: ---> 设置利润
:消费者: --> (购买)

(上架) --> (商品)
(设置成本价) --> (商品)
(设置利润) --> (商品)
(购买) --> (商品)
@enduml
```

#### 效果图

![UseCase](https://xgpub.oss-cn-hangzhou.aliyuncs.com/2018/Q2/plantUmlInAction/demoPic/UseCase.png)



## 组件图(component)

### 语法

| 语法                                            | 含义            | 备注                                                         |
| ----------------------------------------------- | --------------- | ------------------------------------------------------------ |
| []                                              | 绘制长方形组件  | component 关键字也可定义组件                                 |
| -->                                             | 连接线          | .. 无箭头虚线<br /> -- 无箭头实线                            |
| package {groupName} {<br />    component<br />} | 组件分组,可嵌套 | 与package 类似的功能还有<br />node 节点<br />cloud 云<br />database 数据库<br /> frame 框架<br /> folder 文件夹 |

### 案例

#### 场景

1. 素材

   维护于 OPE 后台

   提供dubbo 服务能力，用于前端展示

2. 身份证信息

   由Mall提供前端能力，用于用户上传

所有上传的图片全部存储到阿里云OSS

#### code

```wiki
@startuml
package Mall {
    [展示素材]
    [用户上传身份证图片]
}

node dubbo1 {
    [分布式服务调度1]

    [展示素材] --> [分布式服务调度1]
}
node dubbo2 {
    [分布式服务调度2]

    [用户上传身份证图片] --> [分布式服务调度2]
}

package OPE {
    frame SpringMVC {
        [素材后台维护服务]
    }
    frame dubbo {
        [身份证上传服务]
        [素材前端展示服务]

        [分布式服务调度1] --> [素材前端展示服务]
        [分布式服务调度2] --> [身份证上传服务]
    }
}

database MySql {
    [t_idcard]
    [t_material]

    [素材后台维护服务] ----> [t_material]
    [素材前端展示服务] ----> [t_material]
    [身份证上传服务] ----> [t_idcard]
}

cloud 阿里云OSS {
    folder 身份证图 {
        [201801]
        [201802]
    }
    folder 素材图 {
        [201803]
        [201804]
    }

    [素材后台维护服务] ....> 素材图
    [身份证上传服务] ....> 身份证图
}
@enduml
```

#### 效果图

![component](https://xgpub.oss-cn-hangzhou.aliyuncs.com/2018/Q2/plantUmlInAction/demoPic/component.png)



## 类图（class）

### 语法

| 语法                                                      | 含义                                                        | 备注                                                         |
| --------------------------------------------------------- | ----------------------------------------------------------- | ------------------------------------------------------------ |
| class {className} {<br />   field<br />   method()<br />} | 绘制一个单列的表格，<br />识别到()自动判定为方法            | class可被替换为<br />abstract 抽象类<br />interface 接口<br />enum 枚举<br /> annotation  注解 |
| {field}，{method}                                         | 强转                                                        | {field}  强制该行为属性<br /> {method} 强制改行为方法        |
| <--                                                       | 连接线<br />                                                | <\|--  继承关系<br />  *-- 组合关系<br />  o-- 聚合关系      |
| “ ”                                                       | 连接线 两端的 “ ” 内容会被展示在连接线的两端                | 如 “1” *-- “many”                                            |
| :                                                         | 放于2个类关系的 末尾，<br />用于在连接线中段描述2个类的关系 | 如 A o-- B : contains                                        |
| -, #, ~, +                                                | 访问权限                                                    | - private<br /># protected<br />~ default<br />+ public      |
| {static}，{abstract}                                      | 修饰符                                                      | {static} 静态<br />{abstract} 抽象                           |

### 案例

#### 场景

1. 你家开了个牧场 养了一群牛。是的 每天都能赚很多钱
2. 牛是个动物，并且有躯干
3. 动物能行走，用脚走，几只脚？ 随意
4. 牛的躯干 是由 身体 和 头组成的。牛吃草
5. 身体上是有皮肤的 皮肤有肤色。身体有存储功能，还能消化食物。

#### code

```wiki
@startuml
enum SkinColor {
    BLACK
    YELLOW
    BROWN
}

interface Animal {
    + move()
}

abstract Walk {
    # footNum
    # useFeet()
}

class Head {
    - size
    - thinking()
}

class Body {
    - Skin bodySkin
    - {field} storageCapacity(存储容量)
    + {method} digestiveFood //消化食物
}

class Skin {
    - SkinColor skinColor
    + getSkinColor()
}

class Truncus {
    - Head head
    - Body body
    + getHead()
    + getBody()
}

class Cow {
    - Truncus truncus
    ~ {static} eatGreens()
}

class Farm {
    - {static} makeMoneyCountPerDay
    - List<Cow> cowList;
}

Walk --|> Animal
Cow --|> Walk

Body --* Skin: contasin
Skin -o SkinColor : has a

Truncus --* Head : contains
Truncus --* Body : contains

Cow --o Truncus : has a

Farm "1" --o "many" Cow
@enduml
```

#### 效果图

![class](http://7xkkn6.com1.z0.glb.clouddn.com/plantUmlInAction/demoPic/class.png)



## 活动图

### 语法

| 语法                                                         | 含义             | 备注                                                         |
| ------------------------------------------------------------ | ---------------- | ------------------------------------------------------------ |
| : ;                                                          | 绘制圆角矩形     | :;中的格式能被保留，如换行                                   |
| start, stop, end                                             | 开始，停止，结束 |                                                              |
| if({condition}) then(yes/no)<br />else(yes/no)<br />endif    | 条件语句         |                                                              |
| while ({condition}) <br />is(yes/no) <br />endwhile (yes/no) | while 循环       | **is(yes/no)** 和  **endwile(yes/no) 中的 (yes/no)** 是非必须的 |
| fork<br />fork again<br />end fork                           | 并行             |                                                              |
| ->                                                           | 连接线           | 在连接线 后追加的文字 会被放在连接线中间<br /> -[#{color} ,{lineStyle}]-> 连接线 颜色和风格 |
| \|#{color}\|{swimlane}\|                                     | 泳道             |                                                              |

### 案例

#### 场景

简单描述海拍客毅行活动

1. 西溪壹号楼下集合 前三名到齐队伍 有特权卡
2. 全员参与合作完成跳绳10个
3. 去烟霞洞，完成套圈圈游戏
4. 去文体中心 开会。

#### code

```wiki
@startuml
|#63B8FF|西溪壹号楼下|
start
:hipac 毅行;
:开始行程;

if(是否前三名到齐队伍?) then(是)
    :领取特权卡;
else(否)

endif

while(是否小组所有成员合\n作完成跳大绳10个？) is(否)
    :跳大绳游戏;
endwhile(是)

fork
:男士坐公交;
fork again
:女士打车;
end fork
|#00CD66|西湖景区|
:烟霞洞公交站集合;

while(是否完成套圈圈游戏？) is (否)
    :套圈圈游戏;
endwhile(是)

:包公交返回;

|文体中心|
:开会;
:结束行程;
stop
@enduml
```

#### 效果图

![class](https://xgpub.oss-cn-hangzhou.aliyuncs.com/2018/Q2/plantUmlInAction/demoPic/activity.png)



## 时序图

### 语法

| 语法                             | 含义                         | 备注                                                         |
| -------------------------------- | ---------------------------- | ------------------------------------------------------------ |
|                                  | 绘制矩形参与者               | 无需声明，一串普通的文字即被识别为参与者<br />除了普通的矩形外还有如下参与者，形状各不相同<br /> actor  角色小人<br />  boundary  边界<br />  control  控制器<br />  entity 实体<br />  database 数据库<br /> collections 集合 |
| ->                               | 消息用于 2个参与者间相互通信 | -> 为实线<br />--> 为虚线                                    |
| :                                | 消息描述，置于语句末         |                                                              |
| autonumber {start}{increment }   | 自动编号                     | 为所有消息自动编号<br />start 初始值<br />increment 每次累加值 |
| alt/else                         | 消息分组 功能为if else       | 与该功能类似的功能还有<br />  loop  功能为循环               |
| note left / right <br />end note | 注解                         | 作为注解 紧跟在消息行 后一行。<br />end note 可选。如果不使用 则为单行注解 |
| == {divider} ==                  | 分割线                       |                                                              |
| … {delay}...                     | 延迟                         | 原本表达的是，消息延迟返回。<br />但是用来 省略长调用中的 无关调用非常爽啊 |
| activate ,  deactivate           | 生命线                       | 表达一个调用链路的开始结束<br />activate 生命开始<br />deactivate 生命结束 |

### 案例

#### 场景

简单描述一个获取商品列表分页查询

1. Spring MVC 分层设计 controller 调用service
2. service 调用 商品中心获取商品（此处内容省略），调用价格中心获取价格
3. 通过商品 构建器 ItemBuilder 构建商品价格信息

#### code

```wiki
@startuml
control ItemController
autonumber 10 10

activate ItemController
    activate ItemService #1E90FF
        ItemController -> ItemService : queryItemPagination\n分页查询商品列表
        alt 是门店

            ItemService -> ItemService : queryShopItemPagination\n 门店获取商品列表
            activate ItemService #00FFFF
            deactivate ItemService
        else 是消费者
            ItemService -> ItemService : queryCustomerItemPagination\n 消费者获取商品列表
            activate ItemService #00FFFF
            deactivate ItemService
        end
    deactivate ItemService

    ... {省略调用商品中心 获取商品信息}...

    == {构建商品价格信息} ==
    ItemService -> 商品价格中心: 通过商品id列表 获取商品价格列表
    activate ItemService
        activate 商品价格中心
            ItemService <-- 商品价格中心: 返回商品价格列表
        deactivate 商品价格中心
        loop 每页数量
            ItemService -> ItemBuilder: 循环构建每个商品价格信息
            activate ItemBuilder
            ItemService <-- ItemBuilder: 返回构建好的商品模型列表
            deactivate ItemBuilder
        end
    deactivate ItemService
    ItemController <-- ItemService: 将分页信息与商品列表\n构建成展示模型返回
deactivate ItemController

@enduml
```

#### 效果图

![sequence](https://xgpub.oss-cn-hangzhou.aliyuncs.com/2018/Q2/plantUmlInAction/demoPic/sequence.png)

## 参考资料

1. [https://](https://blog.csdn.net/myfriend0/article/details/78673718)[blog.csdn.net/myfriend0/article/details/78673718](https://blog.csdn.net/myfriend0/article/details/78673718)

 （PlantUML简单示例）

1. [https://](https://www.jianshu.com/p/e92a52770832)[www.jianshu.com/p/e92a52770832](https://www.jianshu.com/p/e92a52770832)

 （介绍了如何安装PlantUML + Sublime）

1. [https://](https://www.jianshu.com/p/a6bd7e3048ef)[www.jianshu.com/p/a6bd7e3048ef](https://www.jianshu.com/p/a6bd7e3048ef)

 （介绍如何安装 PlantUML + Idea）
