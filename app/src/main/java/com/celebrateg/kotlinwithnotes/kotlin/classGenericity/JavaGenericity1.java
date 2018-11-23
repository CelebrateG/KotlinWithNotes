package com.celebrateg.kotlinwithnotes.kotlin.classGenericity;

import com.example.issuser.myapplication.kotlin.classExtends.SubClass1;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author CelebrateG
 * @Description java中的泛型
 * @Date 2018/10/30
 */
public class JavaGenericity1 {
    /**
     * 查看 Collection 接口的 addAll 方法
     * ? extends E 表示此方法接受 E 或者 E 的 一些子类型对象的集合，
     * 这意味着我们可以安全地从其中读取 E，但不能写入
     * 带 extends 限定（上界）的通配符类型使得类型是协变的
     */
    List<String> list = new ArrayList<>();

    /**
     * 逆变性
     * 只能调用接受 SubClass1 作为参数的方法
     */
    List<? super SubClass1> list2 = new ArrayList<>();

    /**
     * 只接受 SubClass1 作为参数的方法
     */
    List<SubClass1> list3 = new ArrayList();

    public void demo2(){
        list.add("1");
        list2.add(new SubClass1(2));
        list3.add(new SubClass1(3));
//        list2.add(new Base()); //使用别的类型会编译错误
        Object object = list2.get(0);
        Object object2 = list3.get(0);
        SubClass1 sb1 = (SubClass1) list2.get(0);
        SubClass1 sb2 = list3.get(0);
    }

}

