package com.jundi.smallchange;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author jundi
 * @version 1.0
 * @date 2021/9/29 14:26
 */
public class SmallChangeSys {
    //化繁为简
    //1.先完成显示菜单，并可以选择
    //2.完成零钱通明细
    //3.完成收益入账
    //4.完成消费
    //5.退出
    public static void main(String[] args) {
        //定义相关的变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2. 完成零钱通明细
        // 可以把受益入账和消费，保存到数组 可以使用对象 简单的话可以使用String拼接
        String  details = "----------------零钱通明细----------------";

        //3.完成收益入账  完成功能驱动程序员增加新的变量和代码
        //定义新的变量
        double money = 0;
        double balance = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化
        Date date = null; //date 是 java.util.Date 类型，表示日期
        //4. 消费
        //定义新变量，保存消费的原因
        String note = "";
        do{

            System.out.println("======零钱通菜单======");
            System.out.println("\t\t\t1.零钱通明细");
            System.out.println("\t\t\t2.收益入账");
            System.out.println("\t\t\t3.消费");
            System.out.println("\t\t\t4.退出");

            System.out.println("请选择(1-4):");
            key = scanner.next();

            //使用switch 分支控制
            switch (key){
                case "1" :
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.println("收益入账金额：");
                    money = scanner.nextDouble();
                    //money 的值范围应该校验 -》 一会再完善
                    //找出不正确的金额条件，然后给出提示，就直接break
                    if(money <= 0) {
                        System.out.println("收益入账金额 需要 大于 0");
                        break;
                    }
                        balance += money;
                        //拼接收益入账信息到 details
                        date = new Date(); //获取当前日期
                        details += "\n收益入账 \t+" + money + "\t" + sdf.format(date) + "\t" + balance;

                    break;
                case "3" :
                    System.out.print("消费金额：");
                    money = scanner.nextDouble();
                    //money 的范围值应该校验 -》 一会在完善
                    //找出金额不正确的情况
                    //过关斩将校验法
                    if(money <= 0 || money > balance){
                        System.out.println("你的消费金额应该在0-" + balance);
                        break;
                    }
                    System.out.print("消费说明：");
                    note = scanner.next();
                    balance -= money;

                    //拼接收益入账信息到 details
                    date = new Date(); //获取当前日期

                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4" :
                    //用户输入4退出时，给出提示“你确定要退出吗？y/n”
                    //定义一个变量choice，接收用户的输入
                    //使用while + break，来处理接收到的输入时 y 或者 n
                    //退出while后，再判断choice是y还是n，就可以决定是否退出
                    //建议一段代码，完成一个小功能，尽量不要混在一起

                    String choice ="";
                    while (true){
                        System.out.println("你确定要退出吗？ y/n");
                        choice = scanner.next();
                        if("y".equals(choice)||"n".equals(choice)){
                            break;
                        }
                    }
                    //当用户退出while 后，进行判断
                    if(choice.equals("y")){
                        loop= false;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }while (loop);

        System.out.println("========退出了零钱通项目===========");
    }
}
