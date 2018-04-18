# Unit Test基础

## 作业说明

### 测试用例中的换行

由于本机Windows开发，控制台输出测试用例中的所有换行都使用\r\n，提交作业到学院时发现编程无法通过，怀疑是服务器环境的问题，因此修改换行符为\n后，再次提交BuildSuccess。

## 测出实现代码中的BUG

### 1. AnswerGenerator类中generate()方法调用了randomIntGenerator.generateNums(9,4)方法，
这里的9是digitmax，在generateNums方法中通过random.nextInt(digitmax)生成0到digitmax随机数，
但是nextInt方法取的是开区间，因此如果想得到0~9，这里的digitmax应该写成10而不是9.

### 2. Game类中的checkStatus()方法有BUG,测试过程中发现如果猜测数字6次，最后一次成功，按照任务需求应该输出
success但是由于判断条件是次数判断在前，因此最后输出的是fail，应该将判断顺序进行调整.

## 练习描述

实现猜数字的游戏。游戏有四个格子，每个格子有一个0到9的数字，任意两个格子的数字都不一样。你有6次猜测的机会，如果猜对则获胜，否则失败。每次猜测时需依序输入4个数字，程序会根据猜测的情况给出xAxB的反馈，A前面的数字代表位置和数字都对的个数，B前面的数字代表数字对但是位置不对的个数。

例如：答案是1 2 3 4， 那么对于不同的输入，有如下的输出

 

**Example**：

> 答案是1 2 3 4， 那么对于不同的输入，有如下的输出
 

```
Input　　    Output             Instruction
1 5 6 7      1A0B                 1 correct
2 4 7 8      0A2B                 2 and 4 wrong position 
0 3 2 4      1A2B                 4 correct，2 and 3 wrong position
5 6 7 8      0A0B                 all wrong
4 3 2 1      0A4B                 4 numbers position wrong
1 2 3 4      4A0B                 win, all correct
1 1 2 3    Wrong Input，Input again
1 2        Wrong Input，Input again
```
 
答案在游戏开始时随机生成。输入只有6次机会，在每次猜测时，程序应给出当前猜测的结果，以及之前所有猜测的数字和结果以供玩家参考。输入界面为控制台（Console），以避免太多与问题无关的界面代码。
输入时，用空格分隔数字。

要求：
- 设计和编写测试用例
- 单元测试应涵盖所有核心业务逻辑
- 用小步骤进行单元测试重构
- 为单元测试和方法命名有意义的名称
- 代码通过小步骤提交并附上意义的评论

## 环境要求
- Java 8

## 如何开始

- 克隆模版库
- 在项目中`src/main`目录下的运行`Main.java`文件
  - 出现`Guess Number Game, You have 6 chances to guess!`，说明项目启动成功
- 在项目中`src/test`目录下完成对应的单元测试

## 如何测试
- 根目录下执行`./gradlew clean test`，查看测试结果

## 输出规范
- 完成需求的代码及测试
