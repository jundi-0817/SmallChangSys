package com.jundi.smallchange;

/**
 * @author jundi
 * @version 1.0
 * @date 2021/9/30 15:08
 * 这里我们直接调用SmallChangeSysOOp 对象，显示主菜单即可
 */
public class SmallChangeSysApp {
    public static void main(String[] args) {
        System.out.println("======hello公司=====");
        new SmallChangeSysOOP().mainMenu();
    }
}
